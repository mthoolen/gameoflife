import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GridTest {
    @Test
    internal fun `grid is able to give a cells neighbours`() {
        val grid = Grid("""
            |**
            |**
        """.trimMargin())
        val result = grid.shouldBeAlive(0, 0)
        assertThat(result).isTrue()
    }
}