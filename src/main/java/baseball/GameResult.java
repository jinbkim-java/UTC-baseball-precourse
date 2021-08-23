package baseball;

public class GameResult {
    public long strikeCount;
    public long ballCount;

    public GameResult(){
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isWin(){
        if (strikeCount == 3)
            return true;
        return false;
    }

    public void compareBalls(NumberBaseball guessBalls, NumberBaseball answerBalls) {
        strikeCount = getStrike(guessBalls, answerBalls);
        ballCount = getBall(guessBalls, answerBalls);
    }

    private long getStrike(NumberBaseball guessBalls, NumberBaseball answerBalls){
        return guessBalls.getBalls().stream()
                .filter(i -> answerBalls.getBalls().contains(i))
                .filter(i -> isSameIndex(i, guessBalls, answerBalls))
                .count();
    }

    private long getBall(NumberBaseball guessBalls, NumberBaseball answerBalls){
        return guessBalls.getBalls().stream()
                .filter(i -> answerBalls.getBalls().contains(i))
                .filter(i -> !isSameIndex(i, guessBalls, answerBalls))
                .count();
    }

    private boolean isSameIndex(int i, NumberBaseball guessBalls, NumberBaseball answerBalls){
        if (guessBalls.getBalls().indexOf(i) == answerBalls.getBalls().indexOf(i))
            return true;
        return false;
    }

    public long getStrikeCount(){ return strikeCount; }

    public long getBallCount(){ return ballCount; }
}
