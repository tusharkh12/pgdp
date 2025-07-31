package pgdp.pools;

import java.util.HashMap;

public class TaskPool<T, R> {
	HashMap<Integer, Task<T, R>> tasks=new HashMap<Integer, Task<T, R>>();
	private static int ID;

	protected TaskPool() {

		// TODO ?
	}

	public Task<T, R> insert(Task<T, R> task) {
		if(tasks.size()==0){
			tasks.put(ID,task);
			ID++;
			return task;
		}
		for (Task<T,R> a:tasks.values()) {
			if(a.equals(task)){
				return a;
			}
		}
		tasks.put(ID,task);
		ID++;

		return task;
	}

	public Task<T, R> getByValue(T input, TaskFunction<T, R> function) {
		for (Task<T,R> a:tasks.values()) {
			if(a.getInput().equals(input) && a.getTaskFunction().equals(function)){
				return a;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TaskFunction<Integer, Integer> f = new TaskFunction<>(FunctionLib.SQUARE);
		TaskPool<Integer, Integer> tp = new TaskPool<>();

		System.out.println(tp.getByValue(1, f)); // null

		Task<Integer, Integer> t1 = new Task<>(1, f);
		Task<Integer, Integer> t2 = new Task<>(1, f);
		System.out.println(t1 == tp.insert(t1)); // true
		System.out.println(t1 == tp.insert(t2)); // true
		System.out.println(t1 == tp.getByValue(1, f)); // true
		//System.out.println(ID);
	}
}
