class Solution {
    public int[] solution(int l, int r) {
        int start = String.valueOf(l).length();
        int end = String.valueOf(r).length();
        int count = 0;

        for (int j = (int) Math.pow(2, start - 1); j < (int) Math.pow(2, end); j++) {
            int num = Integer.parseInt(Integer.toBinaryString(j)) * 5;

            if (num >= l && num <= r) {
                count++;
            }
        }

        if (count == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[count];
        count = 0;

        for (int j = (int) Math.pow(2, start - 1); j < (int) Math.pow(2, end); j++) {
            int num = Integer.parseInt(Integer.toBinaryString(j)) * 5;
            if (num >= l && num <= r) {
                answer[count] = num;
                count++;
            }
        }

        return answer;
    }
}
