import java.lang.reflect.Array;
import java.util.*;

public class Permute {
    public static LinkedList<String> permute(String str) {
        if (str == null || str.isEmpty()) {
            //throw new IllegalArgumentExpection("Invalid input.");
        }

        LinkedList<String> result = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            char current = sb.charAt(i);
            String temp = sb.deleteCharAt(i).toString();
            for (int j = 0; j < temp.length() + 1; j++) {
                StringBuffer s = new StringBuffer(temp);
                s.insert(j, current);
                if (!result.contains(s.toString())) {
                    result.add(s.toString());
                }
            }

        }

        return result;
    }

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

    public static void main(String[] args) {
        System.out.println(permute("abcd"));
        System.out.println(allPermutations("abcd"));

    }

}

// [abc, bac, bca, acb, cab, cba]
