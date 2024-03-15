import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String temp;
        int keep;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++){
            temp = callings[i];
            keep = map.get(temp);

            map.put(players[keep-1], keep);
            map.put(temp, keep-1);
            
            players[keep] = players[keep-1];
            players[keep-1] = temp;
        }

        return players;
    }
}