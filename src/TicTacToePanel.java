public class TicTacToePanel {
    // empty constructor
    public TicTacToePanel() {}

    // method to show the border and calculate the remaining slots
    public int showTheBorder(int[][] panel) {

        int remainingSlots = 9;
        // assisting table for the printing of each row
        char[] rowSymbol = new char[3];

        // horizontal numbers at the top that show the column number
        System.out.println("\n\t 1\t 2\t 3\n");

        // repetition in order to fill the border with the appropriate symbols
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (panel[i][j] == -1) {
                    rowSymbol[j] = 'X';
                    remainingSlots--;
                }
                else if ( panel[i][j] == 1) {
                    rowSymbol[j] = 'O';
                    remainingSlots--;
                }
                else {
                    rowSymbol[j] = ' ';
                }
            }
            System.out.println((i+1) + "\t " + rowSymbol[0] + " | " + rowSymbol[1] + " | " + rowSymbol[2]);

            if (i < 2)
                System.out.println("\t---+---+---");
        }

        // after the creation of the board the reaming slots available are returned
        return remainingSlots;
    }

    // method to check if any of the players has won
    public boolean isThereAWinner(int[][] panelArray) {
        // 8 ways to win.

        // first row same symbols
        if (panelArray[0][0] == panelArray[0][1] && panelArray[0][1] == panelArray[0][2] && panelArray[0][0] != 0)
            return true;

        // second row same symbols
        if (panelArray[1][0] == panelArray[1][1] && panelArray[1][1] == panelArray[1][2] && panelArray[1][0] != 0)
            return true;

        // third row same symbols
        if (panelArray[2][0] == panelArray[2][1] && panelArray[2][1] == panelArray[2][2] && panelArray[2][0] != 0)
            return true;

        // first column same symbols
        if (panelArray[0][0] == panelArray[1][0] && panelArray[1][0] == panelArray[2][0] && panelArray[0][0] != 0)
            return true;

        // second column same symbols
        if (panelArray[0][1] == panelArray[1][1] && panelArray[1][1] == panelArray[2][1] && panelArray[0][1] != 0)
            return true;

        // third column same symbols
        if (panelArray[0][2] == panelArray[1][2] && panelArray[1][2] == panelArray[2][2] && panelArray[0][2] != 0)
            return true;

        // 1st diagonal
        if (panelArray[0][0] == panelArray[1][1] && panelArray[1][1] == panelArray[2][2] && panelArray[0][0] != 0)
            return true;

        // 2nd diagonal
        if (panelArray[0][2] == panelArray[1][1] && panelArray[1][1] == panelArray[2][0] && panelArray[0][2] != 0)
            return true;

        // else there is no winner
        return false;
    }
}
