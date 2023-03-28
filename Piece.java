public class Piece {
    public static byte totalPlaced;
    public final boolean team;

    public Piece(boolean team){
        totalPlaced += 1;
        this.team = team;
    }

    @Override
    public String toString(){
        return team ? "O" : "X";
    }
}
