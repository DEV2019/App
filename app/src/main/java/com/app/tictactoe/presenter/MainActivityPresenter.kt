package com.app.tictactoe.presenter

interface MainActivityPresenter {

    fun onCellClicked(row: Int, col: Int)

    interface View {

        fun setCellText(row: Int, col: Int, player: String)

        fun showWinnerLabel(player: String)

        fun hideWinnerLabel()

    }
}
