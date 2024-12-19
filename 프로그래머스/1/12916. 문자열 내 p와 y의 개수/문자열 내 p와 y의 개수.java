class Solution {
    boolean solution(String s) {
        // 문자열을 소문자로 변환
        s = s.toLowerCase();

        // 'p'와 'y'의 개수를 셈
        int pCount = 0;
        int yCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'p') {
                pCount++;
            } else if (c == 'y') {
                yCount++;
            }
        }

        // 'p'와 'y'의 개수가 같으면 true, 다르면 false 반환
        return pCount == yCount;
    }
}
