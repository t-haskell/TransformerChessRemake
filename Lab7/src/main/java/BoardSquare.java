public class BoardSquare {
    private boolean isEmpty;
    private Piece piece;
    private String squareColor;

    public BoardSquare(String squareColor){
        this.isEmpty = true;
        this.squareColor = squareColor;
        this.piece = null;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public boolean isEmpty(){
        return this.isEmpty;
    }

    public String getSquareColor(){
        return this.squareColor;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
        this.isEmpty = false;
    }

    public Piece removePiece(){
        Piece temp = this.piece;
        this.piece = null;
        this.isEmpty = true;
        return temp;
    }
    @Override
    public String toString(){
        //System.out.println(this.piece);
        if(this.piece == null){
            //System.out.println("NULL");
            return "-------";
        }
        else{
            return "-" + this.piece.toString() + "-";
        }
    }

}
