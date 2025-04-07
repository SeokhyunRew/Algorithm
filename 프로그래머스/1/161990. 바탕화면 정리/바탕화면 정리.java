class Solution {
    public int[] solution(String[] wallpaper) {
        char[] temp_ch;
        int min_x = Integer.MAX_VALUE;
        int min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE;
        int max_y = Integer.MIN_VALUE;
        char target;
        
        for(int i=0; i<wallpaper.length; i++){
            temp_ch = wallpaper[i].toCharArray();
            for(int j=0; j<temp_ch.length; j++){
                target = temp_ch[j];
                if(target=='#'){
                    if(i<min_x) min_x=i;
                    if(j<min_y) min_y=j;
                    if(i>=max_x) max_x=i+1;
                    if(j>=max_y) max_y=j+1;
                }
            }
        }
        
        int[] answer = {min_x, min_y, max_x, max_y};
        return answer;
    }
}