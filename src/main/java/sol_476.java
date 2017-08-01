/**
 * Created by Wang on 2017/3/8.
 */
public class sol_476 {
    public int findComplement(int num) {
        //https://my.oschina.net/xianggao/blog/412967
        //Opt: Use Integer.highestOneBit() for faster perf.
        int len = 0;
        if (num == 0) {
            return 1;
        }
        int temp = num;
        while(temp != 0) {
            temp >>>= 1;
            len += 1;
        }
        return ((~num) << (32 - len)) >>> (32 - len);

    }
    public int opt_sol(int num){
        return ~num + (Integer.highestOneBit(num) << 1);
    }
}
