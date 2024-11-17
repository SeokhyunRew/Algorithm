import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        // BigInteger 사용
        BigInteger answer = BigInteger.ONE;

        // 조합 계산 (분자와 분모를 동시에 계산)
        for (int i = 0; i < share; i++) {
            answer = answer.multiply(BigInteger.valueOf(balls - i))
                           .divide(BigInteger.valueOf(i + 1));
        }

        return answer.intValue(); // 결과를 int로 반환
    }
}