import java.util.HashMap;
class Solution {
    public int solution(String[] words) {
        Trie trie = new Trie();
        int answer = 0;

        // Insert words into trie
        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words){
           answer += trie.findMinInput(word);
        }
        return answer;
    }
}

class TrieNode {
    HashMap<Character, TrieNode> children;
    int wordCount; // 각 노드에서 해당 노드를 포함하는 단어의 개수를 추적합니다.

    public TrieNode() {
        children = new HashMap<>();
        wordCount = 0;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
            node.wordCount++; // 단어가 삽입되었으므로 해당 노드의 단어 개수를 증가시킵니다.
        }
    }

    public int findMinInput(String word) {
        TrieNode node = root;
        int count = 0;
        for (char ch : word.toCharArray()) {
            if (node.children.containsKey(ch)) {
                node = node.children.get(ch);
                count++;
                if (node.wordCount == 1) // Unique prefix found, stop
                    break;
            } else {
                break;
            }
        }
        return count;
    }
}