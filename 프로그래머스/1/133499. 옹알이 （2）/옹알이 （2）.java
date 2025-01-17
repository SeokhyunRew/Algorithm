class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] dictionary = {"aya", "ye", "woo", "ma"};
        char beforeC;
        boolean temp;
        
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<dictionary.length; j++){
                babbling[i] = babbling[i].replaceAll(dictionary[j], String.valueOf(j));
            }
        }
        
        for(int i=0; i<babbling.length; i++){
            
            try{
                Integer.parseInt(babbling[i]);
            }catch(Exception e){
                continue;
            }
            
            beforeC = 'c';
            temp = true;
            
            for(char c : babbling[i].toCharArray()){
                if(c==beforeC) temp = false;
                beforeC = c;
            }
            
            if(temp) answer++;
        }
        
        return answer;
    }
}