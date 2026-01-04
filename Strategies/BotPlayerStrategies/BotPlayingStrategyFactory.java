package Module_3_LLD.TicTocToe.Strategies.BotPlayerStrategies;

import Module_3_LLD.TicTocToe.Exception.InValidBotDefficultyLevel;
import Module_3_LLD.TicTocToe.Model.BotdifficultyLevel;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getStrategy(BotdifficultyLevel level) {

        if (level.equals(BotdifficultyLevel.EASY)) {
            return new EasyPlayingStrategy();
        } else if (level.equals(BotdifficultyLevel.MEDIUM)) {
            return new MediumPlayingBotStrategy();
        } else if (level.equals(BotdifficultyLevel.HARD)) {
            return new HardPlayingBotStrategy();
        } else {
            ///custom exception
            throw new InValidBotDefficultyLevel("Invalid Difficulty Level");
        }
    }
}
