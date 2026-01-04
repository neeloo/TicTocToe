package Module_3_LLD.TicTocToe.Strategies.BotPlayerStrategies;

import Module_3_LLD.TicTocToe.Model.Board;
import Module_3_LLD.TicTocToe.Model.BotPlayer;
import Module_3_LLD.TicTocToe.Model.Move;

public interface BotPlayingStrategy  {
    public Move makeMove(Board board, BotPlayer botPlayer) ;
}
