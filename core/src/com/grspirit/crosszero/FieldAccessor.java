package com.grspirit.crosszero;

import com.grspirit.crosszero.model.Field;
import com.grspirit.crosszero.model.Player;

/**
 * Created by vita on 08.12.15.
 */
public class FieldAccessor {
    private Field field;
    private Player currentPlayer;
    private Player[] players;
    private static FieldAccessor ourInstance = new FieldAccessor();

    public static FieldAccessor getInstance() {
        return ourInstance;
    }

    public FieldAccessor() {
        field = Field.getInstance();
        players = new Player[2];
        players[0].setFigure(Field.CROSS);
        players[1].setFigure(Field.ZERO);
        currentPlayer = players[0];
    }

    public Player switchPlayer() {
        currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];
        return currentPlayer;
    }

    public void touchCell(int x, int y) throws Field.IncorrectValue {
        try {
            field.setValue(x, y, currentPlayer.getFigure());
            
            switchPlayer();
        }
        catch (Field.CellIsBusy e) {
            e.getY();
        }
    }

    public boolean checkWin(int x, int y) {
        int figure = field.getValue(x, y);

        // Horizontal
        int count = 1;
        for (int i = x - 1; i >= 0; i--) {
            if (field.getValue(i, y) != figure)
                break;
            count++;
        }
        for (int i = x + 1; i < Field.MAX_SIZE; i++) {
            if (field.getValue(i, y) != figure)
                break;
            count++;
        }

        if (count >= 5) return true;

        // Vertical
        count = 1;
        for (int i = y - 1; i >= 0; i--) {
            if (field.getValue(x, i) != figure)
                break;
            count++;
        }
        for (int i = y + 1; i < Field.MAX_SIZE; i++) {
            if (field.getValue(x, i) != figure)
                break;
            count++;
        }
        if (count >= 5) return true;

        // Diagonal1
        count = 1;
        for (int i = 1; (i <= x) && (i <= y); i++) {
            if (field.getValue(x - i, y - i) != figure)
                break;
            count++;
        }
        for (int i = 1; i < Field.MAX_SIZE; i++) {
            if (field.getValue(x + i, y + i) != figure)
                break;
            count++;
        }
        if (count >= 5) return true;

        // Diagonal2
        count = 1;
        for (int i = 1; (i <= x) && (i <= Field.MAX_SIZE); i++) {
            if (field.getValue(x - i, y + i) != figure)
                break;
            count++;
        }
        for (int i = 1; (i <= y) && (i <= Field.MAX_SIZE); i++) {
            if (field.getValue(x + i, y - i) != figure)
                break;
            count++;
        }
        return (count >= 5);
    }
}
