object GameOfLife {
    fun tick(grid: Grid): Grid {
        val nextCells = grid.cells.mapIndexed{
                rowIndex, row-> row.mapIndexed {
                    columnIndex, cell ->
            cell evolveWith grid.neighbours(rowIndex,columnIndex) }
            .toTypedArray() }
            .toTypedArray()
        return Grid(nextCells)
    }
}