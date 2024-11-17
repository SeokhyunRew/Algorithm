class Solution {
    public String solution(String rsp) {
        String answer = "";
        
        for(String string : rsp.split("")){
            
            switch (string) {
            case "2":
                answer += "0";
                break;
            case "0":
                answer += "5";
                break;
            case "5":
                answer += "2";
                break;
            default:
                answer += "Invalid input";
                break;
        }
            
        }
        
        return answer;
    }
}