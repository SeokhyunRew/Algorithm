class Solution {
    public int solution(String myString, String pat) {
        StringBuilder swapped = new StringBuilder();

        // A <-> B 문자 치환
        for (char c : myString.toCharArray()) {
            if (c == 'A') swapped.append('B');
            else if (c == 'B') swapped.append('A');
        }

        // pat이 포함되어 있는지 확인
        if (swapped.toString().contains(pat)) return 1;
        else return 0;
    }
}
