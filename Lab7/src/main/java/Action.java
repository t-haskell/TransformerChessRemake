public abstract class Action {
    protected GameS22 myGame;
    protected int ogRow;
    protected int ogCol;
    protected int toRow;
    protected int toCol;

    public Action(GameS22 myGame, int ogRow, int ogCol, int toRow, int toCol){
        this.myGame = myGame;
        this.ogRow = ogRow;
        this.ogCol = ogCol;
        this.toRow = toRow;
        this.toCol = toCol;
    }

    public abstract void performAction();

}
