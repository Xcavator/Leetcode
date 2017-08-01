import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wang on 2017/6/7.
 */
public class sol_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (nums.length < 2) {
            if (nums.length == 0) {
                return ret;
            } else {
                ret.add(new ArrayList<Integer>(Arrays.asList(nums[0])));
                return ret;
            }

        }
        Integer[] nums_i = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums_i[i] = nums[i];
        }
        //create sorted list
        Arrays.sort(nums_i);
        ret.add(Arrays.asList(Arrays.copyOf(nums_i, nums_i.length)));
        //generate permutes based on dict order
        while(genNext(nums_i) ) {
            ret.add(Arrays.asList(Arrays.copyOf(nums_i, nums_i.length)));
        }
        return ret;

    }

    public boolean genNext(Integer[] nums) {
        int max = nums.length - 1;
        int swap = 0;
        while (max != 0 && nums[max] <= nums[max - 1]) max--;
        if (max == 0) return false;
        swap = max - 1;
        for (max = nums.length - 1; nums[max] <= nums[swap]; max--);
        Integer t = nums[swap];
        nums[swap] = nums[max];
        nums[max] = t;
        // Reverse
        int i = swap + 1;
        for (int j = nums.length - 1; i < j; --j, ++i) {
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }

        return true;
    }
}
