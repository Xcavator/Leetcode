import java.util.*;

/**
 * Created by Wang on 2017/4/8.
 */
public class sol_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        //Store results in a map
        HashMap<String, List<String>> dict = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] str_ch = str.toCharArray();
            Arrays.sort(str_ch);
            String str_sorted = new String(str_ch);

//            dict.get(str_sorted).add(str);

            if (dict.get(str_sorted) == null) {
                dict.put(str_sorted, new ArrayList(Arrays.asList(str)));
            } else {
                dict.get(str_sorted).add(str);
            }
        }
        return new ArrayList(dict.values());
    }
}
