import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class homework8 {
    public static void main(String[] args) throws FileNotFoundException {
        String filepath = "readFiles/homework8.txt";
        String output = "OutPutFile/homework8Output.txt";
        List<String> listOfStrings = new ArrayList<String>();
        // remove all spaces, commas
        Scanner sc = new Scanner(new FileReader(filepath)).useDelimiter("\\s+");
        PrintWriter writer = new PrintWriter(output);
        String str;
        // reading till the end of file
        while (sc.hasNext()) {
            str = sc.next();
            listOfStrings.add(str);
        }

        // converting this to an array.
        String[] words = listOfStrings.toArray(new String[0]);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        countDuplicateWords(words, map, writer);
        writer.close();
    }

    public static void countDuplicateWords(String[] words, HashMap<String, Integer> map, PrintWriter writer) {
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
            writer.println(s.getKey() + ": "  + s.getValue());
        }
    }
}
