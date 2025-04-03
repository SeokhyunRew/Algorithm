class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        // 키패드 위치를 2차원 좌표로 설정
        int[][] pos = {
            {3, 1}, // 0
            {0, 0}, {0, 1}, {0, 2},  // 1 2 3
            {1, 0}, {1, 1}, {1, 2},  // 4 5 6
            {2, 0}, {2, 1}, {2, 2},  // 7 8 9
            {3, 0}, {3, 2}           // * => 10, # => 11
        };

        int[] leftPos = pos[10]; // 왼손: '*' 위치
        int[] rightPos = pos[11]; // 오른손: '#' 위치

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                answer.append("L");
                leftPos = pos[num];
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append("R");
                rightPos = pos[num];
            } else {
                int[] target = pos[num];

                int leftDist = Math.abs(leftPos[0] - target[0]) + Math.abs(leftPos[1] - target[1]);
                int rightDist = Math.abs(rightPos[0] - target[0]) + Math.abs(rightPos[1] - target[1]);

                if (leftDist < rightDist) {
                    answer.append("L");
                    leftPos = target;
                } else if (leftDist > rightDist) {
                    answer.append("R");
                    rightPos = target;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftPos = target;
                    } else {
                        answer.append("R");
                        rightPos = target;
                    }
                }
            }
        }

        return answer.toString();
    }
}
