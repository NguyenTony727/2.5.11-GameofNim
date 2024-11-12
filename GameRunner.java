import java.util.Scanner;
/*
 * Activity 2.5.11
 *
 * Manages the game flow, including starting the game, taking turns, checking if the game is over, and announcing the winner.
 */
public class GameRunner {
    public static void main(String[] args) {
        // Create players
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Player 1's name: ");
        String player1Name = scanner.nextLine();
        System.out.print("Enter Player 2's name: ");
        String player2Name = scanner.nextLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        Game game = new Game(player1, player2);

        game.startGame();

        while (!game.isGameOver()) {
            game.takeTurn();
        }

        game.announceWinner();
        scanner.close();
    }
}