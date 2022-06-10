package ru.netology.service

import ru.netology.data.Post

class WallService {
    private var posts = emptyArray<Post>()
    private var lastId = 0

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
}