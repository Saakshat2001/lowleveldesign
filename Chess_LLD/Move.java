public class Move {


            Position from;
            Position to;
            Piece movedPiece;
            Piece capturedPiece;
    public Move(Position from,
                Position to,
                Piece movedPiece,
                Piece capturedPiece) {

        this.from = from;
        this.to = to;
        this.movedPiece = movedPiece;
        this.capturedPiece = capturedPiece;
    }
    @Override
    public String toString() {

        String ans = movedPiece + " : " + from + " -> " + to;
        if (capturedPiece != null) {
            ans += " | Captured : " + capturedPiece;
        }
        return ans;
    }
}
