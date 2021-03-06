import java.lang.reflect.Array;
import java.util.*;

public class Permute {
    public static List<String> allPermutations(String str) {
        LinkedList<String> ret = new LinkedList<>();
        if (str.length() == 1) {
            ret.add(str);
            return ret;
        }
        char first = str.charAt(0);
        LinkedList<String> nextLevel = (LinkedList<String>) allPermutations(str.substring(1));
        for (String s : nextLevel) {
            ret.addAll(insertIntoString(s, first));
        }
        return ret;
    }

    public static List<String> insertIntoString(String str, char c) {
        LinkedList<String> ret = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= str.length(); i++) {
            sb.setLength(0);
            sb.append(str);
            sb.insert(i, c);
            ret.add(sb.toString());
        }
        return ret;
    }
}