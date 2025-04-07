import java.util.Scanner;

public class Main {
    static char[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        board = new char[N][N];

        // 먼저 공백으로 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = ' ';
            }
        }

        drawStar(0, 0, N);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }

    // 재귀 함수
    static void drawStar(int x, int y, int size) {
        if (size == 1) {
            board[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                if (dx == 1 && dy == 1) {
                    // 가운데는 비움
                    continue;
                }
                drawStar(x + dx * newSize, y + dy * newSize, newSize);
            }
        }
    }
}
