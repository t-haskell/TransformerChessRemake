public interface Recruiter {
    public abstract int getNumRecruits();
    public abstract void setNumRecruits(int numRecruits);
    public abstract boolean validRecruitPath(int bsRow,int bsCol,int recruitRow,int recruitCol);

}
