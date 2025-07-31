package pgdp.penguins;

import static pgdp.PinguLib.*;

public class Penguin {
	private int age;
	private String name;

	public Penguin(int age, String name){
		this.age = age;
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	public  String getName(){
		return name;
	}

	@Override
	public String toString(){
		return getName() + " ist "  + age+ " Jahre alt.";
	}

	public static void greetPenguin(Penguin penguin){
		if(penguin instanceof KingPenguin){
			write("Lebet lang und in Frieden, Eure Majestät!");
		}
		 else if(penguin instanceof RoyalPenguin){
			write("Welch Ehre euch zu treffen, Sir/Lady.");
		}
		 else if(penguin instanceof LittlePenguin){
			write("Servus!");
		}
		 else {
			 write("Wie spannend, eure Art kenne ich noch gar nicht.");
		}


	}


	public static void main(String[] args) {
		//		KingPenguin alfred = new KingPenguin(24, "Alfred", 69);
		//		RoyalPenguin lancelot = new RoyalPenguin(18, "Lancelot", "Rettete des Königs Neffen.");
		//		Penguin gimli = new LittlePenguin(255, "Gimli", 30);
		//		Penguin katharina = new Penguin(20, "Katharina");
		//		write(alfred.toString());
		//		greetPenguin(alfred);
		//		write(lancelot.toString());
		//		greetPenguin(lancelot);
		//		write(gimli.toString());
		//		greetPenguin(gimli);
		//		write(katharina.toString());
		//		greetPenguin(katharina);
	}
}
