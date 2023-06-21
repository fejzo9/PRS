package algorithms;

public class InsertionSort implements Sort{
	@Override
	public <T extends Comparable<T>> void sort(T[] niz, int lijevi, int desni) {
		
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
	
	@Override
	public String toString() {
		return "Sekvencijalni " + getClass().getSimpleName();
	}
}
