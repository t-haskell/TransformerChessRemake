public class ActionRecruit extends Action{
    protected ActionRecruit(GameS22 myGame,int fromRow,int fromCol,int toRow,int toCol){
        super(myGame,fromRow,fromCol,toRow,toCol);
    }
    public void performAction(){
        myGame.getBoardSquares()[ogRow][ogCol].getPiece().speak();
        myGame.getBoardSquares()[toRow][toCol].removePiece();
        myGame.getBoardSquares()[toRow][toCol].setPiece(myGame.getBoardSquares()[ogRow][ogCol].getPiece());
        myGame.changeTurn();
    }
}
