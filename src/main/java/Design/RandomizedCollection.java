package Design;

import java.util.*;

public class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> num2idx;
    ArrayList<Integer> idxedNum;
    Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.num2idx = new HashMap<Integer, HashSet<Integer>>();
        this.idxedNum = new ArrayList();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!num2idx.containsKey(val)) {
            this.num2idx.put(val, new HashSet<>());
            this.num2idx.get(val).add(this.idxedNum.size());
            this.idxedNum.add(val);
            return true;
        } else {
            this.num2idx.get(val).add(this.idxedNum.size());
            this.idxedNum.add(val);
            return false;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (this.num2idx.containsKey(val)) {
            int last = this.idxedNum.get(this.idxedNum.size() - 1);
            HashSet<Integer> validx = this.num2idx.get(val);
            if (last == val) {
                this.idxedNum.remove(this.idxedNum.size() - 1);
                validx.remove(this.idxedNum.size());
            } else {
                int rmidx = validx.iterator().next();
                this.idxedNum.remove(this.idxedNum.size() - 1);
                this.num2idx.get(last).remove(this.idxedNum.size());
                this.num2idx.get(last).add(rmidx);
                validx.remove(rmidx);
                this.idxedNum.set(rmidx, last);
            }
            if (validx.isEmpty())
                this.num2idx.remove(val);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return this.idxedNum.get(this.rand.nextInt(this.idxedNum.size()));
    }
}