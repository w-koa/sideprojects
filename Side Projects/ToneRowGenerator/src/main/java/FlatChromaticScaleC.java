import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlatChromaticScaleC implements ChromaticScale {

	// Attributes
	private Map<String, Integer> flatChromaticScaleC = new LinkedHashMap<String, Integer>();

	// Constructor
	public FlatChromaticScaleC() {

		flatChromaticScaleC.put("C", 0);
		flatChromaticScaleC.put("Db", 1);
		flatChromaticScaleC.put("D", 2);
		flatChromaticScaleC.put("Eb", 3);
		flatChromaticScaleC.put("E", 4);
		flatChromaticScaleC.put("F", 5);
		flatChromaticScaleC.put("Gb", 6);
		flatChromaticScaleC.put("G", 7);
		flatChromaticScaleC.put("Ab", 8);
		flatChromaticScaleC.put("A", 9);
		flatChromaticScaleC.put("Bb", 10);
		flatChromaticScaleC.put("B", 11);
	}

	// Getter
	public Map<String, Integer> getFlatChromaticScaleC() {
		return flatChromaticScaleC;
	}

	@Override
	public Map<String, Integer> getChromaticScale() {

		return flatChromaticScaleC;
	}

	@Override
	public List<String> getChromaticNotes() {
		List<String> flatNotes = new ArrayList<String>(flatChromaticScaleC.keySet());
		return flatNotes;
	}

	@Override
	public List<Integer> getChromaticValues() {
		List<Integer> flatValues = new ArrayList<Integer>();
		for (String key : flatChromaticScaleC.keySet()) {
			flatValues.add(flatChromaticScaleC.get(key));
		}
		return flatValues;
	}

	@Override
	public String getNoteNameAtIndex(int index) {
		List<String> flatNotes = new ArrayList<String>(flatChromaticScaleC.keySet());
		return flatNotes.get(index);
	}

	@Override
	public int getNoteValAtIndex(int index) {
		List<Integer> flatValues = new ArrayList<Integer>();
		for (String key : flatChromaticScaleC.keySet()) {
			flatValues.add(flatChromaticScaleC.get(key));
		}
		return flatValues.get(index);
	}

	// Prints 12-tone matrix! Use sortedMap as source.
	@Override
	public void printNotesMatrix(Map<String, Integer> source) {
		List<String> notes = new ArrayList<>();
		List<Integer> values = new ArrayList<>();

		for (String note : source.keySet()) {
			notes.add(note);
		}
		for (int value : source.values()) {
			values.add(value);
		}
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
					System.out.print(notes.get(k) + " ");
			}
			System.out.println();
		}
	}
}
