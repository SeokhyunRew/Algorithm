import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 1) int[] → String[]
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 2) (s1+s2) 와 (s2+s1) 비교 → 내림차순 정렬
        Arrays.sort(arr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        // 3) 맨 앞이 "0" 이면 결과 전체가 0 이므로 예외 처리
        if (arr[0].equals("0")) {
            return "0";
        }

        // 4) 순서대로 붙여서 리턴
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
