package Palindrome;

/**
 * Created by Wang on 2017/4/21.
 */
public class sol_214 {

    public String shortestPalindrome(String s) {
        if (s.length() < 2)
            return s;
        int len = s.length();
        int end = len - 1;
        char[] strCh = s.toCharArray();
        int st = 0;
        StringBuilder res = new StringBuilder();
        while(true) {
            st = 0;
            int ed = (end -1 ) / 2;
            int i = end;
            for (; i > st; i--) {
                if (strCh[i] == strCh[st]) {
                    st++;
                }
            }

            if (st > ed && ((i == st) || (st * 2 == end + 1)))
                break;
            if (i == st) {
                end = st * 2;
            } else {
                end = st * 2 - 1;
            }
        }
        res.append(s.substring(end + 1, s.length())).reverse().append(s);
        return res.toString();
    }
}


/*
#1 Elegent solution
public String shortestPalindrome(String s){
if (s.length() < 2)
return s;
int n=s.length();
int end = n - 1;
String rStr = new StringBuilder(s).reverse().toString();
for (end = n; end > 0; end--) {

if (s.startsWith(rStr.substring(n - end, n)))
break;

}
return rStr.substring(0, n - end) + s;
}
*/

////Fastest
//
//public class Solution {
//    public String shortestPalindrome(String s) {
//        StringBuilder res = new StringBuilder();
//        char[] strCh = s.toCharArray();
//        int j=0, end = s.length();
//        while(true){
//            j=0;
//            for(int i=end-1;i>=0;i--){
//                if(strCh[i] == strCh[j]) j++;
//            }
//            if(j==end)
//                break;
//            end = j;
//        }
//        res.append(s.substring(end, s.length())).reverse().append(s);
//        return res.toString();
//    }
//}
