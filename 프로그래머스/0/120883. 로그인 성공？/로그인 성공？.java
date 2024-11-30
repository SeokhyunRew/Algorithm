class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        
        for(String[] array : db){
            if(id_pw[0].equals(array[0])){
                if(id_pw[1].equals(array[1])){
                    return "login";
                }else{
                    return "wrong pw";
                }
            }
        }
        
        return answer;
    }
}