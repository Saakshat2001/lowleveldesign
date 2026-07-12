import enums.PieceColor;

public class ChessDemo {

    static void main() {

        Game game = new Game();

        // ---------- Setup board for demo ----------

        // Remove original black king
        game.board.cells[7][4].piece = null;

        // Place black king on a square reachable by white queen
        game.board.cells[3][6].piece = new King(PieceColor.BLACK);

        // Clear queen's diagonal
        game.board.cells[1][4].piece = null;

        // ---------- White captures king ----------

        game.makeMove(
                new Position(0,3),
                new Position(3,6)
        );

        System.out.println("\nMove History");
        System.out.println("----------------");

        for(Move move : game.history){
            System.out.println(move);
        }

        game.printResult();
    }
}
