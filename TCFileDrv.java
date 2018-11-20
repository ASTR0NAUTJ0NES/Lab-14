/***********************
 *
 *   TCDriver - driver which creates a TreasureChest and fills it with
 *              treasures read from a file - the filename is a 
 *              command line argument.
 *
 *   Author:   Shawn Brenneman
 *   Date:     2016-Oct
 *
 ***********************/
import java.io.*;

public class TCFileDrv {

	public static void main(String[] args) throws FileNotFoundException, InvalidTreasureException {

		if (args.length == 0) {
			System.out.println("usage: java TCFileDrv filename");
			return;
		}

		TreasureChest tChest = new TreasureChest(args[0]);

		System.out.println(tChest);

	} // main

}
