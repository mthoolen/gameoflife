import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CellTest {
    private val deadCell = Cell(false)
    private val aliveCell = Cell("*")

    @Test
    internal fun `cell should be able to tell if a string represents dead or alive`() {
        assertThat(Cell.isCell("*")).isTrue()
        assertThat(Cell.isCell(".")).isTrue()
        assertThat(Cell.isCell("-")).isFalse()
    }

    @Test
    internal fun `a cell should come alive when it has three live neighbours`() {
        val result = deadCell evolveWith "***".toCells()

        result.assertAlive()
    }

    @Test
    internal fun `a cell should die of underpopulation when it has less than two live neighbours`() {
        val result = aliveCell evolveWith "*..".toCells()

        result.assertDead()
    }

    @Test
    internal fun `alive cell should die of overpopulation when it has four live neighbours`() {
        val result = aliveCell evolveWith "****".toCells()

        result.assertDead()
    }

    @Test
    internal fun `alive should survive if it has two neighbours`() {
        val result = aliveCell evolveWith "**".toCells()
        result.assertAlive()
    }

    @Test
    internal fun `alive should survive if it has three neighbours`() {
        val result  = aliveCell evolveWith "***".toCells()
        result.assertAlive()
    }

    private fun String.toCells()=
        chunked(1)
            .map(::Cell)
            .toTypedArray()

    private fun Cell.assertDead() = assertThat(dead).isTrue()

    private fun Cell.assertAlive() = assertThat(alive).isTrue()
}