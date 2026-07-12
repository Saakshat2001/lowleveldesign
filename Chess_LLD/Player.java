import enums.PieceColor;

public class Player {

            String name;
            PieceColor color;
            Player(String name, PieceColor color){
                this.name = name;
                this.color = color;
            }

    @Override
    public String toString() {
        return name;
    }
}

