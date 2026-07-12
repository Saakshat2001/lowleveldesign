import enums.PieceColor;
import enums.PieceType;

public class Rook extends Piece{
    Rook(PieceColor color) {
        super(color, PieceType.ROOK);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        Cell target = board.getCell(to);

        if (!canCapture(target))
            return false;

        boolean valid =
                from.row == to.row ||
                        from.col == to.col;

        return valid &&
                isPathClear(board, from, to);
    }
}
