class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int temp = 0;
        int temp_zero = 0;
        
        for(int i=0; i<lottos.length; i++){
            if(lottos[i]==0) temp_zero++;
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i]==win_nums[j]) temp++;
            }
        }
        
        answer[1] = calculate_rank(temp);
        if(temp<6-temp_zero) answer[0] = calculate_rank(temp + temp_zero);
        else answer[0] = 1;
        
        return answer;
    }
    
    private int calculate_rank(int num){
        switch (num) {
            case 0:
                return 6;
            case 1:
                return 6;
            case 2 :
                return 5;
            case 3 :
                return 4;
            case 4 :
                return 3;
            case 5 :
                return 2;
            case 6 :
                return 1;
        }
        return 0;
    }
}