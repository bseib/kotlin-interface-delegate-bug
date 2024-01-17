import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestFavoritesWithDelegates {

    @Test
    fun `can call an interface function on a delegate object instance`() {
        val person = object : Favorites {
            override val firstName = "Sam"
            override val favoriteThings = listOf("foo", "bar", "baz", "qux")
        }
        val expected1 = """
            |person Sam {
            |    foo
            |    bar
            |    baz
            |    qux
            |}
        """.trimMargin()
        assertEquals(expected1, person.format()) // Calling format() here works fine.

        // Now create a delegate object instance that sorts the favorite things.
        val personWithSortedFavorites = object : Favorites by person {
            override val favoriteThings = person.favoriteThings.sorted()
        }
        val expected2 = """
            |person Sam {
            |    bar
            |    baz
            |    foo
            |    qux
            |}
        """.trimMargin()
        // Then try to call format() on the delegate object, and it will fail to see the delegate
        assertEquals(expected2, personWithSortedFavorites.format())
    }

}
