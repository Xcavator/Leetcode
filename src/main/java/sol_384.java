/**
 * Created by Wang on 2017/5/10.
 */
public class sol_384 {
    int[] orig;
    int[] cur;
    public sol_384(int[] nums) {
        orig = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        cur = orig;
        return cur;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = orig.length;
        for (int i = len - 1; i > 0; i--) {
            
        }
        return cur;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */