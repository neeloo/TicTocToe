package Module_3_LLD.TicTocToe;

import Module_3_LLD.TicTocToe.Controller.GameController;
import Module_3_LLD.TicTocToe.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 3;
        GameController gameController = new GameController();

        //human player creation should be done in user controller
        Player player1 = new HumanPlayer("Niel" ,'X');
        Player player2 = new BotPlayer("Botty" ,'O' , BotdifficultyLevel.EASY);
        // Player player2 = new BotPlayer("Betty" ,'O' , BotdifficultyLevel.MEDIUM);

        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

       List<WinningStrategyType>winningStrategyTypes = new ArrayList<>();
       winningStrategyTypes.add(WinningStrategyType.ROW);
       winningStrategyTypes.add(WinningStrategyType.COLUMN);

       Game game1 = gameController .startGame(size , players ,winningStrategyTypes);

       //gameController.displayBoard(game1);
        //or
        while(gameController.getGameStatus(game1).equals(GameStatus.IN_PROGRESS)){
            //display the board
            gameController .displayBoard(game1);
            //then  we should  ask player to make a move
            gameController.makeMove(game1);

            System.out.println("dou you want ot undo ? [Y/N]");
            String str = sc.nextLine();
            //validation the input -keep asking

            if(str.equals("Y")){
                gameController.undo(game1);  ///undo
            }

        }
        if(gameController.getGameStatus(game1).equals(GameStatus.WIN)){
            System.out.println(gameController.getWinner(game1).getName() + " has won the game ");
        }else{
            System.out.println("Game is draw!");
        }

    }
}
