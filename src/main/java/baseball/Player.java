package baseball;

import utils.Views;

public class Player {
    public enum Status {PLAYING, DONE}

    private Status status;
    private static final String ReGame = "1";
    private static final String EndGame = "2";

    public Player() {
        status = Status.PLAYING;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatusDone() {
        status = Status.DONE;
    }

    public boolean isReGame(String userInput) {
        askReGameValidate(userInput);
        if (userInput.equals(ReGame))
            return true;
        return false;
    }

    private void askReGameValidate(String userInput) {
        if (!userInput.equals(ReGame) && !userInput.equals(EndGame))
            throw new IllegalArgumentException(Views.WRONG_ASK_REGAME);
    }
}
