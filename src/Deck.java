import java.util.Random;

public class Deck {
    Random rand = new Random();

    //Dogshit solution, but it should work
    Card[] deck = {new Card("AS", 11),
                new Card("2S", 2),
                new Card("3S", 3),
                new Card("4S", 4),
                new Card("5S", 5),
                new Card("6S", 6),
                new Card("7S", 7),
                new Card("8S", 8),
                new Card("9S", 9),
                new Card("10S",10),
                new Card("JS", 10),
                new Card("QS", 10),
                new Card("KS", 10),
                new Card("AH", 11),
                new Card("2H", 2),
                new Card("3H", 3),
                new Card("4H", 4),
                new Card("5H", 5),
                new Card("6H", 6),
                new Card("7H", 7),
                new Card("8H", 8),
                new Card("9H", 9),
                new Card("10H",10),
                new Card("JH", 10),
                new Card("QH", 10),
                new Card("KH", 10),
                new Card("AC", 11),
                new Card("2C", 2),
                new Card("3C", 3),
                new Card("4C", 4),
                new Card("5C", 5),
                new Card("6C", 6),
                new Card("7C", 7),
                new Card("8C", 8),
                new Card("9C", 9),
                new Card("10C",10),
                new Card("JC", 10),
                new Card("QC", 10),
                new Card("KC", 10),
                new Card("AD", 11),
                new Card("2D", 2),
                new Card("3D", 3),
                new Card("4D", 4),
                new Card("5D", 5),
                new Card("6D", 6),
                new Card("7D", 7),
                new Card("8D", 8),
                new Card("9D", 9),
                new Card("10D",10),
                new Card("JD", 10),
                new Card("QD", 10),
                new Card("KD", 10),};

            public Card draw(){
                while(true){
                    int t = rand.nextInt(52);
                    if(!deck[t].getStat()){
                        deck[t].setStat();
                        return deck[t];
                    }
                }
            }

            public void shuffle(){
                for(int i = 0; i < deck.length; i++){
                    if(deck[i].getStat()){
                        deck[i].setStat();
                    }
                }
            }
}
