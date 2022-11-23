public class PieceEvilMinion extends PieceMinion implements Attacker,Recruiter {
    private int numAttacks;
    private boolean hungry;
    public static int MAX_NUM_ATTACKS = 4;

    public PieceEvilMinion(char symbol, String teamColor, int numRecruits, int numAttacks, int numTimesSpawned, boolean hidden, boolean original) {
        super(symbol,teamColor,numRecruits,numTimesSpawned,hidden,original);
        this.numAttacks = numAttacks;
        this.updateHungry();
    }

    public PieceEvilMinion(){
        this('E',"NON",0,0,0,false,true);
    }
    /*
    public char getSymbol(){
        return this.symbol;
    }

    public String getTeamColor(){
        return this.teamColor;
    }



    public boolean isHidden(){
        return this.hidden;
    }

    public boolean isOriginal(){
        return this.original;
    }
    */

    public int getNumAttacks(){
        return this.numAttacks;
    }
    public int getNumRecruits(){
        return this.numRecruits;
    }

    public int getNumTimesSpawned(){
        return this.numTimesSpawned;
    }

    public boolean canSpawn(){
        if ((this.original == true) && (numTimesSpawned<MAX_NUM_SPAWNED)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean canAttack(){
        return this.hungry;

    }
    /*
    public void setSymbol(char symbol){
        this.symbol = symbol;
    }

    public void setTeamColor(String teamColor){
        this.teamColor = teamColor;
    }

     */
    public void setNumAttacks(int numAttacks){
        this.numAttacks = numAttacks;
    }

    public void setNumRecruits(int numRecruits){
        this.numRecruits = numRecruits ;
    }
    public void setNumTimesSpawned(int numTimesSpawned){
        this.numTimesSpawned =numTimesSpawned;
    }
    /*
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }
    public void setOriginal(boolean original){
        this.original = original;
    }

     */
    public void updateHungry(){
        if(numAttacks < MAX_NUM_ATTACKS){
            this.hungry = true;
        }
        else{
            this.hungry = false;
        }
    }

    public void speak(){
        System.out.println("Roar!");
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

    public PieceEvilMinion spawn(){
        char symbol = java.lang.Character.toLowerCase(this.symbol);
        PieceEvilMinion spawned = new PieceEvilMinion(symbol,this.teamColor,1,0,0,false,false);
        spawned.hungry = true;
        this.numTimesSpawned +=1;
        return spawned;
    }

}
