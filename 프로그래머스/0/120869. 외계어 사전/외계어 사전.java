class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        StringBuilder sb = new StringBuilder();
        String spell_answer = "";
        
        for(String str : spell){
            spell_answer += str;
        }
        
        
        for(String str_dic : dic){
            sb.setLength(0);
            for(String str_spell : spell){
                if(str_dic.contains(str_spell)){
                    str_dic = str_dic.replaceFirst(str_spell, "");
                    sb.append(str_spell);
                }
            }
            if(str_dic.isEmpty()&&sb.toString().equals(spell_answer)) return 1;
        }
        
        return answer;
    }
}