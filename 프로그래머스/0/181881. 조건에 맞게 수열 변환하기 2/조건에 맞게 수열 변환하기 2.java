class Solution {
    public int solution(int[] arr) {
        int count = 0;

        while (true) {
            boolean changed = false;
            int[] newArr = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                int newNum;

                if (num >= 50 && num % 2 == 0) {
                    newNum = num / 2;
                } else if (num < 50 && num % 2 == 1) {
                    newNum = num * 2 + 1;
                } else {
                    newNum = num;
                }

                newArr[i] = newNum;

                if (newNum != num) {
                    changed = true;
                }
            }

            if (!changed) {
                return count;
            }

            arr = newArr;
            count++;
        }
    }
}
