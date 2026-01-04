package Module_3_LLD.TicTocToe.Model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }

    public Board(int size) {
        this.size = size;
        this.grid= new ArrayList<>();
        //grid construct ourself
        for(int i =0; i <size ;i++){
            grid.add(new ArrayList<>()); ///adding array for 3  , , , -> add 3 cell -> cell,cell,cell
            for( int j =0; j <size; j++){
                grid.get(i).add(new Cell(i , j));
            }
        }
    }

    public void display() {
        for(List<Cell>row : grid){
            for(Cell cell : row){
                cell.display();
            }
            System.out.println();
        }
    }
}
