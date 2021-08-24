package baseball;

import utils.Views;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        PlayGame game = new PlayGame(scanner);
        Player player = new Player();

        while (player.getStatus() != Player.Status.DONE){
            game.playGame();
            System.out.println(Views.RE_GAME);
            if (!player.isReGame(scanner.nextLine()))
                player.setStatusDone();
        }
    }
}
