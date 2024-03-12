import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] numbersString = s.split(" ");
        int[] numbersInt = Arrays.stream(numbersString).mapToInt(Integer::parseInt).toArray();
        int min = Arrays.stream(numbersInt).min().getAsInt();
        int max = Arrays.stream(numbersInt).max().getAsInt();
        return min + " " + max;
    }
}