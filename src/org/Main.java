package org;
import org.Game.TicTacToe;
import org.Util.CycleList;

public class Main {

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        CycleList users = new CycleList(new InputController(Config.X));
	    users.insertToEnd(new InputController(Config.O));

        for(; true; users.next())
            if (!((InputController) users.getCurrentData()).nextMove(game))
                break;
        System.out.println("That's all folks!");
    }
}
