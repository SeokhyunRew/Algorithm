class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        int temp;
        String keep;
        
        for(String str : babbling){
            keep = str;
            temp = 0;
            while(temp<4){
                if(keep.length()==0 || keep.length()==1) break;
                if(keep.length()>=2 && (keep.substring(0,2).equals("ye") || keep.substring(0,2).equals("ma"))){
                    keep = keep.substring(2);
                    temp ++;
                    continue;
                } else if(keep.length()>=3 && (keep.substring(0,3).equals("aya") || keep.substring(0,3).equals("woo"))){
                    keep = keep.substring(3);
                    temp ++;
                    continue;
                }
                temp ++;
            }
            if(keep.equals("")) answer++;
        }
        
        return answer;
    }
}