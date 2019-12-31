import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CellTest {
    @Test
    internal fun `cell is dead or alive`() {
        val deadCell = Cell(false)
        val aliveCell = Cell("*")
        Assertions.assertTrue(deadCell.dead)
        Assertions.assertTrue(aliveCell.alive)
    }
}