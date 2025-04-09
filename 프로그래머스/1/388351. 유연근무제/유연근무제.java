class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int purpose_time;
        int init = startday;
        boolean check;
        
        for(int i=0; i<timelogs.length; i++){
            purpose_time = schedules[i];
            startday = init-1;
            check = true;
            for(int j=0; j<7; j++){
                startday++;
                int dayOfWeek = (startday - 1) % 7 + 1;
                if(dayOfWeek==6||dayOfWeek==7) continue;
                if(calculate(purpose_time+10)<calculate(timelogs[i][j])){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
        }
        
        return answer;
    }
    
    private int calculate(int init){
        int hour=init/100;
        int minute=init%100;
        
        return hour*60 + minute;
        
    }
}