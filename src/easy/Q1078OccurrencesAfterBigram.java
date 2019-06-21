package easy;

import java.util.LinkedList;
import java.util.List;

public class Q1078OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new LinkedList<>();

        String[] words = text.split(" ");
        for(int i = 0; i < words.length - 2; i++) {
            if(words[i].equals(first) && words[i+1].equals(second)) {
                result.add(words[i+2]);
            }
        }

        String[] res = new String[result.size()];
        return result.toArray(res);
    }


}
