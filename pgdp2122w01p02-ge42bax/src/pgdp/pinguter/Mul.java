package pgdp.pinguter;

import static pgdp.PinguLib.*;

public class Mul {
	public static void main(String[] args) {
		write("Multiplikation");
		int num1 = readInt("Geben Sie num1 bitte an : ");
		int num2 = readInt("Geben Sie num2 bitte an : ");
		int ergebnis = num1*num2 ;
		write("Das Ergbenis von Multiplikation von " + num1 + " und " + num2 + " ist :" + ergebnis );




	}
}
