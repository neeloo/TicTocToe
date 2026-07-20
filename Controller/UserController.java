package Module_3_LLD.TicTocToe.Controller;

import Module_3_LLD.TicTocToe.Model.Game;
import Module_3_LLD.TicTocToe.Model.Player;

import java.util.List;

public class UserController {

    Game createPlayer (int size , List<Player> player ){
        return Game.
                getBuilder()
                .setSize(size)
                .setPlayers(player)
                .build();
    }
}
