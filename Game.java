import java.util.Scanner;
import Misc.*;

public class Game {
    private Misc m = new Misc();
    private Scanner in = new Scanner(System.in);

    private Player[] p = new Player[2];
    private boolean lastTurn;
    private Board b = new Board();

    public Game(String p1name, String p2name) {
        p[0] = new Player(p1name);
        p[1] = new Player(p2name);
    }

    public boolean nextTurn() {
        Player p = this.p[lastTurn ? 1 : 0];
        lastTurn = !lastTurn;
        byte x;
        byte y;
        // Get x and y for pos from user
        System.out.println();
        System.out.println(p.name + ", it's your turn!");

        while (true) {
            System.out.print("\nPlease enter the x coordinate of where you would like to place your piece (0-2): ");
            x = m.nextByte(in);
            System.out.print("\nPlease enter the y coordinate of where you would like to place your piece (0-2): ");
            // Invert so the stored value is the opposite of provided value (more natural placements)
            // (map range 0-2, 2-0)
            y = (byte) (( m.nextByte(in) - 2) * -1);

            // Make sure specified xy is usable before accepting it
            if (x > 2 || x < 0 || y > 2 || y < 0){
                System.out.println("A value is out of the maximum range, please specify a number from 0 to 2.");
                continue;
            }
            if (b.isPopulated(x, y)) {
                System.out.println("This space is already occupied, please select another space.");
                System.out.println(b);
                continue;
            }
            break;
        }

        // Attempt to place
        if(b.place(p.team, x, y)){
            System.out.println();
            System.out.println("Piece placed!");
            System.out.println();
            System.out.println(b);
        }
        else System.out.println("Something went wrong placing your piece.  Well whatever!");
        
        // Check for wins
        if(Piece.totalPlaced >= 5){
            if(b.hasWin()){
                System.out.println("Game over! " + p.name + " wins!");
                return true;
            }
        }

        // Check for stalemate
        if(Piece.totalPlaced >= 9){
            System.out.println("Stalemate! Good game!");
            return true;
        }
        return false;
    }

}
