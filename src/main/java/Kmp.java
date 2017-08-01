/**
 * Created by Wang on 2017/4/23.
 */
public class Kmp {
    public int kmpAlgo(String pat, String str) {
        int lenPat = pat.length();
        int lenStr = str.length();
        if (lenPat > lenStr)
            return -1;
        if (lenPat == 0)
            return 0;
        char[] chrStr= str.toCharArray();
        char[] chrPat = pat.toCharArray();
        if (lenPat == 1) {
            int idx = 0;
            while(idx < lenStr) {
                if (chrStr[idx++] == chrPat[0])
                    return idx - 1;
            }
            return -1;
        }
        // Setup next postion array
        int[] next = new int[pat.length()];
        int i = 2;
        next[0] = -1;
        next[1] = 0;
        int j = 0;
        
        while (i < lenPat) {
            if (chrPat[i - 1] == chrPat[j]) {
                // Case 1: prefix continues
                next[i++] = j + 1;
                j++;
            } else if(j > 0) {
                // Case 2: prefix not match
                j = next[j];
            } else {
                // Case 3: No more possible prefix
                next[i++] = 0;
            }
        }

        // Search
        int st = 0;
        int last = lenStr - lenPat;
        i = 0; // Index in pattern string
        while(st + lenPat <= lenStr) {
            if (chrPat[i] == chrStr[st + i]) {
                i++;
                if (i == lenPat)
                    return st;
            } else if (next[i] != -1) {
                st = st + i - next[i];
                i = next[i];
            } else {
                st += 1;
                i = 0;
            }
        }
        return -1;
    }
}
