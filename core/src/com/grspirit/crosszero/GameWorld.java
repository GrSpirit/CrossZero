package com.grspirit.crosszero;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.grspirit.crosszero.model.Grid;
import com.grspirit.crosszero.model.Player;
import com.grspirit.crosszero.view.GridView;

/**
 * Created by vita on 21.02.16.
 */
public class GameWorld {
    private Grid grid;
    private int currentPlayer;
    private Player[] players;
    private boolean win;
    public GameWorld() {
        grid = new Grid(X0Game.WIDTH, X0Game.HEIGHT);
        players = new Player[2];
        players[0] = new Player(Grid.CROSS);
        players[1] = new Player(Grid.ZERO);
        currentPlayer = 0;
        win = false;
    }

    public Grid getGrid() {
        return grid;
    }

    public void update() {
        // Do nothing
    }

    public void onTouch(int screenX, int screenY) {
        if (!isWin()) {
            int x = screenX / grid.getCellSize();
            int y = (X0Game.HEIGHT - screenY) / grid.getCellSize();
            try {
                grid.setValue(x, y, getCurrentPlayer().getFigure());
                if (grid.checkWin(x, y)) {
                    win = true;
                } else {
                    currentPlayer = currentPlayer ^ 1;
                }
            } catch (Grid.CellIsBusy e) {

            } catch (Grid.IncorrectValue e) {

            }
        }
    }

    public boolean isWin() {
        return win;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }

    public String getWinMessage() {
        return String.format("Player %s won!", getCurrentPlayer().getName());
    }
}
