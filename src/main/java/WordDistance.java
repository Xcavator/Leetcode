import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Wang on 2017/6/29.
 * Solution to 244
 */
public class WordDistance {
    HashMap<String, List<Integer>> idx;
    public WordDistance(String[] words) {
        idx = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; ++i) {
            if (!idx.containsKey(words[i])) {
                idx.put(words[i], new ArrayList<Integer>());
            }
            idx.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> pos1 = idx.get(word1);
        List<Integer> pos2 = idx.get(word2);
        int i = 0, j = 0;
        int size1 = pos1.size(), size2 = pos2.size();
        while (i < size1 && j < size2) {
            if (pos1.get(i) < pos2.get(j)) {
                min = Math.min(pos2.get(j) - pos1.get(i++), min);
            } else { // case of equal not exists
                min = Math.min(pos1.get(i) - pos2.get(j++), min);
            }
        }
        return min;
    }


}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */