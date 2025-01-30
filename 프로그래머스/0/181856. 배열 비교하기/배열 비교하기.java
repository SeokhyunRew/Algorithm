class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int temp1 = 0;
        int temp2 = 0;
        
        if(arr1.length>arr2.length) return 1;
        else if(arr1.length<arr2.length) return -1;
        else{
            for(int i=0; i<arr1.length; i++){
                temp1 += arr1[i];
            }
            for(int i=0; i<arr1.length; i++){
                temp2 += arr2[i];
            }
            if(temp1>temp2) return 1;
            else if(temp1<temp2) return -1;
            else return 0;
        }
     
    }
}