import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.omg.CORBA.portable.ValueBase;

public class Testing {

	// Sort logic
	// Updates entries so that key at pivot = 0.
	// Adds 12 to key values that are less than entry at pivot.
	public static void pivotTranspose(Map<String, Integer> source, int pivot) {
		List<Entry<String, Integer>> list = source.entrySet().stream().map(entry -> {
			return updateEntry(source, pivot, entry);
		}).sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
	}

	private static Entry<String, Integer> updateEntry(Map<String, Integer> source, int pivot,
			Entry<String, Integer> entry) {
		if (entry.getValue() < pivot) {
			entry.setValue(entry.getValue() + source.size());
		}
		entry.setValue(entry.getValue() - pivot);
		return entry;
	}

	// Sorts by ascending value and puts into new Map, sortedMap.
	// Must use sortedMap from here on out if you want it in order.
	// Remember to clear sortedMap before trying to add new values!
	static LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

	private static void sortAscending(Map<String, Integer> source) {
		source.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	}

	// Major scale extraction method
	// Takes a chromatic scale and returns sortedMap containing major scale
	public static Map<String, Integer> getMajorScale(ChromaticScale sourceChromatic) {
		sortedMap.clear();
		Map<String, Integer> tempMap = sourceChromatic.getChromaticScale();
		sortAscending(tempMap);

		Map<String, Integer> extractedMajor = new HashMap<String, Integer>();
		int[] majorValues = { 0, 2, 4, 5, 7, 9, 11 };
		for (int i = 0; i < majorValues.length; i++) {
			for (String noteName : sortedMap.keySet()) {
				if (sortedMap.get(noteName).equals(majorValues[i])) {
					extractedMajor.put(noteName, majorValues[i]);
					break;
				}
			}
		}
		sortedMap.clear();
		sortAscending(extractedMajor);
		System.out.println(sortedMap);
		return sortedMap;
	}

	// Natural Minor Scale extractor method
	// Takes a chromatic scale and returns sortedMap as natural minor...
	// ...problem is that it uses sharps or flats always depending on input
	// ChromaticScale.
	public static Map<String, Integer> getNaturalMinorScale(ChromaticScale sourceChromatic) {
		sortedMap.clear();
		Map<String, Integer> tempMap = sourceChromatic.getChromaticScale();
		sortAscending(tempMap);

		Map<String, Integer> extractedMajor = new HashMap<String, Integer>();
		int[] naturalMinorValues = { 0, 2, 3, 5, 7, 8, 10 };
		for (int i = 0; i < naturalMinorValues.length; i++) {
			for (String noteName : sortedMap.keySet()) {
				if (sortedMap.get(noteName).equals(naturalMinorValues[i])) {
					extractedMajor.put(noteName, naturalMinorValues[i]);
					break;
				}
			}
		}
		sortedMap.clear();
		sortAscending(extractedMajor);
		System.out.println(sortedMap);
		return sortedMap;
	}

	// Minor Scale extractor method
	// Takes a chromatic scale and returns sortedMap as harmonic minor...
	// ...problem is that it uses sharps or flats always depending on input
	// ChromaticScale.
	public static Map<String, Integer> getHarmonicMinorScale(ChromaticScale sourceChromatic) {
		sortedMap.clear();
		Map<String, Integer> tempMap = sourceChromatic.getChromaticScale();
		sortAscending(tempMap);

		Map<String, Integer> extractedMajor = new HashMap<String, Integer>();
		int[] naturalMinorValues = { 0, 2, 3, 5, 7, 8, 11 };
		for (int i = 0; i < naturalMinorValues.length; i++) {
			for (String noteName : sortedMap.keySet()) {
				if (sortedMap.get(noteName).equals(naturalMinorValues[i])) {
					extractedMajor.put(noteName, naturalMinorValues[i]);
					break;
				}
			}
		}
		sortedMap.clear();
		sortAscending(extractedMajor);
		System.out.println(sortedMap);
		return sortedMap;
	}

	// Prints 12-tone matrix! Use sortedMap as source. - this messes everything up
	// as it sorts map into chromatic order!!
	public static void printNotesMatrix(Map<String, Integer> source) {
		List<String> notes = new ArrayList<>();
		List<Integer> values = new ArrayList<>();

		for (String note : source.keySet()) {
			notes.add(note);
		}
		for (int value : source.values()) {
			values.add(value);
		}
		System.out.println("     I" + values.toString());
		System.out.println("P" + values.get(0) + "     " + notes.toString());
		for (int i = 1; i < notes.size(); i++) {
			int j;
			System.out.print("P" + values.get(i) + "\t");
			for (j = i; j < notes.size(); j++) {
				System.out.print(notes.get(j) + ", ");
			}
			for (int k = 0; k < i; k++) {
				if (k < i - 1)
					System.out.print(notes.get(k) + ", ");
				else
					System.out.print(notes.get(k) + " ");
			}
			System.out.println();
		}
	}

	// Better printer... BUT only works correctly if going up chromatically.
	public static void printNotesMatrixTest(Map<String, Integer> source) {
		List<String> notes = new ArrayList<>();
		List<Integer> values = new ArrayList<>();

		for (String note : source.keySet()) {
			notes.add(note);
		}
		for (int value : source.values()) {
			values.add(value);
		}
		System.out.println("     I" + values.toString());
		System.out.println("P" + values.get(0) + "     " + notes.toString());
		for (int i = notes.size() - 1; i > 0; i--) {
			int j;
			System.out.print("P" + values.get(i) + "\t");
			for (j = i; j < notes.size(); j++) {
				System.out.print(notes.get(j) + ", ");
			}
			for (int k = 0; k < i; k++) {
				if (k < i - 1)
					System.out.print(notes.get(k) + ", ");
				else
					System.out.print(notes.get(k));
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		Map<String, Integer> testing = new LinkedHashMap<String, Integer>();

		testing.put("C", 0);
		testing.put("C#", 1);
		testing.put("D", 2);
		testing.put("D#", 3);
		testing.put("E", 4);
		testing.put("F", 5);
		testing.put("F#", 6);
		testing.put("G", 7);
		testing.put("G#", 8);
		testing.put("A", 9);
		testing.put("A#", 10);
		testing.put("B", 11);

		Map<Integer, String> newStandardMapTest = new LinkedHashMap<Integer, String>();
		newStandardMapTest.put(0, "C");
		newStandardMapTest.put(1, "C#");
		newStandardMapTest.put(2, "D");
		newStandardMapTest.put(3, "D#");
		newStandardMapTest.put(4, "E");
		newStandardMapTest.put(5, "F");
		newStandardMapTest.put(6, "F#");
		newStandardMapTest.put(7, "G");
		newStandardMapTest.put(8, "G#");
		newStandardMapTest.put(9, "A");
		newStandardMapTest.put(10, "A#");
		newStandardMapTest.put(11, "B");
		
		List<String> notesToShuffle = new ArrayList<>();
		for (String note : testing.keySet()) {
			notesToShuffle.add(note);
		}
		Collections.shuffle(notesToShuffle);
		
		List<Integer> shuffleList = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			shuffleList.add(i);
		}

		Collections.shuffle(shuffleList);
		System.out.println(shuffleList);
		
		
		
		
		
		
		
		
		
		Map<String, Integer> newTest = new LinkedHashMap<>();
		for (String note : notesToShuffle) {
			newTest.put(note, testing.get(note));
		}

		System.out.println("new test: " + newTest);
		sortedMap.clear();
		// This abomination of a call properly gets the first value for proper pivot
		// transpose.
		// No need to put into order since it would just arrange by increasing rather
		// than be a tone row.
		pivotTranspose(newTest, newTest.entrySet().iterator().next().getValue());
		
		
		Map<Integer, String> evenNewerTest = new LinkedHashMap<>();
		for (String note : newTest.keySet()) {
			evenNewerTest.put(newTest.get(note), note);
		}
		
		
		List<String> notes = new ArrayList<>();
		for (String key : newTest.keySet()) {
			notes.add(key);
		}
		List<Integer> values = new ArrayList<>();
		for (Integer value : newTest.values()) {
			values.add(value);
		}

	

		System.out.println("notes: " + notes);
		System.out.println("values: " + values);
		System.out.println("after pivot: " + newTest);
		System.out.println("even newer: " + evenNewerTest);
		

//		Map<String, Integer> inversionZeroMap = new LinkedHashMap<>();
//		for (int i = 1; i < 11; i++) {
//			int temp = values.get(i);
//			newVal = temp + 
//		}
		
		List<Integer> newValueList = new ArrayList<>();
		
		for (int i = 0; i < 11; i++) {
			newValueList.add(12 - values.get(i));
			if (newValueList.get(i) == 12) {
				newValueList.set(i, 0);
			}
		}
		

		Map<Integer, String> inversionZeroMapVN = new LinkedHashMap<>();
		for (Integer val : evenNewerTest.keySet()) {
			inversionZeroMapVN.put(12 - val, evenNewerTest.get(12 - val));
			if (inversionZeroMapVN.containsKey(12)) {
				inversionZeroMapVN.remove(12);
				inversionZeroMapVN.put(0, notes.get(0));
			}
		}
		
		System.out.println("invertZeroNewMap: " + inversionZeroMapVN + " size: " + inversionZeroMapVN.size());
		
		List<Integer> inversionZeroVals = new ArrayList<>();
		for (Integer val : inversionZeroMapVN.keySet()) {
			inversionZeroVals.add(val);
		}
		List<String> inversionZeroNotes = new ArrayList<>();
		for (String note : inversionZeroMapVN.values()) {
			inversionZeroNotes.add(note);
		}
		
		
		Map<Integer, String> primeOneMapVN = new LinkedHashMap<>();
		primeOneMapVN.put(inversionZeroVals.get(1), evenNewerTest.get(1));
		
		
		
		System.out.println("prime one map with even newer: " + primeOneMapVN + " size: " + primeOneMapVN.size());
		List<Integer> primeZero = new ArrayList<>();
		for (int i = 0; i < notesToShuffle.size(); i++) {
			primeZero.add(testing.get(notesToShuffle.get(i)));
		}

		List<Integer> inversionZero = new ArrayList<>();
		// (IT IS PRINTED IN A ROW
		// STILL)
		for (int i = 1; i < 12; i++) {
			inversionZero.add(12 - primeZero.get(i));
		}
		for (int i = 0; i < inversionZero.size(); i++) {
			if (inversionZero.get(i) == 12) {
				inversionZero.set(i, 0);
			}
		}

//		List<Integer> allPrimes = new ArrayList<>();
//		List<Integer> primeRow = new ArrayList<>();
//		for (int i = 0; i < 11; i++) {
//			allPrimes.addAll(primeRow);
//			for (int j = 0; j < 11; j++) {
//				primeRow.add(inversionOne.get(j));
//				for (int k = 0; k < 11; k++) {
//					primeRow.add(primeRow.get(j) + primeZero.get(i));
//					if (primeRow.get(i) > 11) {
//						primeRow.set(i, primeRow.get(i) - 12);
//					}
//				}
//			}
//		}

		List<Integer> primeOne = new ArrayList<>();
		primeOne.add(inversionZero.get(1));
		for (int i = 1; i < 11; i++) {
			primeOne.add(primeOne.get(0) + primeZero.get(i));
			if (primeOne.get(i) > 11) {
				primeOne.set(i, primeOne.get(i) - 12);
			}
		}

//		System.out.println("these are the notes: " + notes);
//		System.out.println("these are the values: " + values);
//		System.out.println("this is inversion zero map: " + inversionZeroMap);
//		System.out.println("prime 0 list: " + primeZero);
		System.out.println("inversion 0 list: " + inversionZero + " " + inversionZero.size());
//		System.out.println("this is prime one map: " + primeOneMap);

//		System.out.println(allPrimes.get(1).toString());

//		System.out.println("Before asdf " + testing);
//		pivotTranspose(testing, 4);
//		System.out.println("after asdf " + testing);
//		sortAscending(testing);
//		System.out.println("After sortAscending " + sortedMap);
//		
//		sortedMap.clear();
//		SharpChromaticScaleC chromaTest = new SharpChromaticScaleC();
//		System.out.println("Note at index 0: " + chromaTest.getNoteNameAtIndex(0));
//		System.out.println("Value at index 0: " + chromaTest.getNoteValAtIndex(0));
//		System.out.println("chromatest map: " + chromaTest.getChromaticScale());
//		System.out.println("Values: " + chromaTest.getChromaticValues());
//		
//		pivotTranspose(chromaTest.getChromaticScale(), 11);
//		System.out.println("Changed to B chromatic: " + chromaTest.getChromaticScale());
//
//		sortAscending(chromaTest.getChromaticScale());
//		System.out.println("Sorted B Chromatic: " + sortedMap);
//
//		printNotesMatrix(sortedMap);
//		printNotesMatrixTest(sortedMap);
//		
//
//		
//		
//		sortedMap.clear();
//
//		FlatChromaticScaleC flatChroma = new FlatChromaticScaleC();
//
//		System.out.println(flatChroma.getFlatChromaticScaleC());
//		pivotTranspose(flatChroma.getFlatChromaticScaleC(), 5);
//		System.out.println("Flat Chromatic asdf: " + flatChroma.getFlatChromaticScaleC());
//		sortAscending(flatChroma.getFlatChromaticScaleC());
//		System.out.println("Flat chromatic in sortedMap: " + sortedMap);
//		System.out.println(sortedMap.keySet());
//		sortedMap.clear();
//		SharpChromaticScaleC shuffleTest = new SharpChromaticScaleC();
//		Collections.shuffle(shuffleTest.getChromaticNotes());
//		System.out.println("Post shuffle scale" + shuffleTest.getChromaticScale());
//		System.out.println(shuffleTest.getChromaticValues());
//		pivotTranspose(shuffleTest.getChromaticScale(), 5);
//		sortAscending(shuffleTest.getChromaticScale());
//		System.out.println(sortedMap);
//		System.out.println(shuffleTest.getChromaticScale());
//		getMajorScale(shuffleTest);
//		getNaturalMinorScale(flatChroma);
//		getMajorScale(flatChroma);

//		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
//		testing.entrySet()
//	    .stream()
//	    .sorted(Map.Entry.comparingByValue())
//	    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//		System.out.println(testing);
//		System.out.println(" new map " + sortedMap);
//		Map<String, Integer> newChromatic = new HashMap<String, Integer>();
//		
//		List<Integer> chromaticValue = new ArrayList<>();
//		
//		for (Map.Entry<String, Integer> test : testing.entrySet()) {
//			if (test.getValue() < 0) {
//				
//				testing.put(test.getKey(), test.getValue() + 12);
//			}
//			chromaticValue.add(test.getValue());
//			newChromatic.put(test.getKey(), test.getValue());
//		}
//		
//		
//		
//		System.out.println("Chromatic value list: " + chromaticValue);
//		System.out.println("new Chomatic: " + newChromatic);
//		Collections.sort(chromaticValue);
//		System.out.println("Sorted chromatic value list: " + chromaticValue);
//		
//		for (int i = 0; i < chromaticValue.size(); i++) {
//			System.out.println(newChromatic);
//		}
//		
//		System.out.println(testing);
//		System.out.println(newChromatic);
//		System.out.println(
//				testing.entrySet()
//				.stream()
//				.sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));
//		testing.entrySet()
//		.stream()
//		.sorted(Map.Entry.comparingByValue())
//		.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//		System.out.println(sortedMap);
	}
}
