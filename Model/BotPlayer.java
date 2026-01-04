package Module_3_LLD.TicTocToe.Model;

import Module_3_LLD.TicTocToe.Strategies.BotPlayerStrategies.BotPlayingStrategy;
import Module_3_LLD.TicTocToe.Strategies.BotPlayerStrategies.BotPlayingStrategyFactory;

public class BotPlayer extends  Player{
    private BotdifficultyLevel botdifficultyLevel;

    public BotPlayer(String name, Character c , BotdifficultyLevel botdifficultyLevel) {
        super(name, new Symbol(c), PlayerType.BOT);
        this.botdifficultyLevel = botdifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        System.out.println("It's " + getName() + "'s turn.");
        // Based on the bot difficulty level, we should get the bot playing strategy using simple factory
        BotPlayingStrategy strategy = BotPlayingStrategyFactory.getStrategy(botdifficultyLevel);
        // Get the Move from the strategy
        return strategy.makeMove(board, this);
    }
}
