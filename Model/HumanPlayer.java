package Module_3_LLD.TicTocToe.Model;

import Module_3_LLD.TicTocToe.Validation.MoveValidation;

import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner sc = new Scanner(System.in);

    public HumanPlayer(String name, Character c) {
        super(name, new Symbol(c), PlayerType.HUMAN);
    }

    @Override
    public Move makeMove(Board board) {
        Move move;
        do {
            // take  input from the scanner
            System.out.println("It 's " + getName() + "'s turn please Enter row and column :");
            int row = sc.nextInt();
            int col = sc.nextInt();

            //create the move
            move = new Move(new Cell(row, col), this);
        }
        //validate the move
        while (!MoveValidation.validate(move, board));

        //return the move
        return move;
    }
}
