import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        // 삽입 정렬로 직접 정렬 구현
        for (int i = 1; i < strings.length; i++) {
            String temp = strings[i];
            int j = i - 1;

            while (j >= 0) {
                char currChar = temp.charAt(n);
                char prevChar = strings[j].charAt(n);

                // 기준 인덱스의 문자가 작거나, 같고 사전순으로 더 앞서면 교환
                if (currChar < prevChar || (currChar == prevChar && temp.compareTo(strings[j]) < 0)) {
                    strings[j + 1] = strings[j];
                    j--;
                } else {
                    break;
                }
            }
            strings[j + 1] = temp;
        }

        return strings;
    }
}
