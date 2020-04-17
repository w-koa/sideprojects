import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MajorScaleTest {

	static LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
	private static void sortAscending(Map<String, Integer> source) {
		source.entrySet()
	    .stream()
	    .sorted(Map.Entry.comparingByValue())
	    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
	}
	
	public static void main(String[] args) {
	
		SharpChromaticScaleC chroma = new SharpChromaticScaleC();
		Map<String, Integer> major = new HashMap<>();
		
		major.put("C", 0);
		major.put("D", 2);
		major.put("E", 4);
		major.put("F", 5);
		major.put("G", 7);
		major.put("A", 9);
		major.put("B", 11);
		
		
		sortAscending(major);
		System.out.println(sortedMap);
		
		
		
		
	}
}
