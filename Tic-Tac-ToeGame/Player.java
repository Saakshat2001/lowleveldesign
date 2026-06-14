public class Player {

        String playerName;
        PlayingPiece playingPiece;
        public Player(String playerName, PlayingPiece playingPiece){
                this.playerName= playerName;
                this.playingPiece = playingPiece;
        }

        public String getPlayerName() {
                return playerName;
        }

        public PlayingPiece getPlayingPiece() {
                return playingPiece;
        }

}
