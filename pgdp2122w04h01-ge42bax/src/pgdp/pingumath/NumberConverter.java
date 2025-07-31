package pgdp.pingumath;

public class NumberConverter {

	public static int intToPinguNum(int n) {
		String abc = " ";
		//String pingu = new String();

		if (n < 0) {
			System.out.println("N.D.");

		}
		String codeLetter="";

		while (n != 0) {
			int rem = n % 3;
			if (rem==0) {
				codeLetter = "in";
			}
			else if (rem==1){
				codeLetter = "gu";
			}
			else if (rem==2){
				codeLetter = "pin";
			}
			n=n/3;
			abc = codeLetter + abc;

		}
		String pinguNum = abc.substring(0, 1).toUpperCase() + abc.substring(1);




		return intToPinguNum(2);


	}














	public static int pinguNumToInt(String pinguNum) {
		return -1;
	}

	}




