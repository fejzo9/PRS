package parallel;

import java.util.concurrent.ForkJoinPool;

import algorithms.Sort;

public abstract class ParallelSort implements Sort{
	
	protected ForkJoinPool pool;
	
	public String podaciOParalelizaciji() {
		return "Nivo paralelizma je: " + pool.getParallelism() +
				"\nBroj ukradenih taskova je: " + pool.getStealCount();
	}
}
