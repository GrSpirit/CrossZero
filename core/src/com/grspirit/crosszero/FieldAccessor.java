package com.grspirit.crosszero;

import com.grspirit.crosszero.model.Grid;
import com.grspirit.crosszero.model.Player;

/**
 * Created by vita on 08.12.15.
 */
public class FieldAccessor {
    /*
    private Grid grid;
    private Player currentPlayer;
    private Player[] players;
    private static FieldAccessor ourInstance = new FieldAccessor();

    public static FieldAccessor getInstance() {
        return ourInstance;
    }

    public FieldAccessor() {
        grid = Grid.getInstance();
        players = new Player[2];
        players[0].setFigure(Grid.CROSS);
        players[1].setFigure(Grid.ZERO);
        currentPlayer = players[0];
    }

    public Player switchPlayer() {
        currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];
        return currentPlayer;
    }

    public void touchCell(int x, int y) throws Grid.IncorrectValue {
        try {
            grid.setValue(x, y, currentPlayer.getFigure());

            switchPlayer();
        }
        catch (Grid.CellIsBusy e) {
            e.getY();
        }
    }
*/
}
