import Cell.Companion.isCell

class Grid(val cells: Array<Array<Cell>>) {
    constructor(cells: String) : this(toRows(cells))

    private companion object {
        fun toRows(cells: String) = cells
            .split("\n")
            .map(::toCell)
            .toTypedArray()

        private fun toCell(cell: String) = cell
            .chunked(1)
            .filter(::isCell)
            .map(::Cell)
            .toTypedArray()
    }


    fun shouldBeAlive(row: Int, column: Int) =
        if (cell(row, column).dead) shouldComeAlive(row, column)
        else shouldStayAlive(row, column)

    private fun shouldComeAlive(row: Int, column: Int) = numberOfAliveNeighbours(row, column) == 3

    private fun shouldStayAlive(row: Int, column: Int) = numberOfAliveNeighbours(row, column) in 2..3

    private fun numberOfAliveNeighbours(row: Int, column: Int) =
        neighbours(row, column)
            .sumBy(Cell::intValue)

    private fun neighbours(row: Int, column: Int) = rowRange(row)
        .flatMap { rowIndex -> columnRange(column)
            .map { column -> cell(rowIndex, column) }
        }
        .filter { it !== cell(row, column) }


    private fun rowRange(number: Int): IntRange {
        val max = if (number < cells.size - 1) number + 1 else number
        return (minNumber(number)..max)
    }

    private fun columnRange(number: Int): IntRange {
        val max = if (number < cells.first().size - 1) number + 1 else number
        return (minNumber(number)..max)
    }

    private fun minNumber(number: Int) = if (number > 0) number - 1 else number

    private fun cell(row: Int, column: Int) = cells[row][column]

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Grid
        if (!cells.contentDeepEquals(other.cells)) return false
        return true
    }
    override fun hashCode(): Int = cells.contentDeepHashCode()
    override fun toString() =
        cells.joinToString(prefix = "\n", separator = "\n", postfix = "\n") { it.joinToString("") }

}