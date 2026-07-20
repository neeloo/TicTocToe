package Module_3_LLD.TicTocToe.Strategies.WinningStrategies;

import Module_3_LLD.TicTocToe.Model.Board;
import Module_3_LLD.TicTocToe.Model.Move;

public interface WinningStrategy {

    public  boolean checkWinner(Board board , Move move);

    void handleUndo(Move lastMove);
}
