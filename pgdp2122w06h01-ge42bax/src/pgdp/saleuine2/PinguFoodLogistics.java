package pgdp.saleuine2;

import static pgdp.PinguLib.*;

import java.math.BigDecimal;

public class PinguFoodLogistics {
	 private TradeOrderQueue orderBook = new TradeOrderQueue();
	 private BigDecimal ppgAnchovies;
	 private BigDecimal ppgCrustaceans;
     private BigDecimal ppgSardines;
	 private static BigDecimal foodWorth = BigDecimal.ZERO;
	 private static int foodLeft =0;
	 private static int  remainingWeight = 0;


	public PinguFoodLogistics(BigDecimal ppgAnchovies,
							  BigDecimal ppgCrustaceans,BigDecimal ppgSardines) {
		//this.orderBook = new TradeOrderQueue();
		this.ppgAnchovies=ppgAnchovies;
		this.ppgCrustaceans=ppgCrustaceans;
		this.ppgSardines=ppgSardines;
		//orderBook = null;
	}

	public void acceptNewOrder(TradeOrder order){
		if(order!=null){
			orderBook.add(order);
		}
	}


	private void registerUnusedFood(PinguFood food) {
		if (food instanceof Anchovie) {
			foodLeft = foodLeft++;
			remainingWeight = remainingWeight + food.getWeight();
			foodWorth = foodWorth.add(ppgAnchovies.multiply(BigDecimal.valueOf(food.getWeight())));
			//System.out.println(foodWorth.toString());
		} else if (food instanceof Crustacean) {
			foodLeft = foodLeft++;
			remainingWeight = remainingWeight + food.getWeight();
			foodWorth = foodWorth.add(ppgCrustaceans.multiply(BigDecimal.valueOf(food.getWeight())));

		} else if (food instanceof Sardine) {
			foodLeft = foodLeft++;
			remainingWeight = remainingWeight + food.getWeight();
			foodWorth = foodWorth.add(ppgSardines.multiply(BigDecimal.valueOf(food.getWeight())));

		}
	}

	public void printWasteStatistics(){
		writeLineConsole("Bisher konnten "+foodLeft+" Tiere mit einem Gesamtgewicht von "+remainingWeight+"g nicht verwertet werden." +
				"\nClaudia und Karl-Heinz ist dadurch ein Profit von "+foodWorth+"PD entgangen.");

	}
	public void clearOrderBook() {


		if(orderBook!=null){
			writeLineConsole("Es können " + orderBook.size() + " Bestellungen abgearbeitet werden.");
		TradeOrder t = orderBook.poll();
		PinguFood p = generatePinguFood();
//		Sardine a = generateAnchovie();


		if (!(t.supplyOrder(p, t.getTotalCost())))  {

			registerUnusedFood(p);
			t.toString();
		}

		else if (t instanceof AmountOrder) {
			if (p instanceof Anchovie) {

				Anchovie a = (Anchovie) p;
				while (t.supplyOrder(p, t.getTotalCost())) {
					t.supplyOrder(a, ppgAnchovies.multiply(BigDecimal.valueOf(a.getWeight())));
				}

			} else if (p instanceof Crustacean) {

				Crustacean c = (Crustacean) p;
				while (t.supplyOrder(p, t.getTotalCost())) {
					t.supplyOrder(c, ppgCrustaceans.multiply(BigDecimal.valueOf(c.getWeight())));
				}
			} else if (p instanceof Sardine) {
				Sardine s = (Sardine) p;
				while (t.supplyOrder(p, t.getTotalCost())) {
					t.supplyOrder(s, ppgSardines.multiply(BigDecimal.valueOf(s.getWeight())));
				}
			}

			t.toString();


		} else if (t instanceof WeightOrder) {

			//if (((WeightOrder) t).getTargetWeight() > t.getCurrentWeight()){
				for (int i = 0; i <= ((WeightOrder) t).getTargetWeight(); i = i + t.getCurrentWeight()){
					if (p instanceof Anchovie){

						Anchovie a = (Anchovie) p;
						t.supplyOrder(a, ppgAnchovies.multiply(BigDecimal.valueOf(a.getWeight())));


					} else if (p instanceof Crustacean) {

						Crustacean c = (Crustacean) p;
						t.supplyOrder(c, ppgCrustaceans.multiply(BigDecimal.valueOf(c.getWeight())));

					} else if (p instanceof Sardine) {
						Sardine s = (Sardine) p;
						t.supplyOrder(s, ppgSardines.multiply(BigDecimal.valueOf(s.getWeight())));


						//if this is false, then food is unused.
					}
					t.toString();
				}
			}
		//}
		}
	}


	public BigDecimal getPpgAnchovies() {
		return ppgAnchovies;
	}

	public BigDecimal getPpgCrustaceans() {
		return ppgCrustaceans;
	}

	public BigDecimal getPpgSardines() {
		return ppgSardines;
	}
//
//	public static void main(String[] args) {
//		PinguFoodLogistics p = new PinguFoodLogistics(new BigDecimal(2), new BigDecimal(2), new BigDecimal(2));
//		p.registerUnusedFood(new Anchovie(1, 30));
//		System.out.println();
//				PinguFoodLogistics market = new PinguFoodLogistics(BigDecimal.ONE, BigDecimal.valueOf(0.5),
//						BigDecimal.valueOf(2));
//				market.acceptNewOrder(new TradeOrder());
//				market.acceptNewOrder(new WeightOrder(1000));
//				market.acceptNewOrder(new AmountOrder(2, 2, 2));
//				market.clearOrderBook();
//				market.printWasteStatistics();
//	}


	/**
	 * The following methods generate Anchovie, Crustacean or Sardine object
	 * WARNING: do NOT change these methods unless you want to fail the tests
	 */


	public static PinguFood generatePinguFood(){
		switch (randomInt(0, 2)) {
		case 0:
			return generateAnchovie();
		case 1:
			return generateCrustacean();
		case 2:
			return generateSardine();
		default:
			throw new SecurityException("You changed the code!");
		}
	}
	
	public static Anchovie generateAnchovie() {
		return new Anchovie(randomInt(0, 5), randomInt(1, 55));
	}
	
	public static Crustacean generateCrustacean() {
		return new Crustacean(randomInt(1, 10));
	}
	
	public static Sardine generateSardine() {
		return new Sardine(randomInt(0, 10), randomInt(20, 300), randomInt(1, 22));
	}

}
