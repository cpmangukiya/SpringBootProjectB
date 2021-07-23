package org.example.mutation.sample;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * Unit sample with mutation testing for simple App.
 */
public class PalindromeMutationTest
{
    @Test
    public void testIsPalindromeMutationTesting()
    {
        boolean result = PalindromeDetector.isPalindromeRecursiveWay("abcba");
        Assert.isTrue(result, "Palindrome check should return true for string 'abcba'");

        result = PalindromeDetector.isPalindromeRecursiveWay("abba");
        Assert.isTrue(result, "Palindrome check should return true for string 'abba'");

        // Assertions.assertFalse(result = PalindromeDetector.isPalindromeRecursiveWay("box"));

        // Assertions.assertFalse(result = PalindromeDetector.isPalindromeRecursiveWay("neon"));

    }
}


