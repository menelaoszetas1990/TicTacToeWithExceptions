import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // table to keep the two players
    private static Player[] players = new Player[2];

    // scanner to monitor users input
    private static Scanner userInput = new Scanner( System.in );

    // creation of the TicTacToe class so we can show the border
    // and check for the winner
    private static TicTacToePanel ticTacToePanel = new TicTacToePanel();

    // table 3x3 with the free spots and users plays
    private static int[][] panelArray = new int[3][3];

    public static void main (String[] args) {
        // boolean variable to monitor when Player 1 is playing
        boolean playerOneTurn = true;
        // boolean variable to monitor if there is a winner
        boolean win;

        System.out.println("--------------------------------------");
        System.out.println("ΚΑΛΩΣ ΗΡΘΑΤΕ ΣΤΟ ΠΑΙΧΝΙΔΙ ΤΗΣ ΤΡΙΛΙΖΑΣ");
        System.out.println("--------------------------------------\n");

        // method to take the players names
        getPlayerNames();

        // show border for 1st time
        ticTacToePanel.showTheBorder(panelArray);

        // repetition of max 9 times (the max numbers of plays that can occur in TicTacToe
        int i = 0;
        while (i < 9) {

            try {
                // try to get player's coordinates where to put his symbol
                // based on playerOneTurn variable we can understand whose turn it is
                getPlayerChoice(playerOneTurn);

                ticTacToePanel.showTheBorder(panelArray);

                // only after 5 plays (i = 4) a win is possible
                if (i >= 4) {
                    // check if there is a winner
                    win = ticTacToePanel.isThereAWinner(panelArray);
                    if (win) {
                        if (playerOneTurn) {
                            System.out.println("\nΝΙΚΗΤΗΣ Ο ΠΑΙΧΤΗΣ: " + players[0]);
                        }
                        else {
                            System.out.println("\nΝΙΚΗΤΗΣ Ο ΠΑΙΧΤΗΣ: " + players[1]);
                        }
                        break;
                    }
                    // else we have draw
                    else {
                        if (i == 8) {
                            System.out.println("\nΙΣΟΠΑΛΙΑ");
                        }
                    }
                }

                // if everything passed then change the player who is playing
                playerOneTurn = !playerOneTurn;
                i++;

            }
            // if user goes out of bounds either at row or column he has to give
            // again his choice
            catch (IndexOutOfBoundsException e1) {
                System.out.println(e1);
                i--;
            }
            // if user choice is on an already chosen shell throw error
            catch (ChoiceAlreadyExistsException e2){
                System.out.println(e2);
//                ticTacToePanel.showTheBorder(panelArray);
                i--;
            }
            catch (InputMismatchException e3) {
                System.out.println("ΛΑΘΟΣ ΕΙΣΑΓΩΓΗ!\nΠΑΡΑΚΑΛΩ ΕΙΣΑΓΕΤΕ ΑΡΙΘΜΟ ΑΠΟ 1 ΕΩΣ 3");
                userInput.nextLine();
                i--;
            }
        }
    }

    // private method to get players names
    private static void getPlayerNames() {
        String playerName;

        System.out.println("ΠΑΡΑΚΑΛΩ ΔΩΣΤΕ ΤΟ ΟΝΟΜΑ ΤΟΥ ΠΡΩΤΟΥ ΠΑΙΧΤΗ:");
        playerName = userInput.nextLine();
        // if user does not give a name, then he is assigned his player's
        // default name
        if (playerName.equals("")) {
            playerName = "Player 1";
        }
        players[0] = new Player(playerName);

        System.out.println("ΠΑΡΑΚΑΛΩ ΔΩΣΤΕ ΤΟ ΟΝΟΜΑ ΤΟΥ ΔΕΥΤΕΡΟΥ ΠΑΙΧΤΗ:");
        playerName = userInput.nextLine();
        if (playerName.equals("")) {
            playerName = "Player 2";
        }
        players[1] = new Player(playerName);
    }

    public static void getPlayerChoice (boolean playerOneTurn) throws IndexOutOfBoundsException, ChoiceAlreadyExistsException, InputMismatchException {
        // variables for user choice
        int rowNumber, columnNumber;

        // based on what player is playing assign values to variables accordingly
        int player = 0;
        int symbolCode = -1;
        char symbol = 'X';
        if (!playerOneTurn) {
            player = 1;
            symbolCode = 1;
            symbol = 'O';
        }

        System.out.println("\nO/H " + players[player] + " ΝΑ ΔΩΣΕΙ ΤΟΝ ΑΡΙΘΜΌ ΤΗΣ ΓΡΑΜΜΗΣ ΠΟΥ ΘΑ ΒΑΛΕΙ ΤΟ " + symbol + " (1 έως 3):");
        rowNumber = userInput.nextInt();
        if (rowNumber < 1 || rowNumber > 3) {
            throw new IndexOutOfBoundsException("\nΗ ΕΠΙΛΟΓΗ ΤΗΣ ΣΕΙΡΑΣ ΔΕΝ ΕΙΝΑΙ ΣΩΣΤΗ!\nΑΠΑΙΤΕΙΤΑΙ ΑΡΙΘΜΟΣ 1 ΕΩΣ 3!\nΕΙΣΑΓΩΓΗ ΣΥΝΤΕΤΑΓΜΕΝΩΝ ΞΑΝΑ");
        }

        System.out.println("O/H " + players[player] + " ΝΑ ΔΩΣΕΙ ΤΟΝ ΑΡΙΘΜΌ ΤΗΣ ΣΤΗΛΗΣ ΠΟΥ ΘΑ ΒΑΛΕΙ ΤΟ " + symbol + " (1 έως 3):");
        columnNumber = userInput.nextInt();
        if (columnNumber < 1 || columnNumber > 3) {
            throw new IndexOutOfBoundsException("\nΗ ΕΠΙΛΟΓΗ ΤΗΣ ΣΤΥΛΗΣ ΔΕΝ ΕΙΝΑΙ ΣΩΣΤΗ!\nΑΠΑΙΤΕΙΤΑΙ ΑΡΙΘΜΟΣ 1 ΕΩΣ 3!\nΕΙΣΑΓΩΓΗ ΣΥΝΤΕΤΑΓΜΕΝΩΝ ΞΑΝΑ");
        }

        // check if choice already exists
        if (panelArray[rowNumber - 1][columnNumber - 1] != 0) {
            throw new ChoiceAlreadyExistsException(rowNumber, columnNumber);
        }

        // if everything is ok then put user's symbol at the border array
        panelArray[rowNumber - 1][columnNumber -1] = symbolCode;
    }
}
