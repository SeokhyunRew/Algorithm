class Solution {
    public int solution(int n) {
        int answer = 0;
        int temp = 0;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        
        while(true){
            if(n-Math.pow(3, temp)<0) break;
            temp++;
        }
        
        int[] three = new int[temp];
        
        for(int i=0; i<temp; i++){
            three[i] = (int) Math.pow(3, temp-i-1);
        }
        
        for(int j=0; j<temp; j++){
            while(true){
                if(n-three[j]>=0){
                    n -= three[j];
                    count++;
                }else break;
            }
            sb.append(count);
            count = 0;
        }
        
        sb.reverse();
        
        for(int h=0; h<temp; h++){
            answer += three[h]*(sb.charAt(h)-'0');
        }
        
        return answer;
    }
}