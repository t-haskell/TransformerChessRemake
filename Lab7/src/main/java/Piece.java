public abstract class Piece {
    protected char symbol;
    protected String teamColor;
    protected boolean original;
    protected boolean hidden;

    public Piece(char symbol, String teamColor, boolean hidden, boolean original) {
        this.symbol = symbol;
        this.teamColor = teamColor;
        this.hidden = hidden;
        this.original = original;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public String getTeamColor() {
        return this.teamColor;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public boolean isOriginal() {
        return this.original;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setOriginal(boolean original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return this.teamColor + ' ' + this.symbol;
    }

    public abstract void speak();
    public abstract Piece spawn();
    abstract boolean validMovePath(int fromSquareRow, int fromSquareCol, int toSquareRow, int toSquareCol);
}