package pgdp.math;

import static pgdp.PinguLib.*;

public class Collatz {

	public static void main(String[] args) {
	    // TODO: solve the exercise
		int i=1;
		int num = readInt("Bitte Zahl eingeben:");
		if(num<=0){
			System.out.println("Fehler: n>0 erwartet!");

		}



		else {
			System.out.print(num);
			do {


			if (num%2 == 0){
				num = num/2;
				System.out.print(" " + num);
				i++;


			}
			else {
				num=3*num +1;
				System.out.print(" " + num);
				i++;
			}

		}
		while (num!=1);
			System.out.println("\nLänge: " + i);



		}



	}
}
