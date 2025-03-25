class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        char[] ch_array = s.toCharArray();
        char ch_temp;

        for (int i = 0; i < s.length(); i++) {
            ch_temp = ch_array[i];

            for (int j = 0; j < index; ) {
                ch_temp++;
                if (ch_temp > 'z') ch_temp = (char) (ch_temp-'z'+'a'-1);
                if (skip.contains(String.valueOf(ch_temp))) continue;
                j++;
            }

            sb.append(ch_temp);
        }

        return sb.toString();
    }
}
