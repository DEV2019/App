package com.app.tictactoe.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.app.tictactoe.R
import com.app.tictactoe.presenter.MainActivityPresenter
import com.app.tictactoe.presenter.MainActivityPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityPresenter.View {

    lateinit var presenter: MainActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainActivityPresenterImpl(this)

    }

    fun onCellClicked(view: View) {
        presenter.onCellClicked(
            view.tag.toString().substring(0, 1).toInt(),
            view.tag.toString().substring(1, 2).toInt()
        )
    }

    override fun setCellText(row: Int, col: Int, player: String) {
        val cell: Button = grid_tictactoe.findViewWithTag("" + row + col)
        cell.text = player
    }

    override fun showWinnerLabel(player: String) {
        winner_text.text = resources.getString(R.string.winner, player)
        winner_text.visibility = View.VISIBLE
    }

    override fun hideWinnerLabel() {
    }

    override fun disableCells(row: Int, col: Int) {

    }

    override fun enableCells(row: Int, col: Int) {

    }

}
