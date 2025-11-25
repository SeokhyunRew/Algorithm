import java.util.*;
class Solution {
    int[] answer = new int[5];
    public int[] solution(String[][] places) {
        for(int i=0; i<5; i++) answer[i] = 1;
    
        for(int i=0; i<5; i++){
            String[] place = places[i];
            char[][] room = new char[5][5];
            
            for(int j=0; j<5; j++){
                String row = place[j];
                for(int k=0; k<5; k++){
                    room[j][k] = row.charAt(k);
                }
            }
            
            dfs(i, room);
        }
        
        return answer;
    }
    
    private void dfs(int num, char[][] room){
        boolean isFalse = false;
        for(int i=0; i<5; i++){
            for(int j=0 ; j<5; j++){
                if(room[i][j]=='P'){
                    isFalse = method(room, i, j);
                    if(isFalse){
                        answer[num] = 0;
                        return;
                    }
                }
            }
        }
        return;
    }
    
    private boolean method(char[][] room, int x, int y){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX >= 0 &&
               newX < 5 &&
               newY >= 0 &&
               newY < 5){
               if(room[newX][newY]=='P') return true; 
            }
        }
        
        dx = new int[] {1, 1, -1, -1};
        dy = new int[] {-1, 1, 1, -1};
        
        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX >= 0 &&
               newX < 5 &&
               newY >= 0 &&
               newY < 5){
               if(room[newX][newY]=='P'){
                   if(room[x][newY]!='X' || room[newX][y]!='X') return true;
               }
            }
        }
        
        dx = new int[] {2, -2, 0, 0};
        dy = new int[] {0, 0, 2, -2};
        
        for(int i=0; i<4; i++){
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(newX >= 0 &&
               newX < 5 &&
               newY >= 0 &&
               newY < 5){
               if(room[newX][newY]=='P'){
                   if(room[x+dx[i]/2][y+dy[i]/2]!='X') return true;
               }
            }
        }
        
        return false;
    }
}