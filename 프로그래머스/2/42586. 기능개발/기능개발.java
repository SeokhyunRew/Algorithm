import java.util.ArrayList;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int day = 0;
        int stack = 0;
        int currProgress;
        int currSpeed;
        
        for(int i=0; i<progresses.length; i++){
            currProgress = progresses[i];
            currSpeed = speeds[i];
            
            if(currProgress+day*currSpeed < 100){
                arr.add(stack);
                day = ((100-currProgress)%currSpeed==0)?(100-currProgress)/currSpeed:(100-currProgress)/currSpeed+1;
                stack = 0;
            }
                
            stack++;
        }
        
        arr.add(stack);
        int[] answer = new int[arr.size()-1];
        
        for(int i=1; i<arr.size(); i++)  answer[i-1] = arr.get(i);
        
        return answer;
    }
}