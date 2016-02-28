package org;

import org.Game.TicTacToe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by dmytro on 27.02.16.
 */
public class InputController {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    char sym;

    public InputController(char sym) {
        this.sym = sym;
    }

    private String readLineFromInput() {
        try {
            return input.readLine();
        } catch (IOException e) {
            Display.readingError();
            return "";
        }
    }

//    private boolean isCorrectChoose(String answer) {
//        return answer.length() == 1 && Config.isCorrectChar(answer.charAt(0));
//    }

//    public void initForTTC() {
//        String answer;
//        while (true) {
//            Display.initChoose();
//            answer = readLineFromInput();
//            if (isCorrectChoose(answer))
//                break;
//            Display.doWhatTheySay();
//        }
//        game = new TicTacToe(answer.charAt(0));
//    }

    private Integer[] str2arrInt(String move) throws NumberFormatException {
        Integer[] arrMove = new Integer[2];
        StringTokenizer tokens = new StringTokenizer(move, " ");
        byte i = 0;
        while (tokens.hasMoreElements())
            arrMove[i++] = Integer.parseInt(tokens.nextToken());
        return arrMove;
    }

    private boolean isCorrectMove(TicTacToe game, String move) {
        StringTokenizer tokens = new StringTokenizer(move, " ");
        if (tokens.countTokens() != 2)
            return false;
        try {
            return game.field.isFreeCell(str2arrInt(move));
        } catch (NumberFormatException err) {
            return false;
        }
    }

    public boolean nextMove(TicTacToe game) {
        String move;
        while (true) {
            Display.enterMove();
            move = readLineFromInput();
            if (isCorrectMove(game, move.trim()))
                break;
            Display.doWhatTheySay();
        }
        boolean willBeNextMove = game.nextMove(str2arrInt(move), sym);
        if (! willBeNextMove)
            Display.whatEnd(game.winner);
        else
            Display.showField(game.field);
        return willBeNextMove;
    }
}
