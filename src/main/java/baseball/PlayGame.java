package baseball;

import utils.RandomUtils;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import utils.Views;

public class PlayGame {
    private final Scanner userInput;
    private GameResult gameResult;
    private BallsInfo guessBalls;
    private BallsInfo answerBalls;

    public PlayGame(Scanner userInput){ this.userInput = userInput; }

    public void playGame(){
        initialGame();
        while (gameResult.isWin() != true)
            playingGame();
        System.out.println(Views.GAME_OVER);
    }

    private void initialGame(){
        gameResult = new GameResult();
        answerBalls = new BallsInfo(createRandomBalls());
    }
    private List<Integer> createRandomBalls(){
        Set<Integer> setRandomBalls = new LinkedHashSet<>();
        while (setRandomBalls.size() != BallsInfo.BALL_COUNT)
            setRandomBalls.add(RandomUtils.nextInt(BallsInfo.BALL_MIN_VAL, BallsInfo.BALL_MAX_VAL));
        List<Integer> listRandomBalls = new ArrayList<>(setRandomBalls);
        return listRandomBalls;
    }
    private void playingGame(){
        createGuessBalls();
        gameResult.compareBalls(guessBalls, answerBalls);
        Views.printGameResult(gameResult.getBallCount(), gameResult.getStrikeCount());
    }
    private void createGuessBalls(){
        try {
            System.out.print(Views.ENTER_NUMBER);
            guessBalls = new BallsInfo(userInput.nextLine());
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            createGuessBalls();
        }
    }
}
