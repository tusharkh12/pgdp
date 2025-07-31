package pgdp.saleuine;

import static pgdp.PinguLib.*;

public class Market {
	private int daysInBusiness;
	private int soldCrustaceansDay;
	private int soldAnchoviesDay;

	private int soldSardinesDay;
	private double moneyMadeDay;
	private double moneyMadeTotal;

	private double priceCrustaceans;
	private double priceAnchovies;
	private double priceSardines;

	public Market(double priceCrustaceans, double priceAnchovies, double priceSardines) {
		this.priceCrustaceans = priceCrustaceans;
		this.priceAnchovies = priceAnchovies;

		this.priceSardines = priceSardines;
		this.soldCrustaceansDay = 0;
		this.soldSardinesDay = 0;
		this.soldAnchoviesDay = 0;

		this.moneyMadeDay = 0;
		this.moneyMadeTotal = 0;
		this.daysInBusiness = 1;
	}

	public void serveCustomer(Kaufuin kaufuin) {

		write("Neue Bestellung wird angenommen: " + kaufuin.getName() + "(" + kaufuin.getAge() + ") hätte gerne "+ kaufuin.getOrder().getAmountCrustaceans() + " Krustentiere, "+ kaufuin.getOrder().getAmountAnchovies() + " Sardellen und " + kaufuin.getOrder().getAmountSardines()+ " Sardinen.");
		double cost = kaufuin.getOrder().getAmountAnchovies() * priceAnchovies+ kaufuin.getOrder().getAmountCrustaceans() * priceCrustaceans+ kaufuin.getOrder().getAmountSardines() * priceSardines;

		soldAnchoviesDay =soldAnchoviesDay+ kaufuin.getOrder().getAmountAnchovies();
		soldSardinesDay =soldSardinesDay+ kaufuin.getOrder().getAmountSardines();
		soldCrustaceansDay =soldCrustaceansDay+ kaufuin.getOrder().getAmountCrustaceans();

		write("Die Bestellung kostet " + cost + "PD.");
		write(kaufuin.pay(cost));
		moneyMadeDay =moneyMadeDay+ cost;
		writeLineConsole();
	}

	public void endDay() {

		moneyMadeTotal = moneyMadeTotal + moneyMadeDay;
		write("Der Laden der Saleuine Claudia und Karl-Heinz hat am " + daysInBusiness + ". Tag " + moneyMadeDay + "PD eingenommen." + "\nDafür wurden " + soldCrustaceansDay + " Krustentiere, " + soldAnchoviesDay + " Sardellen und " + soldSardinesDay + " Sardinen verkauft." + "\nInsgesamt hat der Laden " + moneyMadeTotal + "PD eingenommen.");
		daysInBusiness = daysInBusiness + 1;

		soldAnchoviesDay = 0;
		soldCrustaceansDay = 0;
		soldSardinesDay = 0;

		priceAnchovies = priceAnchovies / 2;
		priceCrustaceans = priceCrustaceans / 2;

		priceSardines = priceSardines / 2;
		moneyMadeDay = 0;

		writeLineConsole();

	}
	public static void main(String[] args) {
		Market market = new Market(1.99, 9.99, 100);

		Order jessiesOrder = new Order(5, 6, 7);
		Kaufuin jessie = new Kaufuin("Jessie", 19, 1337, jessiesOrder);

		market.serveCustomer(jessie);
		System.out.println(jessie);
		market.endDay();
	}
}
