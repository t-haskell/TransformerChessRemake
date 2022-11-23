public class ActionSpawn extends Action{

    public ActionSpawn(GameS22 myGame, int ogRow, int ogCol, int toRow, int toCol){
        super(myGame,ogRow,ogCol,toRow,toCol);

    }

    @Override
    public void performAction() {
        myGame.getGameBoard().getSquares()[ogRow][ogCol].getPiece().speak();
        myGame.getCurrentTeam().addPieceToTeam(myGame.getGameBoard().getSquares()[ogRow][ogCol].getPiece().spawn());
        myGame.getGameBoard().getSquares()[toRow][toCol].setPiece(myGame.getCurrentTeam().getTeamPieces().get(myGame.getCurrentTeam().getTeamPieces().size()-1));
        myGame.changeTurn();

    }
}
