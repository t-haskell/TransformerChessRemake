public class PieceBlueHen extends Piece implements Attacker,Recruiter {
    private char symbol;
    private String teamColor;
    private int numAttacks;
    private int numRecruits;
    private boolean hidden;
    private boolean original;
    private boolean flies;

    final public int MAX_NUM_ATTACKS = 3;

    public PieceBlueHen(char symbol, String teamColor, int numAttacks, int numRecruits, boolean hidden, boolean original) {
        super(symbol, teamColor, original, hidden);
        this.numAttacks = numAttacks;
        this.numRecruits = numRecruits;
        updateFly();
    }

    public PieceBlueHen() {
        this('H', "NON",
                0, 0,
                false, true);
    }

    /*
    public char getSymbol() {
        return symbol;
    }
    public String getTeamColor() {
        return teamColor;
    }
    */
    public int getNumAttacks() {
        return this.numAttacks;
    }

    public int getNumRecruits() {
        return this.numRecruits;
    }

    /*
    public boolean isHidden() {
        return hidden;
    }
    public boolean isOriginal() {
        return original;
    }
    */
    public boolean canFly() {
        return this.flies;
    }

    /*
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
    public void setTeamColor(String teamColor) {
        this.teamColor = teamColor;
    }
    */
    public void setNumAttacks(int numAttacks) {
        this.numAttacks = numAttacks;
        updateFly();
    }

    public void setNumRecruits(int numRecruits) {
        this.numRecruits = numRecruits;
    }

    /*
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    public void setOriginal(boolean original) {
        this.original = original;
    }
````*/
    private void updateFly() {
        if (this.numAttacks < MAX_NUM_ATTACKS) {
            this.flies = true;
        } else {
            this.flies = false;
        }
    }

    public void speak() {
        System.out.println("Go UD!");
    }

    public boolean validMovePath(int fromSquareRow, int fromSquareCol,
                                 int toSquareRow, int toSquareCol) {
        // You will implement this method in a later step
        // each Piece will have a different valid path
        return true;
    }
    public boolean validRecruitPath(int bsRow,int bsCol,int recruitRow,int recruitCol){
        return true;
    }
    public boolean validAttackPath(int bsRow,int bsCol,int opponentRow,int opponentCol){
        return true;
    }


    public PieceBlueHen spawn() {
        PieceBlueHen copyHen =
                new PieceBlueHen(Character.toLowerCase(this.symbol),
                        this.teamColor, this.numAttacks, this.numRecruits,
                        false, false);
        return copyHen;
    }

    public boolean canSpawn() {
        return true;
    }
}
