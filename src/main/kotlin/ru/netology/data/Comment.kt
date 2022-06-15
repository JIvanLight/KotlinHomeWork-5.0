package ru.netology.data

data class Comment(
    val fromId: Int,
    val date: Int,
    val text: String,
    val donut: Donut?,
    val replyToUser: Int,
    val replyToComment: Int,
    val attachments: Array<Attachment>?,
    val parentsStack: Array<Comment>?,
    val thread: Thread?,
    val id: Int = 0
) {

    data class Donut(
        val isDonut: Boolean,
        val placeholder: String = "Платный контент недоступен",
    )

    data class Thread(
        val count: Int,
        val items: Array<Comment>,// Only for metod wall.getComments
        val canPost: Boolean,
        val showReplyButton: Boolean,
        val groupsCanPost: Boolean
    )

    sealed class Attachment {
        abstract val type: String

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
}
