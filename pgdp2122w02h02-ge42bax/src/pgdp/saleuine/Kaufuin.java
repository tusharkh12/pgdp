package pgdp.saleuine;

import java.sql.SQLOutput;

import static pgdp.PinguLib.*;

public class Kaufuin {

    private String name;
    private int age;
    private double money;
    private Order order;

    public Kaufuin(String name, int age, double money, int amountCrustaceans, int amountAnchovies, int amountSardines) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.order = new Order(amountCrustaceans, amountAnchovies, amountSardines);

    }

    public Kaufuin(String name, int age, double money, Order object) {
        this.name = name;
        this.age = age;
        this.money = money;
        this.order = object;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }

    public Order getOrder() {
        return order;
    }

    public void giveNewOrder(Order givenewOrder) {
        order.setAmountSardines(givenewOrder.getAmountSardines());
        order.setAmountCrustaceans(givenewOrder.getAmountCrustaceans());
        order.setAmountAnchovies(givenewOrder.getAmountAnchovies());
    }

    public void addToOrder(Order addtoorders) {
        order.addOrder(addtoorders);
    }

    public String giveInformation() {
        return name + "(" + age + ")" + " hätte gerne " + order.getAmountCrustaceans() + " Krustentiere, "
                + order.getAmountAnchovies() + " Sardellen und " + order.getAmountSardines() + " Sardinen.";
    }

    public String pay(double cost) {
        money =money- cost;
        return name + " zahlt " + cost + " und hat noch " + money + "PD übrig.";
    }


    public static void main(String[] args) {
        Market market = new Market(1.99, 9.99, 100);

        Order messOrder = new Order(5, 6, 7);
        Kaufuin mess = new Kaufuin("Mess", 25, 1337, messOrder);
        System.out.println(messOrder);

        market.serveCustomer(mess);
        market.endDay();
    }

}