/**
 * Created by Hamad on 8/20/2016.
 */
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArraysAndStringsTest {
    protected ArraysAndStrings arr = new ArraysAndStrings();

    @Test
    public void conpressStringWithRepetitionsTest() {
        String retVal = arr.compressString("aaabcccdd");
        Assert.assertEquals("a3b1c3d2", retVal);
    }

    @Test
    public void conpressStringWithoutRepetitionsTest() {
        String retVal = arr.compressString("abcd");
        Assert.assertEquals("abcd", retVal);
    }

    @Test
    public void conpressStringNullStringTest() {
        String retVal = arr.compressString("");
        Assert.assertEquals("", retVal);
    }

    @Test
    public void findkthlargestTest() {
        int[] array = {1, 2, 3, 4, 5, 6};
        int result = arr.findKthLargest(array, 2);
        Assert.assertEquals(5, result);
    }

    @Test
    public void generatePascalsTriangleTest() {
        List<List<Integer>> result = arr.generatePascalsTriangle(4);
        Assert.assertEquals(result.toString(), "[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]");
    }

    @Test
    public void isOneEditDistanceAwayTest() {
        Assert.assertTrue(arr.isOneEditDistanceAway("bad", "bid"));
    }

    @Test
    public void longestPalindromeTest() {
        Assert.assertEquals(arr.longestPalindrome("cabbadfte"), "abba");
    }

    @Test
    public void missingRangesTest() {
        int [] array = {1, 2, 3, 9, 25, 78, 80};
        Assert.assertEquals(arr.missingRanges(array, 0, 99).toString(), "[0, 4->8, 10->24, 26->77, 79, 81->98]") ;
    }

    @Test
    public void lengthOfLongestSubstringTwoDistinct1Test() {
        Assert.assertEquals(3, arr.lengthOfLongestSubstringTwoDistinct1("dasfdsafadsfsa"));
    }

    @Test
    public void longestNonRepeatingSubsequenceTest() {
        Assert.assertEquals(4, arr.longestNonRepeatingSubsequence("aaaaaasdffffffffffsdfafasdfas"));
    }

    @Test
    public void isValidNumberTest() {
        Assert.assertTrue(arr.isValidNumber("2.222"));
    }

    @Test
    public void singleNumberTest() {
       // Assert.assertEquals(
       //         arr.singleNumber(new int[]{1, 1, 2, 3, 3, 5,6, 6}).toString(), (new int[]{2, 5}).toString());
    }

    @Test
    public void lengthOfLongestSubstringTwoDistinctTest() {
        System.out.println(arr.lengthOfLongestSubstringTwoDistinct("sssdfddddddddd"));
        System.out.print(arr.longestSubstring("sssdfddddddddd"));
    }

}
