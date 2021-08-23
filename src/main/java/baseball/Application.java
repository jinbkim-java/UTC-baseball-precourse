package baseball;

import utils.Views;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner);
        Player player = new Player(scanner);

        while (player.getStatus() != Player.Status.DONE){
            game.play();
            System.out.println(Views.RE_GAME);
            if (!player.isReGame(scanner.nextLine()))
                player.setStatusDone();
        }

    }
}
