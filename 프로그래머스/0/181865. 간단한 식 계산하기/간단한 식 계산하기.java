class Solution {
    public int solution(String binomial) {
        String[] tokens = binomial.split(" ");
        int a = Integer.parseInt(tokens[0]);
        String op = tokens[1];
        int b = Integer.parseInt(tokens[2]);
        
        int result = 0;
        
        if (op.equals("+")) {
            result = a + b;
        } else if (op.equals("-")) {
            result = a - b;
        } else if (op.equals("*")) {
            result = a * b;
        }
        
        return result;
    }
}
