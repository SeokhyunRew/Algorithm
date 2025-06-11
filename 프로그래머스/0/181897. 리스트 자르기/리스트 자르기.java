import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        List<Integer> temp = new ArrayList<>();

        if (n == 1) {
            for (int i = 0; i <= b; i++) temp.add(num_list[i]);
        } else if (n == 2) {
            for (int i = a; i < num_list.length; i++) temp.add(num_list[i]);
        } else if (n == 3) {
            for (int i = a; i <= b; i++) temp.add(num_list[i]);
        } else if (n == 4) {
            for (int i = a; i <= b; i += c) temp.add(num_list[i]);
        }

        // List<Integer> → int[]
        int[] answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}
