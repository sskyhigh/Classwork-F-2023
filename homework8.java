import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class homework8 {
    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "readFiles/homework8.txt";
        List<String> listOfStrings = new ArrayList<String>();
        // remove all spaces
        Scanner sc = new Scanner(new FileReader(filepath)).useDelimiter("\\s+");
        String str;
        // reading till the end of file
        while (sc.hasNext()) {
            str = sc.next();
            listOfStrings.add(str);
        }

        // converting this to an array.
        String[] words = listOfStrings.toArray(new String[0]);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        countDuplicateWords(words, map);
    }

    public static void countDuplicateWords(String[] words, HashMap<String, Integer> map) {
        for (String word : words) {
            // if word appears more than once
            // add a value since val starts at 1
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
