import java.util.*;

/**
 * Created by Hamad on 8/20/2016.
 */
public class ArraysAndStrings {
    public String conpressString(String str) {
        String retVal = "";
        char previousElement = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == previousElement) {
                count++;
            } else {
                retVal += previousElement + "" + count;
                previousElement = str.charAt(i);
                count = 1;
            }
        }

        if (str.length() == retVal.length()) {
            return str;
        }

        return retVal;
    }

    public void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * Determine is a string has all unique char.
     *
     * @param str
     * @return
     */
    public boolean checkStringHasAllUniqueChar(String str) {
        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                return false;
            }

            map.put(str.charAt(i), 1);
        }

        return true;
    }

    String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public boolean isPermutation(String str1, String str2) {
        String sortedString1 = sort(str1);
        String sortedString2 = sort(str2);
        if (sortedString1.equals(sortedString2)) {
            return true;
        }
        return false;
    }

    public boolean isPermutationNonSorted(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] count = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int ord = (int) str1.charAt(i);
            count[ord]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int ord = (int) str2.charAt(i);
            count[ord]--;
            if (count[ord] < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean hasAllUniqueCharacters(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        }

        if (str.isEmpty()) {
            return true;
        }

        int chk = 0;
        for (int i = 0; i < str.length(); i++) {
            int current = 1 << (str.charAt(i) - 'a');
            if ((chk & current) > 0) {
                return false;
            }

            chk |= current;
        }

        return true;
    }

    public boolean hasAllUniqueCharactersWithHash(String str) {
        HashSet<Character> hash = new LinkedHashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hash.contains(c)) {
                return false;
            }

            hash.add(c);
        }

        return true;
    }

    public String replaceSpaces(String str) {
        StringBuffer sb = new StringBuffer();
        boolean spaceAlreadySeen = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c == ' ' || c == '\t') && !spaceAlreadySeen) {
                sb.append("%20");
                spaceAlreadySeen = true;

            } else if ((c == ' ' || c == '\t') && spaceAlreadySeen) {
                continue;
            } else {
                sb.append(c);
                spaceAlreadySeen = false;
            }
        }

        return sb.toString();
    }

    public String compressString(String str) {
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (index < str.length()) {
            int count = 1;
            while ((index + count < str.length()) && str.charAt(index + count) == str.charAt(index)) {
                count++;
            }
            sb.append(str.charAt(index));
            sb.append(count);
            index += count;
        }

        if (sb.toString().length() > str.length()) {
            return str;
        }

        return sb.toString();
    }

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x) + 1, i + 1};
            }

            map.put(x, i);
        }

        throw new IllegalArgumentException("No two numbers are same");
    }

    public int[] twoSumSorted(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            if (target == numbers[start] + numbers[end]) {
                return new int[]{start + 1, end + 1};
            } else if (target < numbers[start] + numbers[end]) {
                start++;
            } else {
                end--;
            }
        }

        throw new IllegalArgumentException("No two numbers are same.");
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
        }

        return true;
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    public String reverseString(String str) {
        StringBuffer sb = new StringBuffer();
        int end = str.length();
        for (int start = str.length() - 1; start >= 0; start--) {
            if (str.charAt(start) == ' ') {
                end = start;
            } else if (start == 0 || str.charAt(start - 1) == ' ') {
                if (sb.length() != 0) {
                    sb.append(" ");
                }

                sb.append(str.substring(start, end));
            }
        }

        return sb.toString();
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        for (int i = 0, j = 0; j <= s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverse(s, i, j);
                i = j + 1;
            }
        }
    }

    private void reverse(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char temp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = temp;
        }
    }

    public int[] rotateArray(int[] array, int key) {
        for (int i = 0; i < key; i++) {
            int last = array[array.length - 1];
            for (int j = array.length - 1; j >= 1; j--) {
                array[j] = array[j - 1];
            }
            array[0] = last;
        }

        return array;
    }

    public int atoi(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Invalid exception.");
        }
        int i = 0;

        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;
        int sign = 1;
        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        int num = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            num = num * 10 + digit;
            i++;
        }

        return sign * num;
    }

    public boolean isNumeric(String str) {
        if (str.isEmpty()) {
            return false;
        }
        boolean isNumeric = false;
        int i = 0;
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) i++;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < str.length() && str.charAt(i) == '.') {
            i++;
            while (i < str.length() && Character.isDigit(str.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) i++;
        return isNumeric && i == str.length();
    }

    public int longestSubstring(String s) {
        boolean[] exists = new boolean[256];
        int maxLength = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            while (exists[s.charAt(end)]) {
                exists[s.charAt(start)] = false;
                start++;
            }

            exists[s.charAt(end)] = true;
            maxLength = Math.max(end - start + 1, maxLength);
        }

        return maxLength;
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0, lastPositionOf = -1, maxLength = 0;
        for (int end = 1; end < s.length(); end++) {
            if (s.charAt(end) == s.charAt(end - 1)) continue;
            if (lastPositionOf >= 0 && s.charAt(start) != s.charAt(end)) {
                maxLength = Math.max(end - start, maxLength);
                start = lastPositionOf + 1;
            }
            lastPositionOf = end - 1;
        }

        return maxLength;
    }


    public boolean isValidNumber(String s) {
        String str = s.trim();
        int i = 0;
        boolean returnValue = false;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
            returnValue = true;
        }

        if (i < str.length() && str.charAt(i) == '.') {
            i++;
        }

        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            i++;
            returnValue = true;
        }

        return returnValue && (i == str.length());
    }

    public int longestNonRepeatingSubsequence(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int start = 0, maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            if (charMap[s.charAt(end)] >= start) {
                start = charMap[s.charAt(end)] + 1;
            }
            charMap[s.charAt(end)] = end;
            maxLen = Math.max(end - start + 1, maxLen);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstringTwoDistinct1(String s) {

        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;
            }
            j = k - 1;
        }

        return Math.max(s.length() - i, maxLen);
    }

    public List<String> missingRanges(int[] array, int start, int end) {
        List<String> list = new ArrayList<>();
        int previous = start - 1;
        for (int i = 0; i <= array.length; i++) {
            int curr = (i == array.length) ? end : array[i];
            if (curr - previous >= 2) {
                list.add(printRange(previous + 1, curr - 1));
            }

            previous = curr;
        }

        return list;
    }

    private String printRange(int start, int end) {
        return (start == end) ? Integer.toString(start) : start + "->" + end;
    }

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public boolean isOneEditDistanceAway(String s, String t) {
        int lengthSmall = s.length(), lengthLarge = t.length();
        if (lengthSmall > lengthLarge)  return isOneEditDistanceAway(t, s);
        if (lengthLarge - lengthSmall > 1) return false;

        int i = 0, shift = lengthLarge - lengthSmall;
        while (i < lengthSmall && s.charAt(i) == t.charAt(i)) i++;
        if (i == lengthSmall) return shift > 0;
        if (shift >= 0) i++;
        while (i < lengthSmall && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == lengthSmall;
    }

    public  List<List<Integer>> generatePascalsTriangle(int numRows) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();

        if (numRows == 0) {
            return resultList;
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> currentList = new ArrayList<>();
            if (i == 0) {
                currentList.add(1);
            } else {
                currentList.add(1);
                int count = 0;
                for (int j = 1; j < i; j++) {
                    currentList.add(resultList.get(i - 1).get(count) + resultList.get(i - 1).get(count + 1));
                    count++;
                }
                currentList.add(1);
            }

            resultList.add(currentList);
        }


        return resultList;
    }


    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(nums[i])) {
                hash.remove(nums[i]);
            } else {
                hash.add(nums[i]);
            }
        }

        return hash.stream().mapToInt(Number::intValue).toArray();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (x > y)
                {
                    return -1;
                }
                if (x < y)
                {
                    return 1;
                }
                return 0;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        int x = 0;
        while (x < k - 1) {
            pq.remove();
            x++;
        }

        return pq.peek();
    }

}
