class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (((x1||x2)?true:false)&&(x3||x4?true:false))?true:false;
    }
}