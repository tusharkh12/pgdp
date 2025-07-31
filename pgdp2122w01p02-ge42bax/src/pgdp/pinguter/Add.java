package pgdp.pinguter;

import static pgdp.PinguLib.*;

public class Add {
	public static void main(String[] args) {
		write("Starte Addition:");
		int arg1 = readInt("Bitte erstes Argument eingeben: ");
		int arg2 = readInt("Bitte zweites Argument eingeben: ");
		int sum = arg1 + arg2;
		write("Das Ergebnis ist: ");
		write(sum);
		write("Beende Addition");
	}
}
