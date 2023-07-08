package main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import appsInterface.AppsFrame;
import model.Algoritam;
import model.SortModel;

public class Main {
	public static void main(String[] args) {
		new AppsFrame();
	}

	public static void ispis(int[] niz) {
		int i;
		System.out.print("\nNiz: ");
		for (i = 0; i < niz.length; i++)
			System.out.print(niz[i] + " ");
	}

	public static <T extends Comparable<T>> String prikaz(T[] niz) {
		String stringNiz = "";

		stringNiz += "Niz: ";
		for (int i = 0; i < niz.length; i++)
			stringNiz += niz[i] + " ";

		return stringNiz;
	}
	
	private static void testiranjeManuelno() {
		SortModel sortModel = new SortModel();
		try {
			File f1 = new File("file1.txt");
			if (!f1.exists()) {
				f1.createNewFile();
			}
			FileWriter writer = new FileWriter(f1, true);
			BufferedWriter buffWriter = new BufferedWriter(writer);
			buffWriter.write(sortModel.demonstrirajSortiranje(Algoritam.SELECTION, true, 1000000, false) + "\n");
			buffWriter.close();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
