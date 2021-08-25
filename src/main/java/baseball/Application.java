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
            askReGame(player, scanner);
        }
    }

    private static void askReGame(Player player, Scanner scanner){
        try {
            System.out.println(Views.RE_GAME);
            if (!player.isReGame(scanner.nextLine()))
                player.setStatusDone();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            askReGame(player, scanner);
        }
    }
}
