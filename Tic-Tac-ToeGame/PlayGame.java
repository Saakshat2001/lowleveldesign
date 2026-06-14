public class PlayGame {


    public static void main(String[] args){

        System.out.println("\n===>>> TicTacToe Game\n");
            Game g = new Game();
            g.initializeGame();
            GameStatus status = g.startGame();
            switch(status){
                case WIN:
                    System.out.println("PieceType "+g.winner.getPlayingPiece().pieceType+" won ");
                    break;
                case DRAW:
                    System.out.println("Draw it is");
                    break;
                default:
                    System.out.print(" Game Ends");
                    break;
            }
    }
}
