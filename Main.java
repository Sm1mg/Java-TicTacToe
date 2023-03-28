import java.util.Scanner;
import Misc.*;
public class Main {
    public static void main(String[] args){
        Misc m = new Misc();
        Scanner in = new Scanner(System.in);

        System.out.print("Player 1, please enter your name: ");
        String p1Name = m.nextLine(in);

        System.out.println();
        System.out.print("Player 2, please enter your name: ");
        String p2Name = m.nextLine(in);
        
        Game g = new Game(p1Name, p2Name);
        while (!g.nextTurn()){
            
        }
    }
}
