package com.app.tictactoe.presenter

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.powermock.api.easymock.PowerMock

class MainActivityPresenterImplTest {

    lateinit var presenter: MainActivityPresenterImpl
    lateinit var view: MainActivityPresenter.View

    @Before
    fun setUp() {
        view = PowerMock.createMock(MainActivityPresenter.View::class.java)
        presenter = MainActivityPresenterImpl(view)
    }

    @After
    fun tearDown() {
        PowerMock.verifyAll()
        PowerMock.resetAll()
    }

    @Test
    fun onCellClicked_default() {
        val row = 2
        val col = 2

        view.setCellText(2, 2, "X")

        PowerMock.replayAll()

        presenter.onCellClicked(row, col)
    }

    @Test
    fun onCellClicked_wrong_values() {
        val row = 3
        val col = 4

        PowerMock.replayAll()

        presenter.onCellClicked(row, col)
    }

    @Test
    fun onCellClicked_top_3_X() {

        view.setCellText(0, 0, "X")
        view.setCellText(1, 0, "O")
        view.setCellText(0, 1, "X")
        view.setCellText(1, 1, "O")
        view.setCellText(0, 2, "X")
        view.showWinnerLabel("X")

        PowerMock.replayAll()

        presenter.onCellClicked(0, 0)
        presenter.onCellClicked(1, 0)
        presenter.onCellClicked(0, 1)
        presenter.onCellClicked(1, 1)
        presenter.onCellClicked(0, 2)

    }

    @Test
    fun onCellClicked_3_in_column_X() {

        view.setCellText(0, 0, "X")
        view.setCellText(0, 1, "O")
        view.setCellText(1, 0, "X")
        view.setCellText(1, 1, "O")
        view.setCellText(2, 0, "X")
        view.showWinnerLabel("X")

        PowerMock.replayAll()

        presenter.onCellClicked(0, 0)
        presenter.onCellClicked(0, 1)
        presenter.onCellClicked(1, 0)
        presenter.onCellClicked(1, 1)
        presenter.onCellClicked(2, 0)

    }

    @Test
    fun onCellClicked_3_in_diagonal_O() {

        view.setCellText(0, 0, "X")
        view.setCellText(2, 0, "O")
        view.setCellText(1, 0, "X")
        view.setCellText(1, 1, "O")
        view.setCellText(0, 1, "X")
        view.setCellText(0, 2, "O")

        view.showWinnerLabel("O")

        PowerMock.replayAll()

        presenter.onCellClicked(0, 0)
        presenter.onCellClicked(2, 0)
        presenter.onCellClicked(1, 0)
        presenter.onCellClicked(1, 1)
        presenter.onCellClicked(0, 1)
        presenter.onCellClicked(0, 2)


    }

    @Test
    fun onCellClicked_random() {

        view.setCellText(0, 0, "X")
        view.setCellText(2, 0, "O")
        view.setCellText(1, 0, "X")
        view.setCellText(1, 1, "O")
        view.setCellText(0, 1, "X")
        view.setCellText(2, 2, "O")


        PowerMock.replayAll()

        presenter.onCellClicked(0, 0)
        presenter.onCellClicked(2, 0)
        presenter.onCellClicked(1, 0)
        presenter.onCellClicked(1, 1)
        presenter.onCellClicked(0, 1)
        presenter.onCellClicked(2, 2)

    }
}
