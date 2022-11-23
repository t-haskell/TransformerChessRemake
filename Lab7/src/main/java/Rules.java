public class Rules {
    public static boolean checkValidAction(Game currentGame, int bsFromRow, int bsFromCol, int bsToRow, int bsToCol, char actionType) {
        //if piece is from current team
        Piece currentPiece = currentGame.getGameBoard().getSquares()[bsFromRow][bsFromCol].getPiece();
        System.out.println("Current Piece "+currentPiece.toString()+" Action type"+actionType);
        boolean evilMinionFlag = currentPiece instanceof PieceEvilMinion;
        System.out.println("Current Piece "+evilMinionFlag);

        if ((currentPiece.getTeamColor().equals(currentGame.getCurrentTeam().getTeamColor()))) {
            if (evilMinionFlag) {
                if (actionType == 'M' || actionType == 'm') {
                    if (currentGame.getGameBoard().getSquares()[bsToRow][bsToCol].isEmpty()) {
                        return true;
                    }

                    else if (actionType == 'A' || actionType == 'a') {
                        if (!(currentGame.getBoardSquares()[bsToRow][bsToCol].getPiece().getTeamColor().equals(currentGame.getCurrentTeam().getTeamColor()))) {
                            if (((PieceEvilMinion) currentPiece).canAttack()) {
                                return true;
                            }
                        }
                        else if (currentGame.getBoardSquares()[bsToRow][bsToCol].getPiece().getTeamColor().equals(currentGame.getCurrentTeam().getTeamColor())) {
                            if (currentGame.getBoardSquares()[bsToRow][bsToCol].getPiece() instanceof PieceMinion) {
                                return true;
                            }
                        }
                    }


                }
                else if (actionType == 'R' || actionType == 'r') {
                    if (!(currentGame.getGameBoard().getSquares()[bsFromRow][bsFromCol].getPiece().getTeamColor().equals(currentGame.getGameBoard().getSquares()[bsToRow][bsToCol].getPiece().getTeamColor()))) {
                        return true;
                    }

                }
            }


            else if (currentGame.getGameBoard().getSquares()[bsToRow][bsToCol].isEmpty()) {
                if (actionType == 'M' || actionType == 'm') {
                    return true;
                } else if ((actionType == 'S' || actionType == 's')) {
                    if (!(currentPiece instanceof PieceBuzz)) {
                        return true;
                    }

                }
            }
            else if (!(currentPiece.getTeamColor().equals(currentGame.getGameBoard().getSquares()[bsToRow][bsToCol].getPiece().getTeamColor()))) {
                if (actionType == 'R' || actionType == 'r') {
                    System.out.println("RECRUTITSTS");
                    if (!(currentPiece instanceof PieceBuzz)) {
                        return true;
                    }
                }
                else if (actionType == 'A' || actionType == 'a') {
                    if (currentPiece instanceof PieceBuzz) {
                        if (((PieceBuzz) currentPiece).canAttack()) {
                            return true;
                        }
                    }
                    else if (currentPiece instanceof PieceBlueHen) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

}