object GameOfLife {
    fun tick(grid: Grid): Grid {
        val nextCells = grid.cells.mapIndexed{
                rowIndex, row-> row.mapIndexed {
                    columnIndex, _ ->
            Cell(grid.shouldBeAlive(rowIndex,columnIndex)) }
            .toTypedArray() }
            .toTypedArray()
        return Grid(nextCells)
    }
}