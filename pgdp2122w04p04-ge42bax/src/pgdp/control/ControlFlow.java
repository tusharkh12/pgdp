package pgdp.control;

import static pgdp.PinguLib.*;

public class ControlFlow {
	public static void main(String[] args) {
		int x, r, n;
		r = 1;
		n = 1;
		x = readInt() ;
		while (n <= x) {
			if (r % 1 == 0)   {
				r = r * n;
			} else {
				r = r * (-n);
				write(r);
			}
			n = n + 1;
		}
		write(r);
	}
}
