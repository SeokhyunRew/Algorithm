import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
        // 인덱스를 정렬 (순서 보장)
        Arrays.sort(indices);

        // 결과를 저장할 StringBuilder
        StringBuilder result = new StringBuilder();

        // 문자열의 각 문자 순회
        int indexPointer = 0; // indices 배열의 포인터
        for (int i = 0; i < my_string.length(); i++) {
            // 현재 인덱스가 삭제해야 할 인덱스인지 확인
            if (indexPointer < indices.length && i == indices[indexPointer]) {
                indexPointer++; // 삭제 대상 인덱스라면 건너뜀
            } else {
                result.append(my_string.charAt(i)); // 유지해야 할 문자 추가
            }
        }

        return result.toString();
    }
}
