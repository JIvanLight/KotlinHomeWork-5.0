import org.junit.Test

import org.junit.Assert.*
import ru.netology.data.*
import ru.netology.service.*
import ru.netology.data.Post.*
import ru.netology.exceptions.PostNotFoundException

class WallServiceTestCreateComment{
    @Test (expected = PostNotFoundException::class)
    fun createCommentShouldThrow(){
        val service = WallService()
        val post = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825676,
            text = "Hello, Java!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        service.add(post)
        service.add(post)
        service.add(post)

        val comment = Comment(
            fromId = 4654,
            date = 1654826532,
            text = "Вау!",
            donut = null,
            replyToUser = 0,
            replyToComment = 0,
            attachments = null,
            parentsStack = null,
            thread = null
            )

        service.createComment(4, comment)
    }
}
class WallServiceTestAdd {
    @Test
    fun add() {
        val service = WallService()
        val post = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825676,
            text = "Hello, Java!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )
        val postExpected = post.copy(id = 1)

        val postControl = service.add(post)

        assertEquals(postExpected, postControl)
    }
}

class WallServiceTestUpdate {

    @Test
    fun updateTrue() {
        val service = WallService()
        val post1 = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825676,
            text = "Hello, Java!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        val post2 = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825824,
            text = "Hello, Git!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        val post3 = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825927,
            text = "Hello, Kotlin!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        val postUpdate = Post(
            id = 3,
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825999,
            text = "Hello, Android!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        service.add(post1)
        service.add(post2)
        service.add(post3)

        val result = service.update(postUpdate)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService()
        val post1 = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825676,
            text = "Hello, Java!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        val post2 = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825824,
            text = "Hello, Git!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        val post3 = Post(
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825927,
            text = "Hello, Kotlin!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        val postUpdate = Post(
            id = 4,
            ownerId = 4527,
            fromId = 4527,
            createdBy = 23,
            date = 1654825999,
            text = "Hello, Android!",
            replyOwnerId = 545,
            replyPostId = 77,
            friendsOnly = false,
            comments = Comments(
                count = 0,
                canPost = false,
                groupsCanPost = false,
                canClose = true,
                canOpen = true
            ),
            copyright = Copyright(
                id = 0,
                link = "",
                name = "",
                type = ""
            ),
            likes = Likes(
                count = 0,
                userLikes = false,
                canLike = true,
                canPublish = true
            ),
            reposts = Reposts(
                count = 0,
                userReposted = false
            ),
            views = Views(
                count = 1
            ),
            postType = "post",
            postSource = null,
            attachments = null,
            geo = null,
            signerId = 0,
            copyHistory = null,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = null
        )

        service.add(post1)
        service.add(post2)
        service.add(post3)

        val result = service.update(postUpdate)

        assertFalse(result)
    }
}