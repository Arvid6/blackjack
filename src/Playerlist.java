import java.util.ArrayList;

public class Playerlist {
    ArrayList<Player> list = new ArrayList<>();

    public void add(Player p){
        list.add(p);
    }

    public Player get(int i){
        return list.get(i);
    }
}
