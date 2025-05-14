class Solution {
    public String[] solution(String[] strArr) {
        String[] result = new String[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 == 0) {
                result[i] = strArr[i].toLowerCase();
            } else {
                result[i] = strArr[i].toUpperCase();
            }
        }

        return result;
    }
}
