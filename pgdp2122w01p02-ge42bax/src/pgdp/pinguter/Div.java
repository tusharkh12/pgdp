package pgdp.pinguter;

import static pgdp.PinguLib.*;

public class Div {
	public static void main(String[] args) {
		write("Division");
		int num1 = readInt("Geben Sie num1 bitte an : ");
		int num2 = readInt("Geben Sie num2 bitte an : ");
		int ergebnis = num1/num2 ;
		write("Das Ergbenis von Division von " + num1 + " und " + num2 + " ist :" + ergebnis );
		
	}
}
