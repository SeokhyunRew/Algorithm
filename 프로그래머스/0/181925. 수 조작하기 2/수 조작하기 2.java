class Solution {
    public String solution(int[] numLog) {
        int n = numLog[0];
        int temp;
        String answer = "";

        for (int i=1; i < numLog.length ; i++){

            temp = numLog[i] - n;

            switch(temp){
                case 1:
                    answer += 'w';
                    break;
                case -1:
                    answer += 's';
                    break;
                case 10:
                    answer += 'd';
                    break;
                case -10:
                    answer += 'a';
                    break;
            }

            n = numLog[i];
        }
        return answer;
    }
}