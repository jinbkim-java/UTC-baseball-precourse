package baseball;

public class Player {
    public enum Status{ PLAYING, DONE }

    private Status status;
    private static final String ReGame = "1";
    private static final String EndGame = "2";

    public Player(){ status = Status.PLAYING; }

    public Status getStatus(){ return status; }
    public void setStatusDone(){
        status = Status.DONE;
    }
    public boolean isReGame(String input){
        if (input.equals(ReGame))
            return true;
        return false;
    }
}
