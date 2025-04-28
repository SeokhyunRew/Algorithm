class Solution {
    public int[] solution(int brown, int yellow) {
        
        int height=1;
        int width=1;
        
        for(int i= (int)Math.sqrt(yellow); i>0; i--){
            if(yellow%i==0){
                width = yellow/i;
                if((width+2)*2+2*i==brown){
                    height=i;
                    break;
                }
            }
        } 
        
        return new int[] {width+2, height+2};
    }
}