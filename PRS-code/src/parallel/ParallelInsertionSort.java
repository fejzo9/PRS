package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import algorithms.MergeSort;

public class ParallelInsertionSort extends ParallelSort{
	
	@Override
	public <T extends Comparable<T>> void sort(T[] niz, int lijevi, int desni) {
        SortTask<?> task = new SortTask<T>(niz, lijevi, desni);
        pool = new ForkJoinPool();
        pool.invoke(task);
    }
    
    public static class SortTask <T extends Comparable<T>> extends RecursiveAction {
    	
    	private static final int GRANICA = 300;
		private T[] niz;
		private int lijevi;
		private int desni;

		public SortTask(T[] niz, int lijevi, int desni) {
			super();
			this.niz = niz;
			this.lijevi = lijevi;
			this.desni = desni;
		}

		@Override
		protected void compute() {
			if(desni - lijevi <= GRANICA) {

				//Sortiranje podniza insertion sortom
				 for (int i = lijevi + 1; i < desni + 1; i++) {
					 
					 int j = i;
					 
					 while(j > lijevi && niz[j - 1].compareTo(niz[j]) > 0) {
		            	   T pom = niz[j - 1];
		            	   niz[j - 1] = niz[j];
		            	   niz[j] = pom;
		            	   j--;
		               }
					}
			} 
			else {
				//Podjela zadatka na podzadatke
				int srednji = lijevi + (desni - lijevi) / 2;
				
				SortTask<?> prvaPolovina = new SortTask<T>(niz, lijevi, srednji);
				SortTask<?> drugaPolovina = new SortTask<T>(niz, srednji + 1, desni);
				
				invokeAll(prvaPolovina, drugaPolovina);
				//Spajanje sortiranih nizova
				MergeSort.merge(niz, lijevi, srednji, desni);
			}
			
		}
    }
    
    @Override
    public String toString() {
    	return getClass().getSimpleName();
    }

}
