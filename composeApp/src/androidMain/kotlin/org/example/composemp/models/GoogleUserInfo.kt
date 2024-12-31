
import com.auth0.android.jwt.JWT


data class GoogleUserInfo(
    val name: String?,
    val email: String?,
    val pictureUrl: String?
)

class GoogleUserInfoExtractor {

    // Function to extract information from the userIdToken
    fun extractUserInfo(userIdToken: String): GoogleUserInfo? {
        return try {
            val jwt = JWT(userIdToken) // Decode the JWT token

            // Extract the claims
            val name = jwt.getClaim("name").asString()
            val email = jwt.getClaim("email").asString()
            val pictureUrl = jwt.getClaim("picture").asString()

            // Return a data class with the extracted user info
            GoogleUserInfo(name = name, email = email, pictureUrl = pictureUrl)
        } catch (e: Exception) {
            // Handle errors (e.g., invalid token)
            e.printStackTrace()
            null
        }
    }
}
