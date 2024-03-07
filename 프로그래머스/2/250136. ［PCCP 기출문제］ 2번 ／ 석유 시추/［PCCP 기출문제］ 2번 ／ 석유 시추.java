import java.util.*;
class Solution {
    public int solution(int[][] land) {
        HashMap<Integer, Integer> get_oil = new HashMap<>();
        int rows = land.length;
        int cols = land[0].length;

        //방문 포인트 체크할 2차원 배열 생성
        boolean[][] visited = new boolean[rows][cols];
        //방문해야 하는 point들 담으려고 queue 생성
        Queue<Point> queue = new LinkedList<>();

        for (int startRow = 0; startRow < rows; startRow++) {
            for (int startCol = 0; startCol < cols; startCol++) {
                if (visited[startRow][startCol] || land[startRow][startCol]==0) {
                    continue;
                }
                //한 석류 덩이를 체크하기 위해서 담을 List선언
                List<Point> bfsResult = new ArrayList<>();
                //우선 큐에 시작점 담음
                queue.add(new Point(startRow, startCol));
                //해당 point 방문했다고 표시
                visited[startRow][startCol] = true;
                //결과 담음...
                bfsResult.add(new Point(startRow, startCol));

                //인접한 point담은 큐가 다 빌때까지 반복 > while문 끝나면 이어진 한 석류덩이를 다 찾았다는 의미
                while (!queue.isEmpty()) {
                    //큐에있는 포인트 꺼내서 확인하려고 point 객체에 담음
                    Point currentPoint = queue.poll();
                    //꺼낸 point의 row 위치
                    int row = currentPoint.row;
                    //꺼낸 point의 column 위치
                    int col = currentPoint.col;

                    // Check adjacent cells
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            // 상하좌우만 확인하도록 수정
                            if ((i != 0 && j != 0)||(i==0 && j==0)) {
                                continue;
                            }
                            //방문 시작 포인트 기점으로 왼,현재,오른쪽 row선택
                            int newRow = row + i;
                            //방문 시작 호인트 기점으로 위,현재,아래 col선택
                            int newCol = col + j;
                            //방문 시작 포인트 기점으로 둘러쌓는 지역이 선택 가능한지 + 이미 방문한 지역은 다시 선택 x
                            if (isValid(rows, cols, newRow, newCol) && !visited[newRow][newCol] && land[newRow][newCol]==1) {
                                //가능하면 같은 석유 덩어리 지역이라고 판단하고 queue에 추가후 탐색
                                queue.add(new Point(newRow, newCol));
                                visited[newRow][newCol] = true;
                                bfsResult.add(new Point(newRow, newCol));
                            }
                        }
                    }
                }

                // 한덩이에서 나온 <col,총 석유덩이>를 hashmap에(temp)에 넣어줌(중복 없이 기록)
                int resultSize = bfsResult.size();
                HashMap<Integer, Integer> temp = new HashMap<>();
                for (int i = 0; i < resultSize; i++) {
                    int currentCol = bfsResult.get(i).col;
                    //같은 석류 덩이를 담아논 bfsResult List에서 한 포인트씩 꺼내서 col을 키값으로 넣음
                    temp.put(currentCol, resultSize);
                }
                // 한 석유 사이클의 정보를 담고있는 temp를 get_oil에 누적해서 더해줌
                for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();

                    get_oil.put(key, get_oil.getOrDefault(key, 0) + value);
                }
            }
        }
        int maxValue=0;

        for (Map.Entry<Integer, Integer> entry : get_oil.entrySet()) {
            if (maxValue < entry.getValue()) {
                maxValue = entry.getValue();
            }
        }

       return maxValue;
    }
    //2차원 배열에서 각각의 칸을 행열로 가공
    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    //해당 칸이 만든 2차원 배열의 범위를 벗어나는지(index error 나는 것을 대비)
    static boolean isValid(int rows, int cols, int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

}