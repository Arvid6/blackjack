public class Card {
    private String card;
    private int value;
    private boolean used = false;
    public Card(String card, int value){
        this.card = card;
        this.value = value;
    }

    public String getCard(){
        return card;
    }

    public int getValue(){
        return value;
    }

    public boolean getStat(){
        return used;
    }

    public void setStat(){
        used = !used;
    }
}
