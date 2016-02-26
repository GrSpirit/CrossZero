package com.grspirit.crosszero.model;

/**
 * Created by vita on 08.12.15.
 */
public class Player {
    private int figure;
    private String name;

    public Player() {
    }

    public Player(int figure) {
        setFigure(figure);
    }

    public Player(String name) {
        setName(name);
    }

    public Player(int figure, String name) {
        setFigure(figure);
        setName(name);
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public String getName() {
        return (name != null )? name : (figure == Grid.CROSS ? "X" : "0");
    }

    public void setName(String name) {
        this.name = name;
    }
}
