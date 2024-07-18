class Solution {
    public int solution(int[] num_list) {
        int temp1 = 0;
        int temp2 = 1;

        for (int i = 0; i < num_list.length; i++) {
            temp1 += num_list[i];
            temp2 *= num_list[i];
        }

        if((int) Math.pow(temp1,2) > temp2){
            return 1;
        }else{
            return 0;
        }
    }
}