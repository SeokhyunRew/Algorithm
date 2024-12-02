import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
         // 정렬 로직 직접 구현
        for (int i = 0; i < numlist.length - 1; i++) {
            for (int j = i + 1; j < numlist.length; j++) {
                int distI = Math.abs(numlist[i] - n); // 현재 요소의 거리
                int distJ = Math.abs(numlist[j] - n); // 비교 요소의 거리
                
                // 거리 비교 후 정렬
                if (distI > distJ || (distI == distJ && numlist[i] < numlist[j])) {
                    // 두 값을 교환
                    int temp = numlist[i];
                    numlist[i] = numlist[j];
                    numlist[j] = temp;
                }
            }
        }
        
        return numlist; // 정렬된 배열 반환
    }
}