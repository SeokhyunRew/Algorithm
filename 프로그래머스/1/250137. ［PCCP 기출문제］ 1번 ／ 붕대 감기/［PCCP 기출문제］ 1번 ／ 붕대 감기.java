class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int count_second = 0;
        int purpose_second = bandage[0];
        int get_hp = bandage[1];
        int add_hp = bandage[2];
        int max_hp = health;
        
        for(int i=0; i<attacks.length; i++){
            int time = attacks[i][0];
            int damage = attacks[i][1];
            
            while(time-count_second>purpose_second){
                health += purpose_second*get_hp+add_hp;
                count_second += purpose_second;
            }
            
            health += (time-count_second-1)*get_hp;
            if(health>max_hp) health=max_hp;
            health -= damage;
            count_second = time;
            if(health<=0) return -1;
            
        }
        
        return health;
    }
}