import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int num;
        int gcd;
        int lcm;

        gcd=getGCD(arr[0], arr[1]);
        lcm=arr[0]*arr[1]/gcd;

        for(int i=2; i<arr.length; i++){
            num=arr[i];
            gcd=getGCD(lcm,num);
            lcm=lcm*num/gcd;                     
        }
        
        return lcm;
    
    }
    
    private int getGCD(int a, int b){
        if(a%b==0) return b;
        return getGCD(b, a%b);
    }
    
}