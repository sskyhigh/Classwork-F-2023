import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class homework8 {
    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "readFiles/homework8.txt";
        List<String> listOfStrings = new ArrayList<String>();
        // load content of file based on specific delimiter
        Scanner sc = new Scanner(new FileReader(filepath)).useDelimiter("\\s+");
        String str;
        // checking end of file
        while (sc.hasNext()) {
            str = sc.next();
            listOfStrings.add(str);
        }

        String[] words = listOfStrings.toArray(new String[0]);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        countDuplicateWords(words, map);

    }

    public static void countDuplicateWords(String[] words, HashMap<String, Integer> map) {
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for(Map.Entry<String, Integer> s: map.entrySet()){
            System.out.println(s.getKey() + ": "  + s.getValue());
        }
    }
}
