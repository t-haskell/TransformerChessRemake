import java.util.ArrayList;

public class Team {
    protected String teamColor;
    protected ArrayList<Piece> teamList;

    Team(String teamColor,ArrayList<Piece> teamList){
        this.teamColor = teamColor;
        this.teamList = teamList;
    }

    public String getTeamColor(){
        return this.teamColor;
    }
    public ArrayList<Piece> getTeamPieces(){
        return this.teamList;
    }

    public void removePieceFromTeam(Piece value){
        for (int i=0;i<teamList.size();i++){
            if (teamList.get(i) == value){
                teamList.remove(teamList.get(i));
            }
        }
    }

    public void addPieceToTeam(Piece value){
        value.teamColor = teamColor;
        teamList.add(value);
    }

    @Override
    public String toString(){

        String pieces = "Team "+this.teamColor+" Pieces :\n";
        for (int i=0;i<teamList.size();i++) {
            pieces = pieces + (teamColor+' '+ teamList.get(i).symbol+' ');
        }
        return pieces;
    }
}
