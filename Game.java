import java.util.Random;
import java.util.Scanner;
/**
 * Project 2.5.11
 *
 * Game Class for the Game of Nim 
 * All the methods for the game
*/
class Game {
    private Player[] players;
    private int currentPlayerIndex;
    private int pileSize;
    private boolean isGameOver;
    private Random rand;

    public Game(Player player1, Player player2) {
        this.players = new Player[] { player1, player2 };
        this.isGameOver = false;
        this.rand = new Random();
    }

    public void startGame() {
        randomizePile();
        currentPlayerIndex = rand.nextInt(2); // Randomly select the first player
        System.out.println("Game started! There are " + pileSize + " pieces in the pile.");
        System.out.println(players[currentPlayerIndex].getName() + " will go first.");
        isGameOver = false;
    }

    public void takeTurn() {
        Player currentPlayer = players[currentPlayerIndex];
        System.out.println(currentPlayer.getName() + "'s turn.");

        int chosenPiece = currentPlayer.pickPiece(pileSize);
        pileSize -= chosenPiece;
        System.out.println(currentPlayer.getName() + " takes " + chosenPiece + " pieces.");
        System.out.println("There are " + pileSize + " pieces left.");
        
        if (pileSize == 0) {
            checkGameOver();
        }

        checkGameOver();

        // Switch to the other player.
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    private void randomizePile() {
        pileSize = rand.nextInt(41) + 10; // Random between 10 and 50
    }

    public void checkGameOver() {
        if (pileSize <= 0) {
            // The current player loses because they took the last piece
            Player loser = players[currentPlayerIndex];
            System.out.println("Game over! " + loser.getName() + " loses!");
            players[1-currentPlayerIndex].score++;  // The other player wins
            isGameOver = true;
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void announceWinner() {
        Player winner = players[1 - currentPlayerIndex];
        System.out.println("Winner: " + winner.getName());
        System.out.println("Scores: " + players[0].getName() + " - " + players[0].score + " | " + players[1].getName() + " - " + players[1].score);
    }

    public boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.nextLine().toLowerCase();
        if (response.equals("yes")) {
            startGame();
            scanner.close();
            return true;
        } else {
            System.out.println("Thanks for playing!");
            scanner.close();
            return false;
        }
    }
}