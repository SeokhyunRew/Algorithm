import java.util.*;

class Solution {
    long answer = 0;
    char[] operators = {'+', '-', '*'};
    boolean[] visited = new boolean[3];
    
    public long solution(String expression) {
        // 숫자 배열 추출
        List<Long> numbers = new ArrayList<>();
        StringBuilder num = new StringBuilder();
        
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                num.append(c);
            } else {
                numbers.add(Long.parseLong(num.toString()));
                num = new StringBuilder();
            }
        }
        numbers.add(Long.parseLong(num.toString())); // 마지막 숫자
        
        // 연산자 배열 추출
        List<Character> ops = new ArrayList<>();
        for (char c : expression.toCharArray()) {
            if (!Character.isDigit(c)) {
                ops.add(c);
            }
        }
        
        dfs(numbers, ops, 0);
        
        return answer;
    }
    
    private void dfs(List<Long> numbers, List<Character> ops, int depth) {
        // 모든 연산자 우선순위를 정했을 때
        if (depth == 3) {
            // 연산자가 남아있으면 계산
            if (!numbers.isEmpty()) {
                answer = Math.max(answer, Math.abs(numbers.get(0)));
            }
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            if (visited[i]) continue;
            
            char currentOp = operators[i];
            
            // 현재 연산자가 수식에 없으면 스킵
            if (!ops.contains(currentOp)) {
                visited[i] = true;
                dfs(numbers, ops, depth + 1);
                visited[i] = false;
                continue;
            }
            
            visited[i] = true;
            
            // 현재 우선순위 연산자로 계산
            List<Long> newNumbers = new ArrayList<>();
            List<Character> newOps = new ArrayList<>();
            
            newNumbers.add(numbers.get(0));
            
            for (int j = 0; j < ops.size(); j++) {
                if (ops.get(j) == currentOp) {
                    // 계산 수행
                    long prev = newNumbers.remove(newNumbers.size() - 1);
                    long next = numbers.get(j + 1);
                    long result = 0;
                    
                    if (currentOp == '+') {
                        result = prev + next;
                    } else if (currentOp == '-') {
                        result = prev - next;
                    } else if (currentOp == '*') {
                        result = prev * next;
                    }
                    
                    newNumbers.add(result);
                } else {
                    // 다른 연산자는 그대로 유지
                    newNumbers.add(numbers.get(j + 1));
                    newOps.add(ops.get(j));
                }
            }
            
            dfs(newNumbers, newOps, depth + 1);
            visited[i] = false;
        }
    }
}