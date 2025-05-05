import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Set<String> cash = new HashSet<>();
        Queue<String> cashOrder =  new LinkedList<>();
        
        for(int i=0; i<cities.length; i++){
            String target=cities[i].toLowerCase();
            if(cash.contains(target)){
                answer++;
                cashOrder.remove(target); // 기존 위치 제거
                cashOrder.offer(target);  // 새로 가장 최근으로 추가
            }else{
                answer+=5;
                if(cacheSize==0) continue;
                if(cash.size()<cacheSize){
                    cash.add(target);
                    cashOrder.offer(target);
                }else{
                    cash.remove(cashOrder.peek());
                    cashOrder.poll();
                    cash.add(target);
                    cashOrder.offer(target);
                }
            }
        }
        
        return answer;
    }
 
}