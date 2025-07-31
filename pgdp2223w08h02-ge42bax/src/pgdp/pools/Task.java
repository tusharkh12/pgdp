package pgdp.pools;

import java.util.ArrayList;
import java.util.Objects;

public class Task<T, R> {
	private final T input;
	private R result;
	private final TaskFunction<T,R> taskFunction;
	//private
	private static int id;
	private final int ID;



	protected Task(T input, TaskFunction<T, R> taskFunction) {
		ID=id;
		this.input=input;
		this.taskFunction=taskFunction;
		id++;

	}

	public R getResult() {
		if(result==null) {
			result = taskFunction.apply(this.getInput());
			return result;
		}else {
			return result;
		}
	}

	@Override
	public int hashCode() {
//		int code=Objects.hashCode(ID);
//		// TODO
//		ID++;
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Task<?,?>){
			if(((Task<?, ?>) obj).getInput().equals(this.getInput()) && ((Task<?, ?>) obj).getTaskFunction().equals(this.getTaskFunction())){
				return true;
			}
		}
		return false;
	}

	public T getInput() {
		return input;
	}

	public TaskFunction<T, R> getTaskFunction() {
		return taskFunction;
	}
//	public ArrayList<Task<T,R>> listOfTasks(){
//		ArrayList<Task<T,R>> lists=new ArrayList<>();
//		lists.add(ID,this);
//		ID++;
//		return lists;
//	}

	public static void main(String[] args) {
		TaskFunction<Integer, Integer> f1 = new TaskFunction<>(FunctionLib.INC);
		TaskFunction<Integer, Integer> f2 = new TaskFunction<>(FunctionLib.INC);
		Task<Integer, Integer> t1 = new Task<>(1, f1);
		Task<Integer, Integer> t2 = new Task<>(1, f1);
		Task<Integer, Integer> t3 = new Task<>(1, f2);

		System.out.println(t1.equals(t2)); // true
		System.out.println(t1.equals(t3)); // false

		System.out.println(t1.getResult()); // 2
	}
}
