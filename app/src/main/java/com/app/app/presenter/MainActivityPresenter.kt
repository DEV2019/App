package com.app.app.presenter

interface MainActivityPresenter {

    fun onCellClicked(row: Int, col: Int)

    interface View {

        fun setCellText(row: Int, col: Int, player: String)

    }
}
