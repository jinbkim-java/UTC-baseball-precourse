package baseball;

import java.util.Scanner;

public class Player {
    private final Scanner userInput;
    private Status status;

    public enum Status{
        PLAYING, DONE
    }


    public Player(Scanner userInput){
        this.userInput = userInput;
        status = Status.PLAYING;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatusDone(){
        status = Status.DONE;
    }

    public boolean isReGame(String input){
        if (input.equals("1"))
            return true;
        return false;
    }
}
