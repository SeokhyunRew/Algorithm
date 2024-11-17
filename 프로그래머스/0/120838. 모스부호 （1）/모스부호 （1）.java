import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        
        String[] morseArray = {
                ".-", "a", "-...", "b", "-.-.", "c", "-..", "d", ".", "e", "..-.", "f",
                "--.", "g", "....", "h", "..", "i", ".---", "j", "-.-", "k", ".-..", "l",
                "--", "m", "-.", "n", "---", "o", ".--.", "p", "--.-", "q", ".-.", "r",
                "...", "s", "-", "t", "..-", "u", "...-", "v", ".--", "w", "-..-", "x",
                "-.--", "y", "--..", "z"
        };
        
        Map<String, String> morseMap = new HashMap<>();

        for (int i = 0; i < morseArray.length; i += 2) {
            String key = morseArray[i];
            String value = morseArray[i + 1];
            morseMap.put(key, value);
        }
        
        String[] temp = letter.split(" ");
        
        for(String string : temp){
            answer += morseMap.get(string);
        }

        return answer;
    }
}