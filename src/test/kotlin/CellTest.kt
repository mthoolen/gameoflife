import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CellTest {
    @Test
    internal fun `cell is dead or alive`() {
        val deadCell = Cell(false)
        val aliveCell = Cell("*")
        assertThat(deadCell.dead).isTrue()
        assertThat(aliveCell.alive).isTrue()
    }

    @Test
    internal fun `cell should be able to tell if a string represents dead or alive`() {
        assertThat(Cell.isCell("*")).isTrue()
        assertThat(Cell.isCell(".")).isTrue()
        assertThat(Cell.isCell("-")).isFalse()
    }
}