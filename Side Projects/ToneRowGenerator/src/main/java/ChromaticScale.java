import java.util.List;
import java.util.Map;

public interface ChromaticScale {
	
	public Map<String, Integer> getChromaticScale();
	public List<String> getChromaticNotes();
	public List<Integer> getChromaticValues();
	public String getNoteNameAtIndex(int index);
	public int getNoteValAtIndex(int index);
	public void printNotesMatrix(Map<String, Integer> source);
}
