package pgdp.saleuine2;

//  import java.math.BigDecimal;

public class AmountOrder extends TradeOrder {
    private final int targetAmountAnchovies;
    private final int targetAmountCrustaceans;
    private final int targetAmountSardines;
    private int currentAmountAnchovies;
    private int currentAmountCrustaceans;
    private int currentAmountSardines;


    public AmountOrder(int targetAmountAnchovies,
                       int targetAmountCrustaceans, int targetAmountSardines) {

        super();
        this.targetAmountAnchovies = targetAmountAnchovies;
        this.targetAmountCrustaceans = targetAmountCrustaceans;
        this.targetAmountSardines = targetAmountSardines;
        this.currentAmountAnchovies = 0;
        this.currentAmountCrustaceans = 0;
        this.currentAmountSardines = 0;
    }


    public int getTargetAmountAnchovies() {
        return targetAmountAnchovies;
    }


    public int getTargetAmountCrustaceans() {
        return targetAmountCrustaceans;
    }

    public int getTargetAmountSardines() {
        return targetAmountSardines;
    }

    public int getCurrentAmountAnchovies() {
        return currentAmountAnchovies;
    }

    public int getCurrentAmountCrustaceans() {
        return currentAmountCrustaceans;
    }

    public int getCurrentAmountSardines() {
        return currentAmountSardines;
    }




//    public void setTargetAmountAnchovies(int targetAmountAnchovies) {
//        this.targetAmountAnchovies = targetAmountAnchovies;
//    }
//    public void setTargetAmountCrustaceans(int targetAmountCrustaceans) {
//        this.targetAmountCrustaceans = targetAmountCrustaceans;
//    }

}
