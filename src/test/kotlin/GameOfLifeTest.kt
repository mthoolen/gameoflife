import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {
    @Test
    internal fun `single live cell should die after a tick`() {
        val before = Grid("*")
        val after = Grid(".")
        assertThat(GameOfLife.tick(before)).isEqualTo(after)
    }

    @Test
    internal fun `when a row contains a live cell it should die after a tick`() {
        val before = Grid(".*")
        val after = Grid("..")
        assertThat(GameOfLife.tick(before)).isEqualTo(after)
    }

    @Test
    internal fun `given three living cells the last should spring to life`() {
        val before = Grid(
            """
                |**
                |.*
            """.trimIndent()
        )
        val after = Grid(
            """
                |**
                |**
            """.trimMargin()
        )
        assertThat(GameOfLife.tick(before)).isEqualTo(after)
    }

    @Test
    internal fun `a block lives forever`() {
        val before = Grid(
            """
                |**
                |**
            """.trimIndent()
        )
        val after = Grid(
            """
                |**
                |**
            """.trimMargin()
        )
        assertThat(GameOfLife.tick(before)).isEqualTo(after)
    }

    @Test
    internal fun `cells with fewer than two neighbours die`() {
        val before = Grid(
            """
                |**
                |..
            """.trimIndent()
        )
        val after = Grid(
            """
                |..
                |..
            """.trimMargin()
        )
        assertThat(GameOfLife.tick(before)).isEqualTo(after)
    }

    @Test
    internal fun `cells with more than three neighbours die`() {
        val before = Grid(
            """
                |***
                |***
            """.trimIndent()
        )
        val after = Grid(
            """
                |*.*
                |*.*
            """.trimMargin()
        )
        assertThat(GameOfLife.tick(before)).isEqualTo(after)
    }


}