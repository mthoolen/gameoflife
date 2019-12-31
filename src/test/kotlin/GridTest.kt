import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GridTest {
    private val grid: Grid
        get() = Grid(
            """
                |***
                |***
                |***
            """.trimMargin())

    @Test
    internal fun `grid is able to give a cells neighbours if it's in the middle`() {
        val result = grid.neighbours(1, 1)
        assertThat(result.size).isEqualTo(8)
    }

    @Test
    internal fun `grid is able to give a cells neighbours if it's in the upper left corner`() {
        val result = grid.neighbours(0, 0)
        assertThat(result.size).isEqualTo(3)
    }

    @Test
    internal fun `grid is able to give a cells neighbours if it's in the upper right corner`() {
        val result = grid.neighbours(0, 2)
        assertThat(result.size).isEqualTo(3)
    }

    @Test
    internal fun `grid is able to give the neighbours of the lower right corner`() {
        val result = grid.neighbours(2, 2)
        assertThat(result.size).isEqualTo(3)
    }

    @Test
    internal fun `grid is able to give the neighbours of the lower left corner`() {
        val result = grid.neighbours(2,0)
        assertThat(result.size).isEqualTo(3)  }
}