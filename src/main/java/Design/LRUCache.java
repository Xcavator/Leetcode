package Design;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;

/**
 * Created by Wong on 8/4/2017.
 *
 * Solution for Leetcode problem ID: 146
 */
public class LRUCache {
    HashMap<Integer, Integer> hm;
    int[][] dl;
    int next;
    public LRUCache(int capacity) {
        this.hm = new HashMap<>();
        this.dl = new int[capacity][4];
        if (capacity > 1) {
            this.dl[0][0] = capacity - 1;
            this.dl[0][1] = 1;
            this.dl[0][2] = -1;
            for (int i = 1; i < capacity - 1; i++) {
                this.dl[i][0] = i - 1;
                this.dl[i][1] = i + 1;
                this.dl[i][2] = -1;
            }
            this.dl[capacity - 1][0] = capacity - 2;
            this.dl[capacity - 1][1] = 0;
            this.dl[capacity - 1][2] = -1;
        } else {
            this.dl[0][2] = -1;
        }
        this.next = 0;
    }

    public int get(int key) {
        if (this.hm.containsKey(key)) {
            int idx = this.hm.get(key);
            renewNext(idx);
            return this.dl[idx][2];
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (this.hm.containsKey(key)) {
            int idx = this.hm.get(key);
            this.dl[idx][2] = value;
            renewNext(idx);
        } else {
            if (this.dl[this.next][2] >= 0) {
                this.hm.remove(this.dl[this.next][3]);
            }
            this.hm.put(key, this.next);
            this.dl[this.next][2] = value;
            this.dl[this.next][3] = key;
            this.next = this.dl[next][1];
        }
    }

    private void renewNext(int idx) {
        if (idx == this.next) {
            this.next = this.dl[this.next][1];
        } else {
            this.dl[this.dl[idx][0]][1] = this.dl[idx][1];
            this.dl[this.dl[idx][1]][0] = this.dl[idx][0];
            this.dl[idx][0] = this.dl[this.next][0];
            this.dl[idx][1] = this.next;
            this.dl[this.next][0] = idx;
            this.dl[this.dl[idx][0]][1] = idx;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
