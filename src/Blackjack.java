import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Blackjack {

    private final int tp;
    private boolean gr = true;
    private boolean bf = false;
    private Playerlist apl;
    private String[] dh = new String[2];

    public Blackjack(int tp, double p) {
        this.tp = tp;
        apl = new Playerlist();
        for(int i = 0; i < tp; i++){
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

    public void setBf(){
        if(bf){
            bf = false;
        }
        else{
            bf = true;
        }
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
        while(game.getGamestate()){
            for(int i = 0; i < game.getTp(); i++){
                System.out.println("Player " + (i+1) + " how much do you want to bet? \nCurrent balance: ");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int amount = Integer.parseInt(reader.readLine());
            }
            for(int j = 0; j < game.getTp(); j++){
                //add code to draw card
            }
            //Give dealer a card
            for(int k = 0; k < game.getTp(); k++){
                //add code to draw card 2
            }
            game.setBf();
            //give dealer second card
            while(game.getBf()){
                for(int a = 0; a < game.getTp(); a++){
                    //code for betting
                }
            }
        }
    }

}
