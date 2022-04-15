import java.util.ArrayList;

public class Player {
    private double current;
    private double cb = 0;
    private boolean alive = true;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(double p){
        current = p;
    }

    public double getCurrent(){
        return current;
    }

    public String getHand(){
        String s = "[ ";
        int t = 0;
        for(int i = 0; i < hand.size(); i++){
            s += hand.get(i).getCard() ;
            t += hand.get(i).getValue();
            if(i != hand.size()-1){
                s+= ", ";
            }
        }
        s+= " ] Value: " + t;
        return s;
    }

    public String getDHand(){
        String s = "[ ";
        int t = 0;
        s += hand.get(0).getCard() ;
        s+= ", ? ] Value: ?";
        return s;
    }

    public int getValue(){
        int t = 0;
        for(int i = 0; i < hand.size(); i++){
            t += hand.get(i).getValue();
        }
        return t;
    }

    public boolean getStat(){
        return alive;
    }

    public double getBet(){
        return cb;
    }

    public void updateCurrent(double n){
        current += n;
    }

    public void setStartHand(Card i){
        hand.add(i);
    }

    public void setStatT(){
        alive = true;
    }

    public void setStatF(){
        alive = false;
    }

    public void setBet(double b){
        cb = b;
    }

    public void setCurrent(double b){
        current += b;
    }

    public void clearHand(){
        hand = new ArrayList<>();
    }

}
