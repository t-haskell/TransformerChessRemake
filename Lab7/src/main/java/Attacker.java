public interface Attacker{
    public abstract int getNumAttacks();
    public abstract void setNumAttacks(int numRecruits);
    public abstract boolean validAttackPath(int bsRow,int bsCol,int opponentRow,int opponentCol);
}
