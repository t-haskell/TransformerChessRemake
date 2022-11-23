import java.util.ArrayList;


public class GameS22 extends Game {

    public GameS22(int numRows, int numCols, Team team1, Team team2) {
        super(numRows, numCols, team1, team2);
    }

    public boolean isAWinner() {
        if (this.getWinner() == getCurrentTeam()) {
            return true;
        } else {
            return false;
        }
    }

    public Team getWinner() {

        boolean team1Won = false;
        boolean team2Won = false;
        int rowAmount = gameBoard.getNumRows()-1;
        int colAmount = gameBoard.getNumColumns()-1;

        if (isGameEnded()) {
            System.out.println(isGameEnded());
            for(int i = 0; i < rowAmount; i++) {
                for (int j = 0; j < colAmount; j++) {
                    if (gameBoard.getSquares()[i][j].getPiece() != null) {
                        System.out.println(gameBoard.getSquares()[i][j].getPiece().getTeamColor()+' '+team1.getTeamColor());
                        if ((gameBoard.getSquares()[i][j].getPiece().getTeamColor().equals(team1.getTeamColor()))) {
                            team1Won = true;
                        }
                        if (gameBoard.getSquares()[i][j].getPiece().getTeamColor().equals(team2.getTeamColor())) {
                            team2Won = true;
                        }
                    }
                }
            }
        }
        System.out.println(team1Won);
        System.out.println(team2Won);
        if (team1Won){
            return team1;
        }
        else if(team2Won){
            return team2;
        }
        else{
            return team1;
        }
    }


    public boolean isGameEnded() {
        //BoardSquare[][] temp = this.getGameBoard().getSquares();
        //ArrayList<Piece> temp2 = this.getCurrentTeam().getTeamPieces();
        //ArrayList<Piece> temp3 = this.getOpponentTeam().getTeamPieces();
        System.out.println("HERE");
        boolean team1Presence = false;
        boolean team2Presence = false;
        int rowAmount = gameBoard.getNumRows() - 1;
        int colAmount = gameBoard.getNumColumns() - 1;

        for (int i = 0; i < rowAmount; i++) {
            for (int j = 0; j < colAmount; j++) {
                if (gameBoard.getSquares()[i][j].getPiece() != null) {
                    if ((gameBoard.getSquares()[i][j].getPiece().getTeamColor().equals(team1.getTeamColor()))) {
                        team1Presence = true; //team1 is out of players
                    }
                    if (gameBoard.getSquares()[i][j].getPiece().getTeamColor().equals(team2.getTeamColor())) {
                        team2Presence = true; //team2 is out of players
                    }
                }
            }
        }

        if ((team1Presence == false) || (team2Presence == false)) {
            return true;
        } else {
            return false;
        }
    }
}