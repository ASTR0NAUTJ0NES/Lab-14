
/***********************
 *
 *   TreasureChest - class representing a Treasure chest full of Treasures
 *
 *   Author:   Shawn Brenneman
 *   Date:     2016-Oct
 *
 ***********************/
import java.util.Scanner;
import java.io.*;

public class TreasureChest {

	private Treasure[] chest;
	private int count;

	/**
	 * The file designated by filepath must have the following format: The first
	 * line contains one integer that designates the number of treasures in the
	 * file. Each subsequent line contains a text representation of a single
	 * treasure, referred to as treasureData in the Treasure class description.
	 * @see Treasure
	 */
	public TreasureChest(String filepath) throws InvalidTreasureException {

        int fileLineNumber = 1;
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new File(filepath));
		} catch (FileNotFoundException fnfExc) {
			System.err.println("ERROR: TreasureChest file not found: " + filepath);
			return;
		}
		String firstLine = fileScan.nextLine();

		// System.out.println("firstLine: <" + firstLine + ">");
		Scanner numScan = new Scanner(firstLine);
		int treasureCount = numScan.nextInt();
		chest = new Treasure[treasureCount];

		count = 0;
		while (fileScan.hasNext()) {
            fileLineNumber++;
			this.addTreasure(new Treasure(fileScan.nextLine()));
		}
	}

	public TreasureChest(int capacity) {
		chest = new Treasure[capacity];
		count = 0;
	}

	public int addTreasure(Treasure treasure) {
		// System.out.println("count: " + count + " capacity: " +
		// this.getCapacity());
		chest[count] = treasure;
		count++;
		return count;
	}

	public int getCapacity() {
		return chest.length;
	}

	public int getCount() {
		return count;
	}

	public double getTotalTreasureWeight() {
		double sum = 0.0;
		for (Treasure treasure : chest) {
			sum += treasure.getWeight();
		}
		return sum;
	}

	public String toString() {
		String str = "";
		for (Treasure treasure : chest) {
			str += treasure + "\n";
		}
		return str;
	}

}
