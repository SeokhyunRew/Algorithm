import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();

        // 모든 전화번호를 해시셋에 저장
        for (String number : phone_book) {
            set.add(number);
        }

        // 각 전화번호에 대해 접두어가 해시셋에 있는지 확인
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                if (set.contains(prefix)) {
                    return false; // 접두어 발견
                }
            }
        }

        return true; // 접두어 없음
    }
}
