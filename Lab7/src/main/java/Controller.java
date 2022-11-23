import java.util.ArrayList;


public class Controller {
    private GameS22 myGame;
    private TextView visual;

    public GameS22 setUpGameModel() {
        // Create 4 pieces for team A

        // Load the pieces in an ArrayList
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(new PieceMinion('M', "Blu",
                0, 0, false, true));
        piecesTeamA.add(new PieceBuzz('B', "Blu", 2, 1,
                true, false, true));
        piecesTeamA.add(new PieceBlueHen('H', "Blu", 3,
                9, false, true));
        piecesTeamA.add(new PieceEvilMinion('E', "Blu", 1,
                1, 4, false, true));
        // Create a team object
        Team teamA = new Team("Blu", piecesTeamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        System.out.println("Boom");
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(new PieceMinion('M', "Red",
                0, 0, false, true));
        piecesTeamB.add(new PieceBlueHen('H', "Red", 3,
                9, false, true));
        piecesTeamB.add(new PieceBuzz('B', "Red", 2, 1,
                true, false, true));
        piecesTeamB.add(new PieceEvilMinion('E', "Red", 1,
                1, 4, false, true));
        // Create a team object
        Team teamB = new Team("Red", piecesTeamB);

        // Create an instance of the game
        return new GameS22(8, 8, teamA, teamB);
    }

    public Controller(){
        myGame = setUpGameModel();
        TextView myScreen = new TextView();
        visual = myScreen;
        visual.updateView(myGame);
    }

    public void carryOutAction(int fromRow, int fromColumn, int toRow, int toColumn, char action){
        if(action == 'A'||action == 'a'){
            ActionAttack move = new ActionAttack(myGame, fromRow, fromColumn, toRow, toColumn);
            move.performAction();
        }
        if(action == 'M'||action == 'm'){
            ActionMove move = new ActionMove(myGame, fromRow, fromColumn, toRow, toColumn);
            move.performAction();
        }
        if(action == 'R'||action == 'r'){
            ActionRecruit move = new ActionRecruit(myGame, fromRow, fromColumn, toRow, toColumn);
            move.performAction();
        }
        if(action == 'S'||action == 's'){
            ActionSpawn move = new ActionSpawn(myGame, fromRow, fromColumn, toRow, toColumn);
            move.performAction();
        }
    }

    public void playGame(){
        //System.out.println();
        while(!myGame.isGameEnded()) {
            visual.getNextPlayersAction(myGame);
            if (Rules.checkValidAction(myGame, visual.fromRow, visual.fromCol, visual.toRow, visual.toCol, visual.actionType)){
                carryOutAction(visual.fromRow, visual.fromCol, visual.toRow, visual.toCol, visual.actionType);
                System.out.println(myGame.toString());
            }
        }
        visual.printEndOfGameMessage(myGame);
    }

    public static void main(String[] args){
        Controller myController = new Controller();
        myController.playGame();
    }


}