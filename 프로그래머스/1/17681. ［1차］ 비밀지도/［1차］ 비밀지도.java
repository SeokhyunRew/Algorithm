class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr1.length; i++){
            sb.setLength(0);
            for(int j=0; j<n; j++){
                if(arr1[i]%2==1||arr2[i]%2==1) sb.append('#');
                else sb.append(' ');
                arr1[i]/=2;
                arr2[i]/=2;
            }
            sb.reverse();
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}