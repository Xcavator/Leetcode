package Theorem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Wang on 2017/7/5.
 *
 * Solution to 294 Flip Game II
 */
public class SpragueGrundy {
    // Sprague Grundy theorem
    // https://brilliant.org/wiki/sprague-grundy-theorem/
    public boolean canWin(String s) {
        int max = 0, count = 0;
        List<Integer> consecutivePlus = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+')
                count++;
            if (i == s.length() - 1 || s.charAt(i) == '-') {
                if (count >= 2)
                    consecutivePlus.add(count);
                max = Math.max(max, count);
                count = 0;
            }
        }
        int[] dp = new int[max + 1];
        for (int len = 2; len <= max; len++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < len / 2; i++)
                set.add(dp[i] ^ dp[len - i - 2]);
            int res = grundy(set);
            dp[len] = res;
        }
        int result = 0;
        for (Integer x : consecutivePlus)
            result ^= dp[x];
        return result != 0;
    }
    public int grundy(Set<Integer> set) {
        int g = 0;
        while (set.contains(g))
            g++;
        return g;

    }
}
