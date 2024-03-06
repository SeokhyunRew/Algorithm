import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] computers) {
        //Floyd-Warshall algorithm
        int answer = 0;
        int[][] linknode = new int[n][n];
        int[] temp;
        ArrayList<Integer> keep = new ArrayList<>();
        int count=0;

        for (int i = 0; i < n; i++) {
            temp = computers[i];
            for (int j = 0; j < n; j++) {
                linknode[i][j] = temp[j];
            }
        }
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (linknode[i][k] == 1 && linknode[k][j] == 1) {
                        linknode[i][j] = 1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            keep.add(i);
        }

        for (int i = 0; i < n; i++) {
            if(!keep.contains(i+1)){
                continue;
            }
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }
                if(linknode[i][j]==1){
                    if(keep.contains(i+1)){
                        keep.remove(Integer.valueOf(i+1));
                    }
                    if(keep.contains(j+1)){
                        keep.remove(Integer.valueOf(j+1));
                    }
                }
            }
            count++;
        }

        return count;
        
        }
    }