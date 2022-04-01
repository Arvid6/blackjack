import java.util.ArrayList;

public class Player {
    private double current;
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

    public void updateCurrent(double n){
        current += n;
    }

    public void setStartHand(Card i){
        hand.add(i);
    }
}
