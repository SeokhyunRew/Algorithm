import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        
        // 각 주문에서 조합 생성
        for(String order : orders){
            // ✅ 문자열을 먼저 정렬 (ABC와 CBA가 같은 조합이 되도록)
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            String sortedOrder = new String(chars);
            
            for(int num : course){
                if(sortedOrder.length() >= num) {
                    dfs(new StringBuilder(), sortedOrder, 0, num, map);
                }
            }
        }
        
        // 각 코스 길이별로 최대 빈도 찾기
        for(int num : course){
            int max = 0;
            Set<String> set = new HashSet<>();
            
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                if(entry.getKey().length() == num && entry.getValue() >= 2){
                    if(max < entry.getValue()){
                        max = entry.getValue();
                        set.clear();
                        set.add(entry.getKey());
                    } else if(max == entry.getValue()) {
                        set.add(entry.getKey());
                    }
                }
            }
            
            // ✅ max가 0이 아닐 때만 추가 (2명 이상 주문한 경우만)
            if(max >= 2) {
                list.addAll(set);
            }
        }
        
        // 결과 정렬 후 반환
        Collections.sort(list);
        return list.toArray(new String[0]);
    }
    
    private void dfs(StringBuilder sb, String order, int index, int maxLength, Map<String, Integer> map){
        // ✅ sb의 길이가 목표 길이에 도달했을 때
        if(sb.length() == maxLength){
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0) + 1);
            return;
        }
        
        for(int i = index; i < order.length(); i++){
            sb.append(order.charAt(i));
            dfs(sb, order, i + 1, maxLength, map);  // ✅ i+1로 다음 위치부터 탐색
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}