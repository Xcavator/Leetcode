/**
 * Created by Wang on 2017/6/10.
 */
public class sol_273 {
    String[] words = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int[] digits = new int[4];
//        String[] trans = new String[4];
        for (int i = 3; i >= 0; i--) {
            digits[i] = num % 1000;
            num /= 1000;
        }
        String ret = "";
        for (int i = 0; i < 3; ++i) {
            if (digits[i] > 0) {
                if (!ret.isEmpty())
                    ret += " ";
                ret += hundredsToW(digits[i]);
                ret += " " + words[31 - i];
            }
        }
        if (digits[3] > 0) {
            ret += ret.isEmpty() ? hundredsToW(digits[3]) : " " + hundredsToW(digits[3]);
        }
//        String ret = digits[0] > 0 ? hundredsToW(digits[0]) + " Billion" : "";
//        for (int i = 1; i < 3; i++) {
//            if (digits[i] > 0) {
//                ret += num > digits[i]
//                        ? hundredsToW(digits[i]) + " " + words[30 - i]
//                        : " " + hundredsToW(digits[i]) + " " + words[30 - i];
//            }
//        }
//        if (digits[3] > 0) {
//            ret += digits[2] == 0 ? hundredsToW(digits[3])
//        }
        return ret;
    }

    String hundredsToW(int num) {
        int tens = num % 100;
        String tensStr = "";

        if (tens < 20) {
            tensStr = words[tens];
        } else {
            tensStr = words[tens / 10 + 18] + (tens % 10 == 0 ? "" : (" " + words[tens % 10]));
        }
        if (num >= 100) {
            return words[num / 100] + " Hundred" + (tensStr.isEmpty() ? "" : " " + tensStr);
        } else {
            return tensStr;
        }
    }
}
