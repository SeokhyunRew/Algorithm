class Solution {
    public int[] solution(int[] numbers, String direction){ 
        int temp = numbers[0];
        int backup;
        
        if(direction.equals("right")){
            for(int i=0; i<numbers.length; i++){
            backup = numbers[(i+1)%numbers.length];
            numbers[(i+1)%numbers.length] = temp;
            temp = backup;
            }    
        }else{
            for(int i=0; i<numbers.length-1; i++){
            numbers[i] = numbers[i+1];
            }
            numbers[numbers.length-1] = temp;
        }
        
        return numbers;
    }
}