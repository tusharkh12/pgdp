package pgdp.pools;

import java.util.Objects;
import java.util.function.Function;

public class TaskFunction<T, R> {
	private final int ID;
	private final Function<T,R> function;
	private static int id=0;

	public TaskFunction(Function<T, R> function) {
		//int ID1;
		// TODO
		ID =id;
		this.function=function;
		id++;


	}

	public R apply(T input) {
		R result=function.apply(input);
		//ID++;

		return result;
	}

	@Override
	public int hashCode() {
		//int a=Objects.hashCode(ID);
		return ID;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TaskFunction<?,?>) {
			if (this.hashCode() == obj.hashCode()) {
				return true;
			}
		}

			return false;
	}

	public static void main(String[] args) {
		TaskFunction<Integer, Integer> f1 = new TaskFunction<>(FunctionLib.SQUARE);
		TaskFunction<Integer, Integer> f2 = new TaskFunction<>(FunctionLib.SUM_OF_HALFS);
		TaskFunction<Integer, Integer> f3 = new TaskFunction<>(FunctionLib.SQUARE);
		System.out.println(f3.hashCode());
		System.out.println(f1.equals(f2)); // false
		System.out.println(f1.equals(f3)); // false
		System.out.println(f1.equals(f1)); // true
		System.out.println(f1.apply(2)); // 4
	}
}
