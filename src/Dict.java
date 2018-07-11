import java.io.*;
import java.util.*;

public class Dict {

	private HashMap<String, VerbEntry> verbDict;
	private HashMap<String, VerbEntry> adjDict;
	
	/**
	 * Reads in an instance of the Korean wiktionary data
	 */
	public Dict() {
		
		verbDict = new HashMap<String, VerbEntry>();
		adjDict = new HashMap<String, VerbEntry>();
		
		try {
			String[] details = new String[5];
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("resources/ko-en-dict.tsv")));
			String line;
			
			while ((line = br.readLine()) != null) {

				details = line.split("\t", -1);
				
				if (details[0].length() > 1 &&
					details[0].endsWith("다") && 
					(details[2].equals("A") || details[2].equals("V")) &&
					details[3].contains("ko-conj")) {
					
					VerbEntry v = new VerbEntry(details[0], details[2]);
					if (details[3].contains("ko-conjadj")) {
						v.setFunction("adj");
					} else {
						v.setFunction("verb");
					}
					
					/* The following if/else statements rely on the particular phrasing I know to be in the current wiktionary file.
					 * This section could possibly need to be updated if the wiktionary file is updated to include other arguments.
					 */
					if (details[3].contains("irreg=y")) {
						v.setIrreg(true);
					}
					if (details[3].contains("imperative=no")) {
						v.setImperative(false);
						v.setHonimperative(false);
					}
					if (details[3].contains("honorific=no")) {
						v.setHonorific(false);
					}
					
					if (details[2].equals("V")) {
						verbDict.put(details[0], v);
					} else {
						adjDict.put(details[0], v);
					}
				}
			}
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param word a Korean infinitive
	 * @return an ArrayList of VerbEntry for this word from the dictionary
	 * (Most words will only have one dictionary entry, but there are cases
	 * of words being both a verb and adjective)
	 */
	public ArrayList<VerbEntry> get(String word) {
		
		ArrayList<VerbEntry> entry = new ArrayList<VerbEntry>();
		if (verbDict.containsKey(word)) {
			entry.add(verbDict.get(word));
		}
		if (adjDict.containsKey(word)) {
			entry.add(adjDict.get(word));
		}
		
		if (entry.isEmpty()) {
			return null;
		}
		return entry;
	}
}
