class Solution {
    public int solution(int[] numbers) {
        int max1 = 0;
        int max2 = 0;
        int min1 = 0;
        int min2 = 0;
        
        if(numbers.length==2) return numbers[0]*numbers[1];
        
        for(int num : numbers){
            if(num>0){
                if(num>max1){
                    max2 = max1;
                    max1 = num;
                }else if(num>max2){
                    max2 = num;
                }
            }else{
                if(num<min1){
                    min2 = min1;
                    min1 = num;
                }else if(num<min2){
                    min2 = num;
                }
            }
        }
        
        return Math.max(max1*max2, min1*min2);
    }
}