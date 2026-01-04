package Module_3_LLD.TicTocToe.Strategies.WinningStrategies;

import Module_3_LLD.TicTocToe.Model.Board;
import Module_3_LLD.TicTocToe.Model.Move;

public class ColWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }

    @Override
    public void handleUndo(Move lastMove) {

    }
}
