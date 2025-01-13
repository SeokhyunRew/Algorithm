class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ' ') { 
                if (Character.isLowerCase(c)) { 
                    if (c + n > 'z') {
                        c = (char) ('a' + (c + n - 'z' - 1)); 
                    } else {
                        c += n;
                    }
                } else { 
                    if (c + n > 'Z') {
                        c = (char) ('A' + (c + n - 'Z' - 1)); 
                    } else {
                        c += n;
                    }
                }
            }
            answer.append(c); 
        }

        return answer.toString();
    }
}
