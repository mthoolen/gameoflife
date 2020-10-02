import kotlin.concurrent.timer

object GameOfLife {
    infix fun tick(grid: Grid) = grid.evolve()
}

fun main(){
    var grid = Grid(
        """     |................
                |...***...***....
                |................
                |.*....*.*....*..
                |.*....*.*....*..
                |.*....*.*....*..
                |...***...***....
                |................
                |...***...***....
                |.*....*.*....*..
                |.*....*.*....*..
                |.*....*.*....*..
                |................   
                |...***...***....
                |................
            """.trimMargin())
    timer(period = 500) {
        grid = GameOfLife tick grid and ::printGrid
    }
}

infix fun Grid.and(block: (Grid)->Unit) = also(block)
fun printGrid(grid: Grid) = println("$grid\n")