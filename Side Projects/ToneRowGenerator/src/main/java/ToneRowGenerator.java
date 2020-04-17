import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ToneRowGenerator {

	// Sorts by ascending value and puts into new Map, sortedMap.
	// Must use sortedMap from here on out if you want it in order.
	// Remember to clear sortedMap before trying to add new values!
	static LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

	private static void sortAscending(Map<String, Integer> source) {
		source.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	}
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Determine if sharp or flat key. Re-prompts if invalid.
		boolean keySelect = false;
		boolean selectedSharpKey = false;
		SharpChromaticScaleC userSharpScale = new SharpChromaticScaleC();
		FlatChromaticScaleC userFlatScale = new FlatChromaticScaleC();
		while (!keySelect) {
			System.out.println("Please enter if this is Sharp(#) or Flat(b) key: ");
			String keyType = input.nextLine();
			if (keyType.equals("#")) {
				keySelect = true;
				selectedSharpKey = true;
				System.out.println("\nSharp Selected");
			} else if (keyType.equals("b")) {
				keySelect = true;
				System.out.println("\nFlat Selected");
			} else
				System.out.println("\n" + keyType + " is not a valid option.\n");
		}

		// Experiment to make random tone row
		/*
		 * boolean choiceCreateRandom = false; while (!choiceCreateRandom) {
		 * System.out.println("Create random row? (Y/N)"); String choiceRandomString =
		 * input.nextLine().toLowerCase();
		 * 
		 * if(choiceRandomString.equals("y") && selectedSharpKey) { // Creates a random
		 * sharp row Collections.shuffle(userSharpScale.getChromaticNotes());
		 * System.out.println(userSharpScale.getChromaticScale());
		 * System.out.println(userSharpScale.getChromaticValues()); }
		 * 
		 * }
		 */

		// Get user input for tone row. (WRITE SOMETHING TO CHECK IF VALID)
		boolean validRow = false;
//		while (!validRow) {
			System.out.println("\nPlease enter a tone row. Example of format: A, B, C, D, E, F, G, C#, D#, F#, G#, A#."
					+ "\nAssigns chromatic values based on the order of note names."
					+ "\nUnassigned notes will retain their original values!"
					+ "\nYou can use either note names (C-B) or chromatic values (0 - 11) where C = 0." + "\nRow: ");
			String row = input.nextLine();

			// Updates map values for Sharp Key based on user input
			if (row.contains("C") && selectedSharpKey) {
				String[] rowSplit = row.split(", ");
				int i = 0;
				for (String note : rowSplit) {
					userSharpScale.getChromaticScale().put(note, i);
					i++;
					if (note.contains("b")) {
						System.out.println(note + " is not valid and has been removed");
						userSharpScale.getChromaticScale().remove(note);
					}
				}
				System.out.println("Printing Matrix....\n");
				sortAscending(userSharpScale.getChromaticScale());
				userSharpScale.printNotesMatrix(sortedMap);
			}
			// Updates map values for Flat Key based on user input
			if (row.contains("C") && !selectedSharpKey) {
				String[] rowSplit = row.split(", ");
				int i = 0;
				for (String note : rowSplit) {
					userFlatScale.getChromaticScale().put(note, i);
					i++;
					if (note.contains("#")) {
						System.out.println(note + " is not valid and has been removed");
						userFlatScale.getChromaticScale().remove(note);
					}
				}
			}

			// Orders Sharp Scale map key by values entered by making new map
			// Creates and displays new map, newUserSharp
			if (row.contains("0") && selectedSharpKey) {
				String[] rowSplit = row.split(", ");
				int[] rowSplitInts = new int[12];
				for (int i = 0; i < rowSplit.length; i++) {
					rowSplitInts[i] = Integer.parseInt(rowSplit[i]);
//					System.out.println(rowSplitInts[i]);
				}

				Map<String, Integer> newUserSharp = new LinkedHashMap<String, Integer>();
				for (int i = 0; i < rowSplitInts.length; i++) {
					if (rowSplitInts[i] > 11 && rowSplitInts[i] < 0) {
						System.out.println("Numbers must be between 0 and 11");
					} else
						newUserSharp.put(userSharpScale.getChromaticNotes().get(rowSplitInts[i]), rowSplitInts[i]);
				}
				System.out.println("Tone Row created: " + newUserSharp);

			}

			// Orders Flat Scale map key by values entered by making new map
			// Creates and displays new map, newUserFlat
			if (row.contains("0") && !selectedSharpKey) {
				String[] rowSplit = row.split(", ");
				int[] rowSplitInts = new int[12];
				for (int i = 0; i < rowSplit.length; i++) {
					rowSplitInts[i] = Integer.parseInt(rowSplit[i]);
//					System.out.println(rowSplitInts[i]);
				}

				Map<String, Integer> newUserFlat = new LinkedHashMap<String, Integer>();
				for (int i = 0; i < rowSplitInts.length; i++) {
					if (rowSplitInts[i] > 11 && rowSplitInts[i] < 0) {
						System.out.println("Numbers must be between 0 and 11");
					} else
						newUserFlat.put(userSharpScale.getChromaticNotes().get(rowSplitInts[i]), rowSplitInts[i]);
				}
				System.out.println("Tone Row created: " + newUserFlat);

			}
//		} // end of while validRow
		
		
		
		
		

		input.close();
	}

}
