import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 바로 실패
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        boolean[] visited = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.word.equals(target)) {
                return current.depth;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canTransform(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.depth + 1));
                }
            }
        }
        return 0;
    }

    // 단어 두 개가 한 글자만 다른지 확인
    private boolean canTransform(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}

class Node {
    String word;
    int depth;

    Node(String word, int depth) {
        this.word = word;
        this.depth = depth;
    }
}
