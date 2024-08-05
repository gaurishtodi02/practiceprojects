//This piece of code demonstrates a User ID and its message on a social media platform where other userID;s have commmented
//This code adds their code according to their userID and maps specific other user IDs to user's rekation.
//It also blocks irrelevant userIDs and their comments.

class Comment(
    val userId: Int,
    val message: String
)

fun main() {
    val comments: List<Comment> = listOf(
        Comment(5421, "Nice Code"),
        Comment(6624, "like it"),
        Comment(5224, "What's going on?"),
        Comment(9001, "Check out my website"),
        Comment(8818, "Hello Everyone,:)"),
    )

    val blockUserIds: Set<Int> = setOf(5224, 9001)

    val userIdToRelation: Map<Int, String> = mapOf(
        5421 to  "friend",
        6624  to "close friend"
    )
    for (comment in comments) {
        if (comment.userId !in blockUserIds) {
            val relation = userIdToRelation[comment.userId] ?: "Unknown"
            println("Comment ${comment.message} from $relation")
        }
    }
}



