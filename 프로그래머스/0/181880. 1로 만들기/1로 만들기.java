
class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for (int num : num_list) {
            int current = num;
            while (current != 1) {
                if (current % 2 == 0) {
                    current = current / 2;
                } else {
                    current = (current - 1) / 2;
                }
                answer++;
            }
        }
        
        return answer;
    }
}