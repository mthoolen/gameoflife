import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameOfLifeTest {

    @Test
    internal fun `cell is dead or alive`() {
        val deadCell = Cell(false)
        val aliveCell = Cell("*")
        assertTrue(deadCell.dead)
        assertTrue(aliveCell.alive)
    }

    @Test
    internal fun `single live cell should die after a tick`() {
        val before = Grid("*")
        val after = Grid(".")
        assertEquals(after, GameOfLife.tick(before))
    }

    @Test
    internal fun `when a row contains a live cell it should die after a tick`() {
        val before = Grid(".*")
        val after = Grid("..")
        assertEquals(after, GameOfLife.tick(before))
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
        assertEquals(after, GameOfLife.tick(before))
    }


}