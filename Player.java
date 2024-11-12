import java.util.Scanner;
/*
 * Activity 2.5.11
 *
 * A Player class the Game of Nim
 */
public class Player {
    /* attributes */
    String name;
    int score;
    /* constructor */
    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    /* accessors */
    public String getName() {
        return name;
    }

    /**
 * Prompts the player to select how many pieces they want to take from the pile.
 * The player can choose between 1 and half of the remaining pile size (rounded down).
 * If only 1 piece remains, the player is forced to take it and the game ends.
 * 
 * @param pileSize The current number of pieces remaining in the pile.
 * @return The number of pieces the player chooses to take.
 * @throws java.util.InputMismatchException if the input is not an integer.
 */
    public int pickPiece(int pileSize) {
        Scanner scanner = new Scanner(System.in);
        int chosenPiece = 0; 

        if (pileSize == 1) {
            System.out.println("There is only 1 piece left. You must take it.");
            return 1; // The player must take the last piece
        }

        // Ensure the player selects a valid number of pieces
        while (chosenPiece < 1 || chosenPiece > pileSize / 2) {
            System.out.print("Choose how many pieces to take (1 to " + pileSize / 2 + "): ");
            chosenPiece = scanner.nextInt();
        }
        return chosenPiece;
    }
}