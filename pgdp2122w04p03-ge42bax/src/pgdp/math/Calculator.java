package pgdp.math;

import static pgdp.PinguLib.*;

public class Calculator {

	public static void main(String[] args) {
		int option = -1;
		int op1;
		int op2;

		while (option != 6) {
			option = readInt("Wählen Sie eine Operation:\n1) +\n2) -\n3) *\n4) /\n5) %\n6) Programm beenden");

			if (option >= 1 && option <= 5) {
				op1 = readInt("Ersten Operanden eingeben:");
				op2 = readInt("Zweiten Operanden eingeben:");

				switch (option) {
					case 1:
						write(op1 + op2);
						break;
					case 2:
						write(op1 - op2);
						break;
					case 3:
						write(op1 * op2);
						break;
					default:
						if (op2 == 0) {
							write("Fehler: Division durch 0!");
						} else {
							if (option == 4) {
								write(op1 / op2);
							} else {
								write(op1 % op2);
							}
						}
						break;
				}
			}
		}
	}

}