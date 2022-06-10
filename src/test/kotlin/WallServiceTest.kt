import org.junit.Test

import org.junit.Assert.*
import ru.netology.data.Post
import ru.netology.service.WallService

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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
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
            comments = Unit,
            copyright = Unit,
            likes = Unit,
            reposts = Unit,
            views = Unit,
            postType = "post",
            signerId = 0,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = false,
            markedAsAds = false,
            isFavorite = false,
            dunut = Unit
        )

        service.add(post1)
        service.add(post2)
        service.add(post3)

        val result = service.update(postUpdate)

        assertFalse(result)
    }
}