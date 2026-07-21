package Module_3_LLD.TicTocToe.Strategies.BotPlayerStrategies;

import Module_3_LLD.TicTocToe.Model.*;

import java.util.List;

public class EasyPlayingStrategy implements  BotPlayingStrategy{

    @Override
    public Move makeMove(Board board, BotPlayer botPlayer) {
        for(List<Cell> row : board.getGrid()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(new Cell(cell.getR(), cell.getC()), botPlayer);
                }
            }
        }
        return null;
    }
}
