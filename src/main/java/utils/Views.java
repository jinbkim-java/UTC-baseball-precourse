package utils;

public class Views {
    public static final String ENTER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String STRIKE_COUNT = "%d스트라이크 ";
    public static final String BALL_COUNT = "%d볼 ";
    public static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NOTHING = "낫싱";

    public static void printGameResult(long ballCount, long strikeCount){
        if (ballCount > 0)
            System.out.printf(BALL_COUNT, ballCount);
        if (strikeCount > 0)
            System.out.printf(STRIKE_COUNT, strikeCount);
        if (ballCount == 0 && strikeCount == 0)
            System.out.print(NOTHING);
        System.out.println();
    }
}