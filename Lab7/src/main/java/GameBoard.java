public class GameBoard {
    private int rows;
    private int columns;
    private BoardSquare[][] squares;

    public GameBoard(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        BoardSquare[][] newArray = new BoardSquare[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int s = 0; s < columns; s++){
                newArray[i][s] = new BoardSquare("");
            }
        }
        this.squares = newArray;
        this.setUpEmptyBoard();
    }

    public int getNumRows(){
        return this.rows;
    }
    public int getNumColumns(){
        return this.columns;
    }
    public BoardSquare[][] getSquares(){
        return squares;
    }

    public boolean inBounds(int row, int column){
        if((this.rows <= row)||(row < 0)) {
            return false;
        }else{
            if((this.columns <= column)||(row < 0)){
                return false;
            }else{
                return true;
            }
        }
    }

    private void setUpEmptyBoard(){
        for(int i = 0; i < rows; i++){
            for(int s = 1; s <= columns; s++){
                if(s%2==0){
                    BoardSquare newSquare = new BoardSquare("White");
                }else{
                    BoardSquare newSquare1 = new BoardSquare("Blue");
                }
            }
        }
    }

    public BoardSquare findRandomEmptySpace(){
        boolean flag = true;
        BoardSquare temp = new BoardSquare("");
        while(flag){
            int rowGuess = (int) (Math.random() * this.getNumRows());
            int columnGuess = (int) (Math.random() * this.getNumColumns());

            if(squares[rowGuess][columnGuess].isEmpty()){
                flag = false;
                temp = squares[rowGuess][columnGuess];
            }
        }
        return temp;
    }

    @Override
    public String toString(){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for(int col = 0; col < squares[0].length; col++){
            boardString.append(col + "        ");
        }
        boardString.append("\n");
        for(int row = 0; row < squares.length; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < squares[row].length; col++){
                boardString.append(squares[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

}
