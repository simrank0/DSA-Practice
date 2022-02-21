package DP;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        if(s==null || s.length()<2) return 0;
        int l = 0, r = 0, max = 0;
        for(char i : s.toCharArray()){
            if(i==')'){
                r++;
            }else{
                l++;
            }
            if(l==r){
                max = Math.max(max, l<<1);
            }else if(r>l){
                l = r = 0;
            }
        }
        l = r = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i)=='('){
                l++;
            }else{
                r++;
            }
            if(l==r){
                max = Math.max(max, l<<1);
            }else if(l>=r){
                l = r = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }
}
