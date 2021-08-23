package baseball;

import utils.RandomUtils;
import java.util.Scanner;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import utils.Views;

public class Game {
    private final Scanner userInput;
    private GameResult gameResult;
    private NumberBaseball guessBalls;
    private NumberBaseball answerBalls;

    public Game(Scanner userInput){
        this.userInput = userInput;
    }

    public void play(){
        initialize();
        while (gameResult.isWin() != true)
            playingGame();
        System.out.println(Views.GAME_OVER);
    }

   private void initialize(){
        gameResult = new GameResult();
        answerBalls = new NumberBaseball(createRandomBalls());
    }

    private List<Integer> createRandomBalls(){
        Set<Integer> setRandomBalls = new LinkedHashSet<>();
        while (setRandomBalls.size() != 3)
            setRandomBalls.add(RandomUtils.nextInt(1, 9));
        List<Integer> listRandomBalls = new ArrayList<>(setRandomBalls);
        return listRandomBalls;
    }



    private void playingGame(){
        generateGuessBalls();
        gameResult.compareBalls(guessBalls, answerBalls);
        Views.printGameResult(gameResult.getBallCount(), gameResult.getStrikeCount());

    }

    private void generateGuessBalls(){
        System.out.print(Views.ENTER_NUMBER);
        guessBalls = new NumberBaseball(userInput.nextLine());
        System.out.println(guessBalls.getBalls());
    }
}
