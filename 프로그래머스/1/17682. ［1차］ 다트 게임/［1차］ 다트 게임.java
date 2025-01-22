import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] temp = new int[3]; 
        int index = -1; 
        StringBuilder numBuffer = new StringBuilder(); 

        for (char c : dartResult.toCharArray()) {
            if (Character.isDigit(c)) {
                numBuffer.append(c); 
            } else if (Character.isLetter(c)) {
                if (numBuffer.length() > 0) {
                    index++;
                    temp[index] = Integer.parseInt(numBuffer.toString());
                    numBuffer.setLength(0); 
                }
                switch (c) {
                    case 'S':
                        temp[index] = (int) Math.pow(temp[index], 1);
                        break;
                    case 'D':
                        temp[index] = (int) Math.pow(temp[index], 2);
                        break;
                    case 'T':
                        temp[index] = (int) Math.pow(temp[index], 3);
                        break;
                }
            } else {
                switch (c) {
                    case '*':
                        if (index > 0) {
                            temp[index - 1] *= 2;
                        }
                        temp[index] *= 2;
                        break;
                    case '#':
                        temp[index] *= -1;
                        break;
                }
            }
        }

        for (int i = 0; i <= index; i++) {
            answer += temp[i];
        }

        return answer;
    }
}
