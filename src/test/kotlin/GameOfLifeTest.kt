import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {
    @Test
    internal fun `single live cell should die after a tick`() {
        val before = Grid("*")
        val after = Grid(".")
        assertThat(after).isEqualTo(GameOfLife.tick(before))
    }

    @Test
    internal fun `when a row contains a live cell it should die after a tick`() {
        val before = Grid(".*")
        val after = Grid("..")
        assertThat(after).isEqualTo(GameOfLife.tick(before))
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
        assertThat(after).isEqualTo(GameOfLife.tick(before))
    }


}