package com.app.tictactoe.presenter

interface MainActivityPresenter {

    fun onCellClicked(row: Int, col: Int)

    fun updateCells()

    fun reset()

    interface View {

        fun setCellText(row: Int, col: Int, player: String)

        fun showWinnerLabel(player: String)

        fun hideInfoLabel()

        fun disableCells(row: Int, col: Int)

        fun enableCells(row: Int, col: Int)

        fun setLabelDrawn()

    }
}
