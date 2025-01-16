import java.time.LocalDate;
import java.util.*;
class Solution {
    public String solution(int a, int b) {
        HashMap<Integer, String> map = new HashMap<>();
        
        map.put(0, "FRI");
        map.put(1, "SAT");
        map.put(2, "SUN");
        map.put(3, "MON");
        map.put(4, "TUE");
        map.put(5, "WED");
        map.put(6, "THU");
        
        LocalDate startDate = LocalDate.of(2016, 1, 1);
        LocalDate endDate = LocalDate.of(2016, a, b);

         // 날짜 차이 계산 (전체 일수 차이)
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        
        
        return map.get((int) (daysBetween%7));
    }
}