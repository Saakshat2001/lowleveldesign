import enums.PieceColor;
import enums.PieceType;

public class Bishop extends Piece{
    Bishop(PieceColor color) {
        super(color, PieceType.BISHOP);
    }

    @Override
    public boolean isValidMove(Board board, Position from, Position to) {
        Cell target = board.getCell(to);

        if (!canCapture(target))
            return false;

        int rowDiff = Math.abs(to.row - from.row);
        int colDiff = Math.abs(to.col - from.col);

        return rowDiff == colDiff &&
                isPathClear(board, from, to);
    }
}
