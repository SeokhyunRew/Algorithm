import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sumQ1 = 0;
        long sumQ2 = 0;
        int count = 0;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2= new ArrayDeque<>();

        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sumQ1 += queue1[i];

            q2.add(queue2[i]);
            sumQ2 += queue2[i];
        }

        while(sumQ1 != sumQ2){
            if(count>0){
                if(q1.size()==0 || q2.size()==0 || count==(queue1.length+queue2.length)*2){
                    count = -1;
                    break;
                }
            }
            if(sumQ1 > sumQ2){
                sumQ1 -= q1.peek();
                sumQ2 += q1.peek();
                q2.add(q1.poll());
            }else{
                sumQ2 -= q2.peek();
                sumQ1 += q2.peek();
                q1.add(q2.poll());
            }
            count ++;
        }
       return count;
    }
}