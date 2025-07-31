package pgdp.pingumath;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SAT {
	/*
	 * 'efficient' power implementation
	 * 
	 * This is part of the template, do not change this method!
	 */
	private static long pow(long a, int b) {
		if (b < 0) {
			System.out.println("Unexpected input: negative b is not allowed!");
			return 0;
		} else if (b == 0)
			return 1;

		int result = 1;
		while (b > 0) {
			if ((b & 1) == 0) {
				a *= a;
				b >>>= 1;
			} else {
				result *= a;
				b--;
			}
		}
		return result;
	}

	/*
	 * check if there exists x s.t. x^i == n (naive implementation)
	 */
	public static boolean isPow(int i, long n) {
		if (n> pow(10, 9)|| i>10) {
			return false;
		}
			else{
			long x=1;
				long answer =0;

				while(answer <n);{
					answer = pow(x,i);
					x=x+1;
					if (answer ==n)return true;
				}
			return false;
			}



	}

	/*
	 * calculate binomial coefficient
	 */
	private static long binom(long n, long k) {
		long nk=1;

		for (int i=0; i <= n; ++i){
			n=n*i;

		}
		for (int j=0; j<= k; ++k){
			k = k * j;
		}
		for (int l=0; l <= n-k; ++k) {
			nk = nk * k;}
		long binom= n/(k*nk);






			return -1;
	}

	/*
	 * check if n is central binomial coefficient
	 */
	public static boolean isCentralBin(long n) {

	;
		for (long i=0; i <= n; ++i){
		long	centralBinom =binom(2*i,i);
			if (centralBinom==n) return true;
		}



		return false;
	}

	/*
	 * check if n is part of Jacobsthal sequence
	 */
	public static long jacobsNum(long i){
		if(i==0)
			return 0;
		if(i==1)
			return 1;
		return 2* jacobsNum(i-2) + jacobsNum(i-1);
	}

	public static boolean isJacobsthal(long n) {
		for(long i=1; i<=n;i++){
			if (n== jacobsNum(i));
			return true;
		}
		return false;
	}

	/*
	 * given parameters for Lucas Sequence, check if n is part of this sequence
	 */
	public static boolean isLucasLikeSequence(long x0, long x1, int a, int b, long n) {
		return false;
	}

	/*
	 * this method returns a String of the analysis of the input n
	 * 
	 * This is part of the template, do not change this method!
	 */
	public static String checkSpecial(long n) {
		String result = "Input: \t\t" + n + "\n";

		String[] sequenceNames = { "Square", "Cubic", "Quartic", "Central Bin.", "Jacobsthal", "Fibonacci" };
		Boolean[] sequenceResults = { isPow(2, n), isPow(3, n), isPow(4, n), isCentralBin(n), isJacobsthal(n),
				isLucasLikeSequence(0, 1, 1, 1, n) };

		result += "Results: ";
		if (Arrays.stream(sequenceResults).anyMatch(x -> x)) {
			String analysis = IntStream.range(0, sequenceNames.length).mapToObj(i -> {
				return sequenceNames[i] + ": \t" + (sequenceNames[i].equals("Cubic") ? "\t" : "")
						+ (sequenceResults[i] ? "Yes" : "No") + "\n";
			}).reduce("", (a, b) -> a + b);
			result += "Interesting!\n" + analysis;
		} else
			result += "Nothing special about this ...\n";
		return result;
	}
}
