class Solution {
    public String solution(String rsp) {
        StringBuilder answer = new StringBuilder();

        for (char ch : rsp.toCharArray()) {
            switch (ch) {
                case '2':
                    answer.append("0");
                    break;
                case '0':
                    answer.append("5");
                    break;
                case '5':
                    answer.append("2");
                    break;
            }
        }
        return answer.toString();
    }
}