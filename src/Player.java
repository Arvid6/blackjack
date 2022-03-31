public class Player {
    private double current;
    private String[] hand = new String[2];

    public Player(double p){
        current = p;
    }

    public double getCurrent(){
        return current;
    }

    public void updateCurrent(double n){
        current += n;
    }

    public void setHand(String[] i){
        hand[0] = i[0];
        hand[1] = i[1];
    }
}
