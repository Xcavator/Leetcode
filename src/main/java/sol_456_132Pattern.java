import java.util.*;

/**
 * Created by Wang on 2017/7/14.
 * https://leetcode.com/problems/132-pattern/#/description
 */
public class sol_456_132Pattern {
    public boolean find132pattern(int[] nums) {

//        int idx1, idx2, idx3, nextidx1, idx;
//        int len = nums.length;
//        if (len < 3) return false;
//        for (idx = 0; idx < len - 2 && nums[idx] >= nums[idx + 1]; idx++);
//        if (idx > len - 3) return false;
//        idx1 = idx;
//        idx2 = idx + 1;
//        nextidx1 = 0;
//        for (idx += 2; idx < len || nextidx1 != 0; ++idx) {
//            if (idx == len) {
//                idx1 = nextidx1;
//                idx2 = idx1 + 1;
//                nextidx1 = 0;
//                idx = idx1 + 2;
//                continue;
//            }
//            if (nums[idx] < nums[idx1] && 0 == nextidx1) {
//                while (idx < len - 2 && nums[idx] >= nums[idx + 1]) idx++;
//                nextidx1 = idx;
//            } else if (nums[idx] > nums[idx2]) {
//                idx2 = idx;
//                if (nextidx1 != 0) {
//                    idx1 = nextidx1;
//                    nextidx1 = 0;
//                }
//            } else if (nums[idx] > nums[idx1] && nums[idx] < nums[idx2]) {
//                return true;
//            }
//        }



//        int len = nums.length;
//        if (len < 3) return false;
////        Deque<Integer> maxs = new ArrayDeque<>();
////        Deque<Integer> mins = new ArrayDeque<>();
//        List<Integer> maxs = new ArrayList<>();
//        List<Integer> mins = new ArrayList<>();
//        int idx = 0;
//        boolean asc;
//        while (idx < len - 3 && nums[idx] == nums[idx + 1]) idx++;
//        if (nums[idx] < nums[idx + 1]) {
//            asc = true;
//            mins.add(0);
//        } else {
//            asc = false;
//        }
//        for (idx++; idx < len - 1; ++idx) {
//            int temp = idx;
//            while (idx < len - 1 && nums[idx] == nums[idx + 1]) idx++;
//            if (asc && nums[idx] > nums[idx + 1]) {
//                maxs.add(temp);
//                asc = false;
//            } else if (!asc && nums[idx] < nums[idx + 1]) {
//                mins.add(temp);
//                asc = true;
//            }
//        }
//        int max1 = maxs.get(0);
//        int min1 = mins.get(0);


        int[] arr = Arrays.copyOf(nums, nums.length);

        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) continue;
            while (top < nums.length && arr[top] <= arr[j]) top++;
            if (top < nums.length && nums[j] > arr[top]) return true;
            arr[--top] = nums[j];
        }



        return false;
    }
}
