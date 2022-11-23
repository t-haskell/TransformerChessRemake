import java.util.Scanner;

public class TextView {
    protected int fromRow;
    protected int fromCol;
    protected int toRow;
    public int toCol;
    public char actionType;


    public static char getUsersNextActionType(Scanner scr) {
        boolean validChar = false;
        char test = '-';
        while (!validChar) {
            System.out.println("Enter character or string containing: A,R,M,S");
            test = scr.next().charAt(0);
            ;
            if (test == 'A' || test == 'a' || test == 'R' || test == 'r' || test == 'M' || test == 'm' || test == 'S' || test == 's') {
                if (test == 'a') {
                    test = 'A';
                } else if (test == 'r') {
                    test = 'R';
                } else if (test == 'm') {
                    test = 'M';
                } else if (test == 's') {
                    test = 'S';
                }
                validChar = true;
            } else {
                System.out.println("Your input was not a valid character.");
            }
        }
        return test;
    }
    public static int getValidInt(int minInt, int maxInt, Scanner scr) {
        //Scanner scr = new Scanner(System.in);
        boolean validInt = false;
        int intInput = -1;
        while (!validInt) {
            System.out.println("Enter an integer from " + minInt + " - " + maxInt);
            if (scr.hasNextInt()) {
                // read in the integer
                intInput = scr.nextInt();
                // check if its a positive value
                if ((intInput >= minInt) && (intInput <= maxInt)) {
                    validInt = true;
                    System.out.println("Your value is: " + intInput);
                } else {
                    System.out.println("Your integer was not in the valid range.");
                }
            } else {
                // read the value the user entered
                scr.next();
                System.out.println("Your value is not an integer");
            }
        }
        return intInput;
    }


    public void getNextPlayersAction(Game currentGame) {
        Scanner scr = new Scanner(System.in);  // Create a Scanner object
        actionType = getUsersNextActionType(scr);
        System.out.println("Enter row and col of your piece to move");
        fromRow = getValidInt(0,currentGame.getGameBoard().getNumRows(),scr);
        fromCol = getValidInt(0,currentGame.getGameBoard().getNumColumns(),scr);
        System.out.println("Enter row and col of the square you want to move to");
        toRow = getValidInt(0,currentGame.getGameBoard().getNumRows(),scr);
        toCol = getValidInt(0,currentGame.getGameBoard().getNumColumns(),scr);
    }
    public void updateView(Game currentGame) {
        System.out.println(currentGame);
    }
    public void printEndOfGameMessage(Game currentGame) {
        System.out.println("Game Over! " + currentGame.getWinner().getTeamColor() + " Won the Game!");
    }
}
