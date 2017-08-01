package Palindrome;

import java.util.HashMap;

/**
 * Created by Wang on 2017/4/19.
 */
public class sol_516 {
    public int longestPalindromeSubseq(String s) {
//        if (1 > s.length() || 2 == s.length() && s.charAt(0) == s.charAt(1))
//            return s.length();
//
//        // 1st letter and rest
//        int len1 = 1;
//        if (s.lastIndexOf(s.charAt(0)) != 0) {
//            len1 = 2 + longestPalindromeSubseq(s.substring(1, s.lastIndexOf(s.charAt(0))));
//        }
//        int len2 = longestPalindromeSubseq(s.substring(1));
//
//        return len1 > len2 ? len1 : len2;
        char[] strCh = s.toCharArray();
        int[][] mat = new int[s.length()][s.length()];
//        HashMap<Character, Integer> index = new HashMap<Character, Integer>();
        for (int i = s.length() - 1; i >= 0; i--) {
            mat[i][i] = 1;
                if (i > 0) {
                    mat[i-1][i] = strCh[i - 1] == strCh[i] ? 2 : 1;
                }

//            if (!index.containsKey(new Character(strCh[i]))) {
//                index.put(strCh[i], i);
//            }
        }
        for (int end = 2; end < s.length(); end++) {
            for (int st = end - 2; st >= 0; st--) {
                // if current char has shown before
//                int len1 = 1;
//                int idx = s.substring(st, end).indexOf(strCh[end]) + st;
//                if (idx >= st) {
//                    len1 = 2 + mat[idx + 1][end - 1];
//                }
//                // otherwise mat[st][end] = mat[st][end - 1]
//                mat[st][end] = len1 > mat[st][end - 1] ? len1 : mat[st][end - 1];
                if (strCh[st] == strCh[end]) {
                    mat[st][end] = 2 + mat[st + 1][end -1];
                } else {
                    mat[st][end] = mat[st + 1][end] > mat[st][end - 1] ? mat[st+ 1][end] : mat[st][end - 1];
                }
            }
        }

        return mat[0][s.length() - 1];
    }

//    public class Solution {
//        public int longestPalindromeSubseq(String s) {
//            int n=s.length();
//            int[][] a=new int[n][n];
//            for(int i=0;i<n;i++) {
//                a[i][i]=1;
//                if (i > 0) {
//                    a[i-1][i] = s.charAt(i)==s.charAt(i - 1) ? 2 : 1;
//                }
//            }
//            return helper(a,0,n-1,s);
//        }
//        private int helper(int[][] a,int i,int j,String s){
//            if(i>j || a[i][j]!=0) return a[i][j];
//            if(s.charAt(i)==s.charAt(j)) a[i][j]=helper(a,i+1,j-1,s)+2;
//            else a[i][j]=Math.max(helper(a,i,j-1,s),helper(a,i+1,j,s) );
//            return a[i][j];
//        }
//    }


}
