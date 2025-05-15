import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            int prevX = x;
            int prevY = y;

            switch (c) {
                case 'U': y++; break;
                case 'D': y--; break;
                case 'R': x++; break;
                case 'L': x--; break;
            }

            if (x < -5 || x > 5 || y < -5 || y > 5) {
                x = prevX;
                y = prevY;
                continue;
            }

            String path1 = prevX + "," + prevY + "," + x + "," + y;
            String path2 = x + "," + y + "," + prevX + "," + prevY;

            if (!visited.contains(path1) && !visited.contains(path2)) {
                visited.add(path1);
                visited.add(path2);
                answer++;
            }
        }

        return answer;
    }
}
