import java.util.Scanner;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // 10815 숫자 카드
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for (int i = 0; i < M; i++) {
            arr2[i] = sc.nextInt();
        }

        // N: 내가 갖고있는 개수, arr1: 내가 갖고있느 원소 배열
        // M: 비교할 입력 원소 개수, arr2: 입력 배열
        // 필요한 코드 작성
        for(int temp: arr2){
            if(set.contains(temp)){
                System.out.println("1");
            } else{
                System.out.println("0");
            }
        }

    }
}