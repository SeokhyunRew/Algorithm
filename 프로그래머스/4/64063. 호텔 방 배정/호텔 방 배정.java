import java.util.*;
class Solution {
    Map<Long, Long> room = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i=0; i<room_number.length; i++){
            answer[i] = find(room_number[i]);
        }
        
        return answer;
    }
    
    private long find(long id) {
        if (!room.containsKey(id)) {
            room.put(id, id + 1);
            return id;
        }
        
        long empty = find(room.get(id));
        room.put(id, empty);
        return empty;
    }
}