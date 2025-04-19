import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) queue.add(new int[] {progresses[i], speeds[i]});
        
        while(!queue.isEmpty()){
            int[] currArray = queue.poll();
            int currSpeed = currArray[1];
            int currProgress = currArray[0]+day*currSpeed;
            
            if(currProgress >= 100){
                count++;
                continue;
            }else arrayList.add(count);
                
            count = 0;
            
            if((100-currProgress)%currSpeed==0) day += (100-currProgress)/currSpeed;
            else day += (100-currProgress)/currSpeed + 1;
            
            count ++;
        }
        arrayList.add(count);
        
        int[] answer = new int[arrayList.size()-1];
        
        for(int i=0; i<answer.length; i++) answer[i] = arrayList.get(i+1);
        
        return answer;
    }
}