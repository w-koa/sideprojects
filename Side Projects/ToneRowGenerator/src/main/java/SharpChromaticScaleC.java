import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SharpChromaticScaleC implements ChromaticScale {

	// Attributes
	private Map<String, Integer> sharpChromaticScaleC = new LinkedHashMap<String, Integer>();

	// Constructor for SharpChromatic Scale
	public SharpChromaticScaleC() {

		sharpChromaticScaleC.put("C", 0);
		sharpChromaticScaleC.put("C#", 1);
		sharpChromaticScaleC.put("D", 2);
		sharpChromaticScaleC.put("D#", 3);
		sharpChromaticScaleC.put("E", 4);
		sharpChromaticScaleC.put("F", 5);
		sharpChromaticScaleC.put("F#", 6);
		sharpChromaticScaleC.put("G", 7);
		sharpChromaticScaleC.put("G#", 8);
		sharpChromaticScaleC.put("A", 9);
		sharpChromaticScaleC.put("A#", 10);
		sharpChromaticScaleC.put("B", 11);
	}

	// Getter Overrides

	@Override
	public Map<String, Integer> getChromaticScale() {
		// TODO Auto-generated method stub
		return sharpChromaticScaleC;
	}

	@Override
	public List<String> getChromaticNotes() {
		List<String> sharpNotes = new ArrayList<String>(sharpChromaticScaleC.keySet());
		return sharpNotes;
	}

	@Override
	public List<Integer> getChromaticValues() {
		List<Integer> sharpValues = new ArrayList<Integer>();
		for (String key : sharpChromaticScaleC.keySet()) {
			sharpValues.add(sharpChromaticScaleC.get(key));
		}
		return sharpValues;
	}

	@Override
	public String getNoteNameAtIndex(int index) {
		List<String> sharpNotes = new ArrayList<String>(sharpChromaticScaleC.keySet());
		return sharpNotes.get(index);
	}

	@Override
	public int getNoteValAtIndex(int index) {
		List<Integer> sharpValues = new ArrayList<Integer>();
		for (String key : sharpChromaticScaleC.keySet()) {
			sharpValues.add(sharpChromaticScaleC.get(key));
		}
		return sharpValues.get(index);
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
		for (int i = notes.size() - 1; i > 0 ; i--) {
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
