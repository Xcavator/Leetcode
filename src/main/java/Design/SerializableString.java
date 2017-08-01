package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang on 2017/7/19.
 */
public class SerializableString {
    public String encode(List<String> strs) {
        StringBuilder ori = new StringBuilder();
        for (String str : strs) {
            ori.append(str.length()).append("/").append(str);
        }
        return ori.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<String>();

        for (int i = 0; i < s.length();) {
            int slash = s.indexOf("/", i);
            int count = 0;
            for (int j = i; j < slash; j++) {
                count = count * 10 + (s.charAt(j) - '0');
            }
            i = slash + 1 + count;
            res.add(s.substring(slash + 1, i));

        }

        return res;
    }
//    public String encode(List<String> strs) {
//        String ret = new String();
//        for (String s : strs) {
//            ret += "@/#" + do_encode(s);
//        }
//        return ret.length() == 0 ? null : ret.substring(3);
//    }
//
//    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//        List<String> ret = new ArrayList<String>();
//        if (s == null) return ret;
//        if (s.length() == 0) ret.add(new String());
//        // if (s.startsWith("@/#")) ret.add(new String());
//        int st = 0;
//        while(st < s.length()) {
//            int end = s.indexOf("@/#", st);
//            if (end == -1) {
//                ret.add(do_decode(s.substring(st)));
//                break;
//            } else if (end == st) {
//                ret.add(new String());
//                st = end + 3;
//            } else {
//                ret.add(do_decode(s.substring(st, end)));
//                st = end + 3;
//            }
//        }
//        if (s.endsWith("@/#")) ret.add(new String());
//        return ret;
//    }
//
//    public String do_encode(String s) {
//        if (null == s || s.length() == 0) return s;
//        return s.replaceAll("/", "//");
//
////        if (null == s || s.length() == 0) return s;
////        char[] chrs = s.toCharArray();
////        StringBuilder sb = new StringBuilder();
////        sb.append(chrs[0] == '/' ? "//" : chrs[0]);
////        int count = 1;
////        for (int i = 1; i < s.length(); ++i) {
////            if (chrs[i] == chrs[i - 1] && count <= Integer.MAX_VALUE) {
////                count++;
////            } else {
////                if (count > 1) {
////                    if (count > 3) {
////                        sb.append("/");
////                        sb.append(count);
////                        sb.append("/");
////                    } else {
////                        while (count-- > 1) sb.append(chrs[i - 1] == '/' ? "//" : chrs[i - 1]);
////                    }
////                    count = 1;
////                }
////                sb.append((chrs[i] == '/' ? "//" : chrs[i]));
////
////            }
////        }
////        if (count > 1) {
////            if (count > 3) {
////                sb.append("/");
////                sb.append(count);
////                sb.append("/");
////            } else {
////                while (count-- > 1) sb.append(chrs[chrs.length - 1] == '/' ? "//" : chrs[chrs.length - 1]);
////            }
////
////        }
////        return sb.toString();
//    }
//
//    public String do_decode(String s) {
//        if (null == s || s.length() == 0) return s;
//        return s.replaceAll("//", "/");
//
////        if (null == s || s.length() == 0) return s;
////        char[] chrs = s.toCharArray();
////        int len = s.length();
////        StringBuilder sb = new StringBuilder();
////        for (int i = 0; i < len; i++) {
////            char t = chrs[i];
////            sb.append(t);
////            if (t == '/') {
////                i++;
////            }
////            if (i < len - 3 && chrs[i + 1] == '/' && chrs[i + 2] >= '0' && chrs[i + 2] <= '9') {
////                i += 2;
////                int nexti = s.indexOf('/', i);
////                int n = Integer.valueOf(s.substring(i, nexti));
////                for (int j = n; j > 1; --j) sb.append(t);
////                i = nexti;
////            }
////        }
////        return sb.toString();
//    }
}
