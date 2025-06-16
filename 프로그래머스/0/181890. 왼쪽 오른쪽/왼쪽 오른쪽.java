class Solution {
    public String[] solution(String[] str_list) {
        int index = -1;
        String direction = "";

        // "l" 또는 "r"이 처음 등장하는 위치 탐색
        for (int i = 0; i < str_list.length; i++) {
            if (str_list[i].equals("l") || str_list[i].equals("r")) {
                direction = str_list[i];
                index = i;
                break;
            }
        }

        // 아무 방향도 없을 경우 빈 배열 반환
        if (index == -1) return new String[0];

        if (direction.equals("l")) {
            // 왼쪽: index 앞까지 자르기
            String[] answer = new String[index];
            for (int i = 0; i < index; i++) {
                answer[i] = str_list[i];
            }
            return answer;
        } else {
            // 오른쪽: index 뒤부터 끝까지 자르기
            String[] answer = new String[str_list.length - index - 1];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = str_list[index + 1 + i];
            }
            return answer;
        }
    }
}
