package pgdp.saleuine;

public class Order {

    private int amountAnchovies;

    private int amountSardines;

    private int amountCrustaceans;


    public Order( int amountAnchovies,int amountCrustaceans,  int amountSardines) {
        this.amountAnchovies = amountAnchovies;

        this.amountCrustaceans = amountCrustaceans;

        this.amountSardines = amountSardines;
    }

    public int getAmountAnchovies() {
        return amountAnchovies;
    }

    public int getAmountCrustaceans() {
        return amountCrustaceans;
    }


    public int getAmountSardines() {
        return amountSardines;
    }

    public void setAmountSardines(int amount) {
        amountSardines = amount;
    }

    public void setAmountCrustaceans(int amount) {
        amountCrustaceans = amount;
    }

    public void setAmountAnchovies(int amount) {
        amountAnchovies = amount;
    }



    public String toString() {
        return amountCrustaceans + " Krustentiere, " + amountAnchovies + "Sardellen und " + amountSardines+ " Sardinen";
    }

    public void addOrder(Order addorder) {

        amountSardines =amountSardines+ addorder.amountSardines;

        amountAnchovies =amountAnchovies+ addorder.amountAnchovies;

        amountCrustaceans =amountCrustaceans+ addorder.amountCrustaceans;

        System.out.println("Danke Schoen :)");
    }



}
