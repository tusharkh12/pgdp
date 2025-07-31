package pgdp.saleuine2;

import java.math.BigDecimal;

public class TradeOrder {

    private BigDecimal totalCost;
    private int currentWeight;


    public TradeOrder() {
        this.totalCost = BigDecimal.ZERO;
        this.currentWeight = 0;


    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }



    public boolean supplyOrder(PinguFood supply, BigDecimal cost) {
        if(isOrderFulfilled() || !supply.isEdible()) {
            return false;
        }
        currentWeight = currentWeight + supply.getWeight();
        totalCost= totalCost.add(cost);
        return true;
    }


    public String orderType() {
        if (this instanceof WeightOrder) {

            return "Zielgewicht: " + ((WeightOrder) this).getTargetWeight() + "g";   //how
        } else if (this instanceof AmountOrder) {
            return "Anzahl: [" + ((AmountOrder) this).getTargetAmountAnchovies() + "," +
                    ((AmountOrder) this).getTargetAmountCrustaceans() + "," + ((AmountOrder) this).getTargetAmountSardines() + "]";
        } else {
            return "Einzeln";
        }
    }


    public String toString() {
        if (this instanceof WeightOrder) {
            return "Die Bestellung(Zielgewicht: " + ((WeightOrder) this).getTargetWeight() + "g) hat ein Gesamtgewicht von " +
                    currentWeight + "g und kostet <totalCost>PD.";
        } else if (this instanceof AmountOrder) {
            return "Die Bestellung(Anzahl: [" + ((AmountOrder) this).getTargetAmountAnchovies() + "," +
                    ((AmountOrder) this).getTargetAmountCrustaceans() + "," + ((AmountOrder) this).getTargetAmountSardines() +
                    "]) hat ein Gesamtgewicht von " + currentWeight + "g und kostet " + totalCost + "PD.";

        } else {
            return "Die Bestellung(Einzeln) hat ein Gesamtgewicht von " + currentWeight + "g und kostet " + totalCost + "PD.";

        }


    }


    public boolean isOrderFulfilled() {
        if (this instanceof WeightOrder) {
            if (((WeightOrder) this).getTargetWeight() <= currentWeight) {
                return true;
            }
        }

        else if (this instanceof AmountOrder) {
            if (((AmountOrder) this).getTargetAmountAnchovies() <= ((AmountOrder) this).getCurrentAmountAnchovies() &&
                    ((AmountOrder) this).getTargetAmountCrustaceans() <= ((AmountOrder) this).getCurrentAmountCrustaceans() &&
                    ((AmountOrder) this).getTargetAmountSardines() <= ((AmountOrder) this).getCurrentAmountSardines()) {
                return true;

            }
        }


        else if (this.getTotalCost().doubleValue()>0.0){
            return true;
        }
        return false;

}



}
