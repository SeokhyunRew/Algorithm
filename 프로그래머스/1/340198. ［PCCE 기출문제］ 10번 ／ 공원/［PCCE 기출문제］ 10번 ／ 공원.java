class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        boolean check = true;
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length; j++){
                if(park[i][j].equals("-1")){
                    for(int k=0; k<mats.length; k++){
                        check=true;
                        
                        if(mats[k]<=answer) continue;
                        if(i+mats[k]>park.length||j+mats[k]>park[0].length) continue;
                        
                        for(int h=0; h<mats[k]; h++){
                            for(int l=0; l<mats[k]; l++){
                                if(!park[i+h][j+l].equals("-1")){
                                    check=false;
                                    break;
                                }      
                            } 
                            if(!check) break;
                        }
                        if(check) answer=mats[k];
                    }
                }
            }
        }
        
        return (answer==0)?-1:answer;
    }
}