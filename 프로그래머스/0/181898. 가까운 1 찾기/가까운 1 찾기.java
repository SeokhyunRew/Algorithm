class Solution {
    public int solution(int[] arr, int idx) {
        for(int i=0; i<arr.length; i++) if(i>idx-1 && arr[i]==1) return i;
        return -1;
    }
}