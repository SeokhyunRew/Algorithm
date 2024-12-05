class Solution {
    public int[] solution(int l, int r) {
        StringBuilder sb = new StringBuilder();
        String temp;
        int count = 0;
        
        for(int i=l; i<=r; i++){
            if(i%5==0){
                sb.append(i);
                temp = sb.toString();
                temp = temp.replace("0", "");
                temp = temp.replace("5", "");
                if(temp.equals("")) count++;
                sb.setLength(0);
                temp = "";
            } else continue;
        }
        
        if(count==0) return new int[] {-1};
        
        int[] answer = new int[count];
        count = 0;
        
        for(int i=l; i<=r; i++){
            if(i%5==0){
                sb.append(i);
                temp = sb.toString();
                temp = temp.replace("0", "");
                temp = temp.replace("5", "");
                if(temp.equals("")){
                    answer[count] = i;
                    count ++;
                } 
                sb.setLength(0);
                temp = "";
            } else continue;
        }
        
        return answer;
    }
}