import enums.PieceColor;
import enums.PieceType;

public class Queen extends Piece{
    Queen(PieceColor color) {
        super(color, PieceType.QUEEN);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        Cell target = board.getCell(to);

        if (!canCapture(target))
            return false;

        int dr = Math.abs(to.row - from.row);
        int dc = Math.abs(to.col - from.col);

        boolean valid =
                from.row == to.row ||
                        from.col == to.col ||
                        dr == dc;

        return valid &&
                isPathClear(board, from, to);
    }
}
