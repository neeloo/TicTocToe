package Module_3_LLD.TicTocToe.Model;

import Module_3_LLD.TicTocToe.Exception.InValidWinningStrategy;
import Module_3_LLD.TicTocToe.Strategies.WinningStrategies.ColWinningStrategy;
import Module_3_LLD.TicTocToe.Strategies.WinningStrategies.RowWinningStrategy;
import Module_3_LLD.TicTocToe.Strategies.WinningStrategies.WinningStrategy;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> player;
    private List<Move> moveHistory;
    private GameStatus status;
    private int nextPlayerIdx;
    private List<WinningStrategy> winningStrategies;
    private Player winner;

    private Game(Builder builder) {
        /// we will initialize things
        //todo -> validate size and player number
        this.board = new Board(builder.size);
        //validate all symbol of the player are unique
        this.player = builder.players;
        this.moveHistory = new ArrayList<>();
        this.status = GameStatus.IN_PROGRESS;
        this.nextPlayerIdx = 0;
        this.winningStrategies = new ArrayList<>();
        for (WinningStrategyType type : builder.getWinningStrategyTypes()) {
            //todo-> move to  a simple factory
            if (type == WinningStrategyType.ROW) {
                this.winningStrategies.add(new RowWinningStrategy());
            } else if (type == WinningStrategyType.COLUMN) {
                this.winningStrategies.add(new ColWinningStrategy());
            } else {
                new InValidWinningStrategy("Invalid winning strategy");
            }
        }
        this.winner = null;
    }

    /// getter-setter for all

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public void setMoveHistory(List<Move> moveHistory) {
        this.moveHistory = moveHistory;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public int getNextPlayerIdx() {
        return nextPlayerIdx;
    }

    public void setNextPlayerIdx(int nextPlayerIdx) {
        this.nextPlayerIdx = nextPlayerIdx;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }


    public static Builder getBuilder() {
        return new Builder();
    }

    public void makeMove() {
        //fetch the current player
        Player currPlayer = player.get(nextPlayerIdx);
        //ask the player to make a move
        Move move= currPlayer.makeMove(board);
        //update the board  with  the move  received from  player
        Cell cell= move.getCell();
        board.getGrid().get(cell.getR()).get(cell.getC()).setCellState(CellState.FILLED);
        board.getGrid().get(cell.getR()).get(cell.getC()).setSymbol(currPlayer.getSymbol());

        // roll the next player
        nextPlayerIdx++;
        nextPlayerIdx %= player.size();

        //update the moveHistory
        moveHistory .add(move);

        //check the status and update the winner
        for(WinningStrategy winningStrategy : winningStrategies){
            if(winningStrategy.checkWinner(board,move)){
                setStatus(GameStatus.WIN);
                setWinner(currPlayer);
                return ;
            }
        }
        //check for draw condition
         if(moveHistory.size() == (board.getSize()*board.getSize())){
            setStatus(GameStatus.DRAW);
        }

    }

    /// undo method
    public void undo() {
        // Remove and Get the last move from move History
        Move lastMove = moveHistory.getLast();
        moveHistory.removeLast();
        // Update the board -> remove the move from the board
        Cell cell = lastMove.getCell();
        board.getGrid().get(cell.getR()).get(cell.getC()).setCellState(CellState.EMPTY);
        board.getGrid().get(cell.getR()).get(cell.getC()).setSymbol(null);
        // Update the status
        setStatus(GameStatus.IN_PROGRESS);
        setWinner(null);

        // playerIndex update
        nextPlayerIdx--;
        nextPlayerIdx %= board.getSize();

        // Winning strategy MapCount
        for(WinningStrategy winningStrategy : winningStrategies){
            winningStrategy.handleUndo(lastMove);
        }
    }



    /// builder class for if in future game grow  then configuration kind of think
    public static class Builder {
        private int size;
        private List<Player> players;
        private List<WinningStrategyType> winningStrategyTypes;

        public int getSize() {
            return size;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategyType> getWinningStrategyTypes() {
            return winningStrategyTypes;
        }

        public Builder setWinningStrategyTypes(List<WinningStrategyType> winningStrategyTypes) {
            this.winningStrategyTypes = winningStrategyTypes;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }


}
