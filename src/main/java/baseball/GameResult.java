package baseball;

public class GameResult {
    public long strikeCount;
    public long ballCount;

    public GameResult() {
        strikeCount = 0;
        ballCount = 0;
    }

    public boolean isWin() {
        if (strikeCount == BallsInfo.BALL_COUNT)
            return true;
        return false;
    }

    public void compareBalls(BallsInfo guessBalls, BallsInfo answerBalls) {
        strikeCount = countStrike(guessBalls, answerBalls);
        ballCount = countBall(guessBalls, answerBalls);
    }

    public long getStrikeCount() {
        return strikeCount;
    }

    public long getBallCount() {
        return ballCount;
    }

    private long countStrike(BallsInfo guessBalls, BallsInfo answerBalls) {
        return guessBalls.getBalls().stream()
                .filter(i -> answerBalls.getBalls().contains(i))
                .filter(i -> isSameIndex(i, guessBalls, answerBalls))
                .count();
    }

    private long countBall(BallsInfo guessBalls, BallsInfo answerBalls) {
        return guessBalls.getBalls().stream()
                .filter(i -> answerBalls.getBalls().contains(i))
                .filter(i -> !isSameIndex(i, guessBalls, answerBalls))
                .count();
    }

    private boolean isSameIndex(int i, BallsInfo guessBalls, BallsInfo answerBalls) {
        if (guessBalls.getBalls().indexOf(i) == answerBalls.getBalls().indexOf(i))
            return true;
        return false;
    }
}
