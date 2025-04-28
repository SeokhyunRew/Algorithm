import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        int temp;
            
        while(n!=0){
            temp=1;
            while(temp<=n) temp *= 2;
            n -= temp/2;
            ans++;
        }

        return ans;
    }
}