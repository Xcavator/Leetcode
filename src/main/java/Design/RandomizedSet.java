package Design;

import java.util.HashMap;
import java.util.Random;

// Init an empty set.
//RandomizedSet randomSet = new RandomizedSet();
//
//// Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        randomSet.insert(1);
//
//// Returns false as 2 does not exist in the set.
//        randomSet.remove(2);
//
//// Inserts 2 to the set, returns true. Set now contains [1,2].
//        randomSet.insert(2);
//
//// getRandom should return either 1 or 2 randomly.
//        randomSet.getRandom();
//
//// Removes 1 from the set, returns true. Set now contains [2].
//        randomSet.remove(1);
//
//// 2 was already in the set, so return false.
//        randomSet.insert(2);
//
//// Since 2 is the only number in the set, getRandom always return 2.
//        randomSet.getRandom();
public class RandomizedSet {
    HashMap<Integer, Integer> num2idx;
    int count;
    Random rand;
    HashMap<Integer, Integer> idxedNum; // Use ArrayList instead ?

    /** Initialize your data structure here. */
    public RandomizedSet() {
        num2idx = new HashMap<Integer, Integer>();
        count = 0;
        idxedNum = new HashMap<Integer, Integer>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (num2idx.containsKey(val)) {
            return false;
        } else {
            num2idx.put(val, count);
            idxedNum.put(count++, val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (num2idx.containsKey(val)) {
            int last = idxedNum.get(--count);
            num2idx.put(last, num2idx.get(val));
            idxedNum.put(num2idx.get(val), last);
            num2idx.remove(val);
            if (count >= 0) idxedNum.remove(count);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (count == 0) return 0;
        if (count == 1) return idxedNum.get(0);
        return idxedNum.get(rand.nextInt(count));
    }

    public static void test() {
        RandomizedSet tested = new RandomizedSet();
        System.out.println(tested.getRandom());
        tested.insert(4);
        tested.insert(4);

        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());

        tested.insert(6);
        tested.insert(8);
        tested.insert(13);

        System.out.println(tested.num2idx.keySet());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        tested.remove(1);
        tested.remove(6);

        System.out.println(tested.num2idx.keySet());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        System.out.println(tested.getRandom());
        tested.remove(8);
        tested.remove(13);
        tested.remove(4);
        tested.remove(0);
        System.out.println(tested.getRandom());

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
