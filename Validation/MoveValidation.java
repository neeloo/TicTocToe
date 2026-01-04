package Module_3_LLD.TicTocToe.Validation;

import Module_3_LLD.TicTocToe.Exception.InValidMoveBoardException;
import Module_3_LLD.TicTocToe.Exception.InValidMoveException;
import Module_3_LLD.TicTocToe.Model.Board;
import Module_3_LLD.TicTocToe.Model.CellState;
import Module_3_LLD.TicTocToe.Model.Move;

public class MoveValidation {
    public static boolean validate(Move move, Board board){
        int r = move.getCell().getR();
        int c = move.getCell().getC();
        if(r<0 || r> board.getSize() || c< 0 || c > board.getSize()){
            // HW: Throw a custom exception for this
//            System.out.println("Invalid move: Out of the board.\nPlease try again!");
//            return false;
            throw new InValidMoveBoardException("Invalid move: Out of the board.");
        }
        CellState cellState = board.getGrid().get(r).get(c).getCellState();
        if(cellState.equals(CellState.FILLED)){
            // HW: Throw a custom exception
            // System.out.println("Invalid move: Cell is already occupied.\nPlease try again!");
            throw new InValidMoveException("Invalid move: Cell is already occupied");

            //return false;
        }
        return true;
        // Create separate exceptions for the above
    }
}
