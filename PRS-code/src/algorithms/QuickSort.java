package algorithms;

public class QuickSort implements Sort {
	
	@Override
	public <T extends Comparable<T>> void sort(T[] niz, int lijevi, int desni) {
	        if (lijevi < desni) {
	            int pivotIndex = partition(niz, lijevi, desni);
	            sort(niz, lijevi, pivotIndex - 1);
	            sort(niz, pivotIndex + 1, desni);
	        }
	    }
	 
	 public static <T extends Comparable<T>> int partition(T[] niz, int lijevi, int desni) {
	        T pivot = niz[desni];
	        int i = lijevi - 1;
	        for (int j = lijevi; j < desni; j++) {
	            if (niz[j].compareTo(pivot) < 0) {
	                i++;
	                T temp = niz[i];
	                niz[i] = niz[j];
	                niz[j] = temp;
	            }
	        }
	        T temp = niz[i + 1];
	        niz[i + 1] = niz[desni];
	        niz[desni] = temp;
	        return i + 1;
	    }
	 
		@Override
		public String toString() {
			return "Sekvencijalni " + getClass().getSimpleName();
		}
}
