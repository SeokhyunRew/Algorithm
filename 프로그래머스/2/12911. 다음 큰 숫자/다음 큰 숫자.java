class Solution {
    public int solution(int n) {
        int targetOnes = Integer.bitCount(n);
        int candidate = n + 1;
        while (Integer.bitCount(candidate) != targetOnes) {
            candidate++;
        }
        return candidate;
    }
}

