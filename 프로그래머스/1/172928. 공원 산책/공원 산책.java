class Solution {
    public int[] solution(String[] park, String[] routes) {
        String[] temp;
        String vector;
        int num;
        int[] keep;
        int[][] can_Visit = new int[park.length][park[0].length()];
        int[] start_Point = new int[2];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if(park[i].charAt(j) == 'O'){
                    can_Visit[i][j] = 1;
                }else if(park[i].charAt(j) == 'X'){
                    can_Visit[i][j] = 0;
                }else if(park[i].charAt(j) == 'S'){
                    can_Visit[i][j] = 1;
                    start_Point[0] = i;
                    start_Point[1] = j;
                }
            }
        }

        for (String str : routes) {
            temp = str.split(" ");
            vector = temp[0];
            num = Integer.parseInt(temp[1]);
            keep = change(vector, num);
            if(isValid(start_Point, keep, can_Visit)){
                start_Point[0] = start_Point[0] + keep[0];
                start_Point[1] = start_Point[1] + keep[1];
            }
        }
        return start_Point;
    }

    static boolean isValid(int[] start_Point, int[] keep, int[][] can_Visited){
        int[] valid = new int[2];
        valid[0] = start_Point[0] + keep[0];
        valid[1] = start_Point[1] + keep[1];
        if(valid[0] >=0 && valid[1] >= 0 && valid[0] < can_Visited.length && valid[1] < can_Visited[0].length){
            if(keep[0] == 0){
                if(keep[1] >0){
                    for (int i = 1; i <= keep[1]; i++) {
                        if(can_Visited[start_Point[0]][start_Point[1]+i] == 1){
                            continue;
                        }else{
                            return false;
                        }
                    }
                    return true;
                }else{
                    for (int i = -1; i >= keep[1]; i--) {
                        if(can_Visited[start_Point[0]][start_Point[1]+i] == 1){
                            continue;
                        }else{
                            return false;
                        }
                    }
                    return true;
                }
            }else{
                if(keep[0] >0){
                    for (int i = 1; i <= keep[0]; i++) {
                        if(can_Visited[start_Point[0]+i][start_Point[1]] == 1){
                            continue;
                        }else{
                            return false;
                        }
                    }
                    return true;
                }else{
                    for (int i = -1; i >= keep[0]; i--) {
                        if(can_Visited[start_Point[0]+i][start_Point[1]] == 1){
                            continue;
                        }else{
                            return false;
                        }
                    }
                    return true;
                }
            }
        }else {
            return false;
        }
    }

    static int[] change(String vector, int num) {
        int[] go = new int[2];

        if (vector.equals("E")) {
            go[0] = 0;
            go[1] = num;
        } else if (vector.equals("W")) {
            go[0] = 0;
            go[1] = -num;
        } else if (vector.equals("N")) {
            go[0] = -num;
            go[1] = 0;
        } else if (vector.equals("S")) {
            go[0] = num;
            go[1] = 0;
        }
        return go;
    }
}