package Module_3_LLD.TicTocToe.Controller;

import Module_3_LLD.TicTocToe.Model.Game;
import Module_3_LLD.TicTocToe.Model.GameStatus;
import Module_3_LLD.TicTocToe.Model.Player;
import Module_3_LLD.TicTocToe.Model.WinningStrategyType;

import java.util.List;

public class GameController {

   public Game startGame(int size , List<Player> player , List<WinningStrategyType>type){
        return Game
                .getBuilder()
                .setSize(size)
                .setPlayers(player)
                .setWinningStrategyTypes(type)
                .build();

    }

    public void displayBoard(Game game1) {
       game1.getBoard().display();
    }

    public GameStatus getGameStatus(Game game) {
       return game.getStatus();
    }

    public void makeMove(Game game) {
       game.makeMove();
    }


    public Player getWinner(Game game) {
       return game.getWinner();
    }


    ///undo implement
    public void undo(Game game) {
        //Implement UNDO functionality
        game.undo();
    }


}
