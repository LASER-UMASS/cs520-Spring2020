package controller;

import model.RowGameModel;


public interface RowGameRulesStrategy
{
    public void reset(RowGameModel gameModel);

    public void move(RowGameModel gameModel, int row, int col);

    public boolean isWin(RowGameModel gameModel);

    public boolean isTie(RowGameModel gameModel);
}
