public class ActionAttack extends Action{

    public ActionAttack(GameS22 myGame, int ogRow, int ogCol, int toRow, int toCol){
        super(myGame,ogRow,ogCol,toRow,toCol);
    }

    public void performAction(){
        myGame.getGameBoard().getSquares()[ogRow][ogCol].getPiece().speak();
        myGame.getGameBoard().getSquares()[toRow][toCol].removePiece();
        myGame.getOpponentTeam().removePieceFromTeam(myGame.getOpponentTeam().getTeamPieces().get(myGame.getOpponentTeam().getTeamPieces().size()-1));
        myGame.getGameBoard().getSquares()[toRow][toCol].setPiece(myGame.getGameBoard().getSquares()[ogRow][ogCol].getPiece());
        myGame.getGameBoard().getSquares()[ogRow][ogCol].removePiece();
        myGame.changeTurn();
    }
}
