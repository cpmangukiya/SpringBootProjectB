package org.example;

import org.example.problems.PalindromeString;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Unit sample for simple App.
 */
public class PalindromeTest
{
    @Test
    public void testIsPalindromeNormalTesting()
    {
        boolean result = PalindromeString.isPalindromeRecursiveWay("abcba");
        Assert.isTrue(result, "Palindrome check should return true for string 'abcba'");

        result = PalindromeString.isPalindromeRecursiveWay("abba");
        Assert.isTrue(result, "Palindrome check should return true for string 'abba'");
    }
}


