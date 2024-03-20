class Solution {
    public String solution(String s) {
            s = "1 " + s +" 1";
        String[] parts = s.toLowerCase().split(" ");
        StringBuilder answer = new StringBuilder();
        String temp;

        for (int i = 0; i < parts.length; i++) {
            if(parts[i].equals("")){
                answer.append(" ");
                continue;
            }
            temp = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1,parts[i].length());
            if(i == parts.length-1){
                answer.append(temp);
                break;
            }

            answer.append(temp+" ");
        }
        return answer.toString().substring(2, answer.length()-2);
    }
}