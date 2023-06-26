package main;

import algorithms.MergeSort;
import appsInterface.AppsFrame;
import algorithms.BubbleSort;
import algorithms.QuickSort;
import algorithms.Sort;
import model.Algoritam;
import model.SortModel;
import parallel.ParallelMergeSort;
import parallel.ParallelQuickSort;

public class Main {
	public static void main(String[] args) {
	
		long startTime;
		long endTime;
		
		Integer[] niz={3,7,0,2,44,-23,8,1,14,2,-8,9,5,6,4,3,1};
		AppsFrame frame = new AppsFrame();
		
		SortModel sortModel = new SortModel();
		BubbleSort bubbleSort = new BubbleSort();
		
		System.out.println(sortModel.demonstrirajSortiranje(Algoritam.MERGE, true, 10000, false));
		System.out.println(sortModel.demonstrirajSortiranje(Algoritam.BUBBLE, true, 10000, true));
		System.out.println(sortModel.demonstrirajSortiranje(Algoritam.QUICK, true, 10000, false));
		System.out.println(sortModel.demonstrirajSortiranje(Algoritam.INSERTION, true, 10000, true));
		
		System.out.println("\nBUBBLE SORT\nNiz prije sortiranja:"+prikaz(niz));
		bubbleSort.sort(niz, 0, niz.length-1);
		System.out.println("Niz nakon sortiranja:" + prikaz(niz));
	}
	public static void ispis(int[] niz) {
		int i;
		System.out.print("\nNiz: ");
		for(i=0;i<niz.length;i++)
			System.out.print(niz[i] + " ");	 
	}
	
	public static <T extends Comparable<T>> String prikaz (T[] niz)
	{
		String stringNiz = "";
		
		stringNiz+= "Niz: ";
		for(int i=0;i<niz.length;i++)
			stringNiz += niz[i] + " ";	
		
		return stringNiz;
	}
}
