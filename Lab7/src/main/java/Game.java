import java.util.Collections;

public abstract class Game {
    protected GameBoard gameBoard;
    protected Team team1;
    protected Team team2;
    String turn;

    private void initializeGameBoard(int rows,int cols){
        gameBoard = new GameBoard(rows,cols);
        for (int i=0;i<team1.teamList.size();i++){
            BoardSquare temp1 = gameBoard.findRandomEmptySpace();
            temp1.setPiece(team1.teamList.get(i));
        }
        for (int i=0;i<team2.teamList.size();i++){
            BoardSquare temp2 = gameBoard.findRandomEmptySpace();
            temp2.setPiece(team2.teamList.get(i));
        }



    }

    protected Game(int rows,int cols,Team firstTeam,Team secondTeam){
        turn = firstTeam.teamColor;
        team1 = firstTeam;
        team2 = secondTeam;
        initializeGameBoard(rows,cols);
    }

    public GameBoard getGameBoard(){
        return this.gameBoard;
    }

    public Team getCurrentTeam(){
        if(team1.teamColor == turn){
            return team1;
        }
        else{
            return team2;
        }
    }
    public Team getOpponentTeam(){
        if(team1.teamColor == turn){
            return team2;
        }
        else{
            return team1;
        }
    }

    public boolean isTurn(Team whichTeam){
        if(whichTeam.teamColor == turn){
            return true;
        }
        else{
            return false;
        }
    }

    public BoardSquare[][] getBoardSquares(){
        return gameBoard.getSquares();
    }

    public void changeTurn(){
        if(team1.teamColor == turn){
            turn = team2.teamColor;
        }
        else{
            turn = team1.teamColor;
        }
    }

    public abstract boolean isAWinner();
    public abstract Team getWinner();
    public abstract boolean isGameEnded();

    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Team " + getCurrentTeam().getTeamColor() + "'s turn\n");
        return retString.toString();
    }

}
