package algorithms;

public class BubbleSort implements Sort{
	@Override
	public <T extends Comparable<T>> void sort(T[] niz, int lijevi, int desni) {
		 for (int i = lijevi + 1; i < desni + 1; i++) {
             for (int j = lijevi; j < desni; j++) {
             	
                 if (niz[j].compareTo(niz[j+1]) > 0) {
                	 T temp = niz[j];
            		 niz[j] = niz[j + 1];
            		 niz[j + 1] = temp;
                 }
             }
		}		  
	}
	
	@Override
	public String toString() {
		return "Sekvencijalni " + getClass().getSimpleName();
	}
}

