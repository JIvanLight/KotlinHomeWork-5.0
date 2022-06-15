package ru.netology.service

import ru.netology.data.Comment
import ru.netology.data.Post
import ru.netology.exceptions.PostNotFoundException

class WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0
    private var comments = emptyArray<Comment>()
    private var lastIdPostComment = 0

    fun add(post: Post): Post {
        lastId++
        val postWithId = post.copy(id = lastId)
        posts += postWithId
        return postWithId
    }

    fun update(post: Post): Boolean {
        for ((index, element) in posts.withIndex()) {
            if (element.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for (element in posts) {
            if (element.id == postId) {
                lastIdPostComment++
                val commentWhithId = comment.copy(id = lastIdPostComment)
                comments += commentWhithId
                return commentWhithId
            }
        }
        throw PostNotFoundException("Пост с id $postId не существует")
    }
}