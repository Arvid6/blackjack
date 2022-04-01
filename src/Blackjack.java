import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

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

    public static void main(String[] args) throws IOException, InterruptedException {
        int n = 2;
        double p = 5000;
        Blackjack game = new Blackjack(n, p);
        Deck deck = new Deck();
        while(game.getGamestate()){
            for(int i = 1; i <= game.getTp(); i++){
                System.out.println("Player " + i + " how much do you want to bet? \nCurrent balance: " + game.getPlayer(i).getCurrent());
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int amount = Integer.parseInt(reader.readLine());
                game.getPlayer(i).setBet(amount);
            }
            for(int j = 0; j <= game.getTp(); j++){
                System.out.flush();
                game.getPlayer(j).setStartHand(deck.draw());
                game.getPlayer(j).setStartHand(deck.draw());
            }
            for(int a = 0; a <= game.getTp(); a++){
                if(a == 0){

                    System.out.println("Dealer hand : " + game.getPlayer(a).getHand() + "\n");
                }
                else{
                    System.out.println("Player " + a + " hand: " + game.getPlayer(a).getHand());
                }

            }
            for(int b = 1; b<= game.getTp(); b++){
                String aw;
                BufferedReader reader;
                while (true){
                    System.out.println("\n" + "Dealer hand : " + game.getPlayer(0).getHand() + "\nPlayer " + b + " hand: " + game.getPlayer(b).getHand() + "\nDo you want to Hit, Double or Stand? [H, D, S]");
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    aw = reader.readLine();
                    if(Objects.equals(aw, "H")){
                        game.getPlayer(b).setStartHand(deck.draw());
                        if(game.getPlayer(b).getValue() > 21){
                            System.out.println("You over!!!");
                            game.getPlayer(b).setStatF();
                            break;
                        }
                        else if(game.getPlayer(b).getValue() == 21){
                            System.out.println("\nPlayer " + b + " hand: " + game.getPlayer(b).getHand() + "\nYou got 21!!!");
                            break;
                        }
                    }
                    else if(Objects.equals(aw, "D")){
                        game.getPlayer(b).setStartHand(deck.draw());
                        System.out.println("Player " + b + " hand: " + game.getPlayer(b).getHand());
                        if(game.getPlayer(b).getValue() > 21){
                            System.out.println("\nPlayer " + b + " hand: " + game.getPlayer(b).getHand() + "You over!!!");
                            game.getPlayer(b).setStatF();
                        }
                        break;
                    }
                    else if(Objects.equals(aw, "S")){
                        break;
                    }
                    else{
                        System.out.println("Try again!!");
                    }
                }
            }
            while(true){
                if(game.getPlayer(0).getValue() < 17){
                    System.out.println("Dealer hand : " + game.getPlayer(0).getHand());
                    game.getPlayer(0).setStartHand(deck.draw());
                }
                else if(game.getPlayer(0).getValue() > 21){
                    System.out.println("Dealer hand : " + game.getPlayer(0).getHand() + "\nDealer over!");
                    for(int c = 1; c <= game.getTp(); c++){
                        if(game.getPlayer(c).getValue() > game.getPlayer(0).getValue() && game.getPlayer(c).getValue() < 22){
                            System.out.println("Player " + c + "Wins!!");
                            game.getPlayer(c).setCurrent(game.getPlayer(c).getBet());
                        }
                        else{
                            System.out.println("Player " + c + "Looses :(");
                            game.getPlayer(c).setCurrent(-game.getPlayer(c).getBet());
                        }
                    }
                    break;
                }
                else{
                    for(int d = 1; d <= game.getTp(); d++){
                        if(game.getPlayer(d).getValue() > game.getPlayer(0).getValue() && game.getPlayer(d).getValue() < 22){
                            game.getPlayer(d).setCurrent(game.getPlayer(d).getBet());
                            System.out.println("Player " + d+ " Wins!!");
                        }
                        else if(game.getPlayer(d).getValue() == game.getPlayer(0).getValue()){
                            System.out.println("Player " + d+ " goes even");

                        }
                        else{
                            System.out.println("Player " + d+ " Looses :(");
                            game.getPlayer(d).setCurrent(-game.getPlayer(d).getBet());
                        }
                    }
                    break;
                }
            }
            for(int i = 0; i <= game.getTp(); i++){
                game.getPlayer(i).clearHand();
                game.getPlayer(i).setStatT();
            }
        }
    }
}
