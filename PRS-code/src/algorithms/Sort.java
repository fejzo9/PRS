package algorithms;

public interface Sort {

	<T extends Comparable<T>> void sort(T[] niz, int lijevi, int desni);
}