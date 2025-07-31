package pgdp.math;

import static pgdp.PinguLib.*;

public class ThreeAndSeven {
	public static void main(String[] args) {
		int n = readInt("Bitte Zahl eingeben:");

		if (n < 0) {
			write("Fehler: n>=0 erwartet!");
		} else {
			int sum = 0;

			while (n > 2) {
				if (n % 3 == 0 || n % 7 == 0) {
					sum += n;
				}
				n--;
			}
			write(sum);
		}
	}
}