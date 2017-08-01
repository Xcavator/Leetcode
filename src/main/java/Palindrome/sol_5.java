package Palindrome;

/**
 * Created by Wang on 2017/4/24.
 */
public class sol_5 {
    private int maxLen = 1;
    private int maxSt = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        char[] chrS = s.toCharArray();
        for (int i = 1; i < len - maxLen / 2; i++) {
            extend(chrS, i - 1, i);
            extend(chrS, i, i);
        }
        return s.substring(maxSt, maxSt + maxLen);
    }

    private int extend(char[] chrS, int st_l, int st_r) {

        for (int i = 0; i <= st_l; i++) {
            if (chrS[st_l - i] == chrS[st_r + i]) {
                if (2 * i + st_r - st_l + 1 > maxLen) {
                    maxLen = 2 * i + st_r - st_l + 1;
                    maxSt = st_l - i;
                }
            } else {
                break;
            }
        }
        return 0;
    }

}
// // Dp solution
//private int maxLen = 1;
//private int maxSt = 0;
//    public String longestPalindrome(String s) {
//        // dp
//        int len = s.length();
//        if (len < 2){
//            return s;
//        }
//        char[] chrS = s.toCharArray();
//        // pal[st][end] = 1 if s[st..end] is palindrome, 2 if not
//        int[][] pal = new int[len][len];
//        for (int i = len - 1; i >= 0; --i) {
//            pal[i][i] = 1;
//            if (i > 0) {
//                if (s.charAt(i) == s.charAt(i - 1)) {
//                    pal[i - 1][i] = 1;
//                    maxLen = 2;
//                    maxSt = i - 1;
//                } else {
//                    pal[i - 1][i] = 2;
//                }
//            }
//        }
//        helper(pal, 0, len - 1, chrS);
//        return s.substring(maxSt, maxSt + maxLen);
//    }
//
//    private int helper(int[][] pal, int st, int end, char[] s) {
//        if (pal[st][end] != 0 || st >= end) {
//            return pal[st][end];
//        } else {
//            if (s[st] == s[end]
//                    && helper(pal, st + 1, end - 1, s) == 1) {
//                pal[st][end] = 1;
//                if (end + 1 - st > maxLen) {
//                    maxLen = end + 1 - st;
//                    maxSt = st;
//                }
//                return 1;
//            } else {
//                pal[st][end] = 2;
//                if (end - st >= maxLen) {
//                    helper(pal, st, end - 1, s);
//                    helper(pal, st + 1, end, s);
//                }
//                return 2;
//            }
//        }
//    }