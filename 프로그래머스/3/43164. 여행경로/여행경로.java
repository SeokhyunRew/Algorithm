import java.util.*;

class Solution {
    ArrayList<String[]> rout = new ArrayList<>();
    String[] oneRout;
    int index = 0;

    public String[] solution(String[][] tickets) {
        oneRout = new String[tickets.length + 1];
        boolean[] useTickets = new boolean[tickets.length];
        oneRout[0] = "ICN";
        dfs(tickets, "ICN", useTickets);

        return select();
    }

    private void dfs(String[][] tickets, String start, boolean[] useTickets) {
        if (finish(useTickets)) {
            rout.add(oneRout.clone()); // 기존 배열을 복사해서 추가
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (canGo(start, tickets[i]) && !useTickets[i]) {
                useTickets[i] = true;
                oneRout[++index] = tickets[i][1];
                dfs(tickets, tickets[i][1], useTickets);
                useTickets[i] = false; // 백트래킹
                index--; // 백트래킹
            }
        }
    }

    private boolean canGo(String start, String[] list) {
        return start.equals(list[0]);
    }

    private boolean finish(boolean[] useTickets) {
        for (boolean b : useTickets) {
            if (!b) return false;
        }
        return true;
    }

    private String[] select() {
        String[] first = rout.get(0);

        for (String[] list : rout) {
            for (int i = 0; i < list.length; i++) {
                String s1 = first[i];
                String s2 = list[i];
                if (s1.compareTo(s2) > 0) {
                    first = list; // 비교 후 더 작은 알파벳순으로 선택
                    break;
                } else if (s1.compareTo(s2) < 0) {
                    break;
                }
            }
        }
        return first;
    }
}
