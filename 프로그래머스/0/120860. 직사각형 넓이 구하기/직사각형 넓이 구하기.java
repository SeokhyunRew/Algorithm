class Solution {
    public int solution(int[][] dots) {
        int x1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE;
        int y1 = Integer.MIN_VALUE;
        int y2 = Integer.MAX_VALUE;
        
        for(int i=0; i<4; i++){
            if(dots[i][0]>=x1) x1=dots[i][0];
            if(dots[i][0]<=x2) x2=dots[i][0];
            if(dots[i][1]>=y1) y1=dots[i][1];
            if(dots[i][1]<=y2) y2=dots[i][1];
        }
        
        return Math.abs(x1-x2)*Math.abs(y1-y2);
    }
}