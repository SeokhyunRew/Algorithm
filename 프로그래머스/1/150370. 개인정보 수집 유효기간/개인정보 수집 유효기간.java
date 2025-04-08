import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character, Integer> map = new HashMap<>();
        int year;
        int month;
        int day;
        char type;
        int todayYear = Integer.parseInt(today.substring(0,4));
        int todayMonth = Integer.parseInt(today.substring(5,7));
        int todayDay = Integer.parseInt(today.substring(8,10));
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        
        for(String s : terms) {
            String[] split = s.split(" ");
            map.put(split[0].charAt(0), Integer.parseInt(split[1]));
        }

        
        for(String s : privacies){
            index++;
            year = Integer.parseInt(s.substring(0,4));
            month = Integer.parseInt(s.substring(5,7));
            day = Integer.parseInt(s.substring(8,10));
            type = s.charAt(11);
            
            month += map.get(type);
            while (month > 12) {
                year++;
                month -= 12;
            }

            if(year<todayYear) result.add(index);
            else if(year>todayYear) continue;
            else{
                if(month<todayMonth) result.add(index);
                else if(month>todayMonth) continue;
                else{
                    if(day<=todayDay) result.add(index);
                    else continue;
                }
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) answer[i] = result.get(i);
        
        return answer;
    }
}