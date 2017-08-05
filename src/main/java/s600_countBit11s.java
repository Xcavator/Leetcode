import java.util.ArrayList;

public class s600_countBit11s {
    private int[] countTo8 = new int[] {1, 2, 3, 3, 4, 5, 5, 5, 6};

    public int findIntegers(int num) {
        if (num <= 8) return countTo8[num];
        int rest = num;
        int count = 0;
        int[] count4BitLen = new int[33];
        count4BitLen[0] = 2;
        count4BitLen[1] = 3;
        count4BitLen[2] = 4;
        int expo = 3;
        int pow = 8;
        while (rest >= pow) {
            count4BitLen[expo] = count4BitLen[expo - 2] + count4BitLen[expo - 1] - 1;
            expo++;
            pow <<=1;
        }
        while (rest > 8) {
            if (rest >= pow / 2) {
                count += count4BitLen[expo - 1] - 1;
                rest -= pow / 2;
                expo--;
                pow >>= 1;
                if (rest >= pow / 2) {
                    return count + count4BitLen[expo - 1] - 1;
                }
            }
            expo--;
            pow >>= 1;
        }

        return count + countTo8[rest];
    }
    public static void test() {
        s600_countBit11s tested = new s600_countBit11s();
        int single = 10000000;
        System.out.println(String.valueOf(single) + " : " + String.valueOf(tested.findIntegers(single)));
        for (int i = 32; i < 64; ++i) {
            System.out.println(String.valueOf(i) + " : " + String.valueOf(tested.findIntegers(i)));
        }
    }
}
