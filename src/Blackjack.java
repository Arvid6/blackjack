import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Blackjack {

    private final int tp;
    private boolean gr = true;
    private boolean bf = true;
    private Playerlist apl;

    public Blackjack(int tp, double p) {
        this.tp = tp;
        apl = new Playerlist();
        for(int i = 0; i <= tp; i++){
            Player temp = new Player(p);
            apl.add(temp);
        }
    }

    public int getTp(){
        return tp;
    }

    public boolean getBf(){
        return bf;
    }

    public Player getPlayer(int i){
        return apl.get(i);
    }

    public void setBf(){
        bf = !bf;
    }

    public void stopGame(){
        gr = false;
    }

    public boolean getGamestate(){
        return gr;
    }

    public static void main(String[] args) throws IOException {
        int n = 2;
        double p = 5000;
        Blackjack game = new Blackjack(n, p);
        Deck deck = new Deck();
        while(game.getGamestate()){
            for(int i = 0; i < game.getTp(); i++){
                System.out.println("Player " + (i+1) + " how much do you want to bet? \nCurrent balance: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int amount = Integer.parseInt(reader.readLine());
            }
            for(int j = 0; j < game.getTp(); j++){
                game.getPlayer(j).setStartHand(deck.draw());
                game.getPlayer(j).setStartHand(deck.draw());
            }
            while(game.getBf()){
                for(int a = 0; a < game.getTp(); a++){
                    System.out.println(game.getPlayer(a).getHand());
                }
                break;
            }
        }
    }

}
