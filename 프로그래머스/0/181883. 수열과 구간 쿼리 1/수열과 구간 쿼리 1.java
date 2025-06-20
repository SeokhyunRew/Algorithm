class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        // arr을 복사하여 결과 배열 생성
        int[] answer = arr.clone();
        
        // 각 쿼리를 순서대로 처리
        for (int[] query : queries) {
            int s = query[0];  // 시작 인덱스
            int e = query[1];  // 끝 인덱스
            
            // s부터 e까지의 범위에 있는 모든 원소에 1을 더함
            for (int i = s; i <= e; i++) {
                answer[i] += 1;
            }
        }
        
        return answer;
    }
}