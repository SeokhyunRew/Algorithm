import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] temp = new double[N][2];
        int up;
        int down;
        double percent = 0;
        
        for(int i=1; i<=N; i++){
            up=0;
            down=0;
            for(int j=0; j<stages.length; j++){
                if(stages[j]>=i) down++;
                if(stages[j]==i) up++;
            }
            percent = (down == 0) ? 0 : (double) up / down;
            temp[i-1][0] = percent; 
            temp[i-1][1] = i; 
        }
        
        Arrays.sort(temp, (a, b) -> {
            if (Double.compare(b[0], a[0]) == 0) {
                return Double.compare(a[1], b[1]);
            }
            return Double.compare(b[0], a[0]);
        });
        
        for(int i=0; i<answer.length; i++){
            answer[i] = (int) temp[i][1];            
        }
        
        return answer;
    }
}