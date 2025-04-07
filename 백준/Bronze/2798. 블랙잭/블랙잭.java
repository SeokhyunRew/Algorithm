import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 카드 개수
        int M = sc.nextInt(); // 목표 숫자

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = sc.nextInt(); // 카드 숫자 입력
        }

        int max = 0;

        // 모든 3장의 조합을 확인
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = cards[i] + cards[j] + cards[k];

                    // M 이하이고, 최대값이면 갱신
                    if (sum <= M && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
