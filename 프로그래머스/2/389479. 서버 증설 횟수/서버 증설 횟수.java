class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[24];
        int player;
        
        for(int i=0; i<24; i++){
            player=players[i];
            if(player> server[i]*m){
                int needServer = player/m-server[i]; 
                answer+=needServer;
                if(i+k>24) k=24-i;
                for(int j=i; j<i+k; j++){
                    server[j] += needServer;
                }
            }
        }
        
        return answer;
    }
}