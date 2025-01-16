import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] temp = new int[3];
        
        for(int i=0; i<answers.length; i++){
            if(answers[i]==one[i%one.length]) temp[0]++;
            if(answers[i]==two[i%two.length]) temp[1]++;
            if(answers[i]==three[i%three.length]) temp[2]++;
        }
        
        int[] temp2 = Arrays.copyOf(temp, temp.length);
        Arrays.sort(temp2);
        int num = 0;
        
        for(int i=0; i<temp2.length; i++){
            if(temp2[i]==temp2[2]) num++;
        }
        
        int[] answer = new int[num];
        int index = 0;
        
        for(int i=0; i<temp.length; i++){
            if(temp[i]==temp2[2]){
                answer[index] = i+1;
                index++;
            }
        }
        
        return answer;
    }
}