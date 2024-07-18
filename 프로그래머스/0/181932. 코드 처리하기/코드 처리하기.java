class Solution {
    public String solution(String code) {
        String answer ="";
        int mode = 0;
        int index = 0;

        for(char word : code.toCharArray()){
            if(word=='1'){
                if(mode==0){
                    mode = 1;
                }else{
                    mode = 0;
                }
            }else{
                if(mode==0){
                    if(index%2==0){
                        answer += word;
                    }
                }else{
                    if(index%2==1){
                        answer += word;
                    }
                }
            }
            index ++;
        }

        if(answer == ""){
            answer = "EMPTY";
        }
        return answer;
    }
}