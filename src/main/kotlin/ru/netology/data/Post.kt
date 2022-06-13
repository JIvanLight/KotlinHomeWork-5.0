package ru.netology.data

data class Post(
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String,
    val postSource: PostSource?,
    val attachments: Array<Attachment>?,
    val geo: Geo?,
    val signerId: Int,
    val copyHistory: Array<Post>?,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val dunut: Donut?,
    val id: Int = 0
) {
    data class Comments(
        val count: Int,
        val canPost: Boolean,
        val groupsCanPost: Boolean,
        val canClose: Boolean,
        val canOpen: Boolean
    )

    data class Copyright(
        val id: Int,
        val link: String,
        val name: String,
        val type: String
    )

    data class Likes(
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean
    )

    data class Reposts(
        val count: Int,
        val userReposted: Boolean
    )

    data class Views(
        val count: Int
    )

    data class PostSource(
        val type: String,
        val platform: String,
        val data: String,
        val url: String
    )

    data class Geo(
        val type: String,
        val coordinates: String,
        val place: Any
    )

    data class Donut(
        val isDonut: Boolean,
        val paidDuration: Int,
        val placeholder: Any,
        val canPublishFreeCopy: Boolean,
        val editMode: String
    )

    sealed class Attachment {
        abstract val type: String
    }

    data class PhotoAttachment(val photo: Photo) : Attachment() {
        override val type = "photo"

        data class Photo(
            val id: Int,
            val ownerId: Int,
            val photo130: String,
            val photo604: String
        )
    }

    data class VideoAttachment(val video: Video) : Attachment() {
        override val type = "video"

        data class Video(
            val id: Int,
            val ownerId: Int,
            val title: String,
            val description: String,
            val duration: Int,
            val image: Array<Image>,
            val firstFrame: Array<FirstFrame>,
            val date: Int,
            val addingDate: Int,
            val views: Int,
            val localViews: Int,
            val comments: Int,
            val player: String,
            val platform: String,
            val canAdd: Boolean,
            val isPrivate: Boolean,
            val accessKey: String,
            val processing: Boolean,
            val isFavorite: Boolean,
            val canComment: Boolean,
            val canEdit: Boolean,
            val canLike: Boolean,
            val canRepost: Boolean,
            val canSubscribe: Boolean,
            val canAddToFaves: Boolean,
            val canAttachLink: Boolean,
            val width: Int,
            val height: Int,
            val userId: Int,
            val converting: Boolean,
            val added: Boolean,
            val isSubscribed: Boolean,
            val repeat: Boolean,
            val type: String,
            val balance: Int,
            val liveStatus: String,
            val live: Boolean,
            val upcoming: Boolean,
            val spectators: Int,
            val likes: Likes,
            val reposts: Reposts,
        ) {
            data class Image(
                val height: Int,
                val url: String,
                val width: Int,
                val widthPadding: Boolean
            )

            data class FirstFrame(
                val height: Int,
                val url: String,
                val width: Int
            )

            data class Likes(
                val count: Int,
                val userLikes: Boolean,
            )

            data class Reposts(
                val count: Int,
                val wallCount: Int,
                val mailCount: Int,
                val userReposted: Boolean
            )
        }
    }

    data class AudioAttachment(val audio: Audio) : Attachment() {
        override val type = "audio"

        data class Audio(
            val id: Int,
            val ownerId: Int,
            val artist: String,
            val title: String,
            val duration: Int,
            val url: String,
            val lyricsId: Int,
            val albumId: Int,
            val genreId: Int,
            val date: Int,
            val noSearch: Boolean,
            val isHq: Boolean
        )
    }

    data class LinkAttachment(val link: Link) : Attachment() {
        override val type = "link"

        data class Link(
            val url: String,
            val title: String,
            val caption: String,
            val description: String,
            val photo: Photo?,
            val product: Product?,
            val button: Button?,
            val previewPage: String,
            val previewUrl: String
        ) {
            data class Photo(
                val id: Int,
                val albumId: Int,
                val ownerId: Int,
                val userId: Int,
                val text: String,
                val date: Int,
                val sizes: Array<Size>,
                val width: Int,
                val height: Int
            ) {
                data class Size(
                    val type: String,
                    val url: String,
                    val width: Int,
                    val height: Int
                )
            }

            data class Product(val price: Price) {
                data class Price(
                    val ammount: Long,
                    val currency: Currency,
                    val text: String
                ) {
                    data class Currency(
                        val id: Int,
                        val name: String
                    )
                }
            }

            data class Button(
                val title: String,
                val action: Action
            ) {
                class Action(
                    val type: String = "openURL",
                    val url: String
                )
            }
        }
    }

    data class StickerAttachment(val sticker: Sticker) : Attachment() {
        override val type = "sticker"

        data class Sticker(
            val productId: Int,
            val stickerId: Int,
            val images: Array<Image>,
            val imagesWithBackground: Array<Image>,
            val animationURL: String,
            val isAllowed: Boolean
        ) {
            data class Image(
                val url: String,
                val width: Int,
                val height: Int
            )
        }
    }
}