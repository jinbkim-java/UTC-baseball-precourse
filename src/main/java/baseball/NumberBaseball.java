package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberBaseball {
    private List<Integer> balls;

    public NumberBaseball(List<Integer> balls){
        this.balls = balls;
    }

    public NumberBaseball(String userInput){
        balls = Stream.of(userInput.split(""))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
    }

    public List<Integer> getBalls(){
        return balls;
    }
}
