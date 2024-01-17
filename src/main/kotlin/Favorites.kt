
interface Favorites {
    val firstName: String
    val favoriteThings: List<String>

    // This function does not see the delegate's implementation of favoriteThings, but
    // instead sees the original underlying object.
    fun format(): String {
        val favorites = favoriteThings.joinToString("\n") { "    $it" }
        return "person $firstName {\n$favorites\n}"
    }
}
