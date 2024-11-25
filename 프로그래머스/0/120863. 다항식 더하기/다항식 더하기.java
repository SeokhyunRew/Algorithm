class Solution {
    public String solution(String polynomial) {
        int num=0;
        int x_num=0;
        StringBuilder answer = new StringBuilder();
        String[] array = polynomial.split(" ");
        
        for(String str : array){
            if(str.equals("+")) continue;
            else if(str.contains("x")){
                if(str.equals("x")) x_num++;
                else x_num+=Integer.parseInt(str.replace("x", ""));
            }else num+=Integer.parseInt(str);
        }
        
        if (x_num != 0) {
            answer.append(x_num == 1 ? "x" : x_num + "x");
        }
        if (num != 0) {
            if (x_num != 0) answer.append(" + ");
            answer.append(num);         
        }
        
        return answer.toString();
    }
}