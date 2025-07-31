package pgdp.saleuine2;

// import java.math.BigDecimal;

public class WeightOrder extends TradeOrder{

    private final int targetWeight;


    public WeightOrder(int targetWeight){
        super();
        this.targetWeight = targetWeight;
    }

    public int getTargetWeight(){
        return targetWeight;
    }


}
