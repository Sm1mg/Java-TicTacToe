public class Player {
    public final String name;
    public static boolean lastTeam;
    //False is "X" True is "O"
    public final boolean team;

    public Player(String n){
        name = n;
        //Automatically decide team by order of creation
        team = lastTeam;
        lastTeam = true;
    }
}
