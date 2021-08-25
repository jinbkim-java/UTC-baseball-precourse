package baseball;

import utils.Validate;
import utils.Views;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BallsInfo {
    public static final int BALL_COUNT = 3;
    public static final int BALL_MIN_VAL = 1;
    public static final int BALL_MAX_VAL = 9;

    private List<Integer> balls;

    public BallsInfo(List<Integer> balls){
        this.balls = balls;
    }
    public BallsInfo(String userInput){
        numberInputValidate(userInput);
        balls = Stream.of(userInput.split(""))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public List<Integer> getBalls(){
        return balls;
    }

    private void numberInputValidate(String userInput){
        if (Validate.hasWrongSize(userInput, BALL_COUNT) ||
                !Validate.validateOnlyNumber(userInput) ||
                Validate.hasParticularNumber(userInput, 0) ||
                Validate.hasOverlap(userInput, BALL_COUNT)
        )
            throw new IllegalArgumentException(Views.WRONG_NUMBER_INPUT);
    }
}
