class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, 0, 1, target, numbers);
        dfs(0, 0, -1, target, numbers);
        
        return answer/2;
    }
    
    private void dfs(int index, int num, int sign, int target, int[] numbers){
        if(index==numbers.length){
            if(num==target) answer++;
            return;
        } 
        
        num += numbers[index]*sign;
        
        dfs(index+1, num, 1, target, numbers);
        dfs(index+1, num, -1, target, numbers);
        
    }
}