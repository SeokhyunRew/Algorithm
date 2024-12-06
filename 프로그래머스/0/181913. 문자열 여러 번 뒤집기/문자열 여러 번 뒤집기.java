class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder answer = new StringBuilder(my_string);
        String str;
        
        for(int i=0; i<queries.length; i++){ 
            str = answer.substring(queries[i][0],queries[i][1]+1);
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            answer = answer.replace(queries[i][0],queries[i][1]+1,sb.toString());
        }
        
        return answer.toString();
    }
}