package Easy;

import java.util.HashSet;

class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCharString = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<String>();

        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            for(char ch : word.toCharArray()) {
                sb.append(morseCharString[ch-97]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
    /* Submission 1
    String[] letterToCode = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(getCode(word));
        }
        return set.size();
    }

    public String getCode(String word) {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            code.append(letterToCode[word.charAt(i) - 'a']);
        }
        return code.toString();
    }*/
}