package dev.maka.four;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Four {
    private static int min = 145852;
    private static int max = 616942;

    public static void main(String[] args) {

        ArrayList<Integer> possiblePasswords = new ArrayList<>();
        for (int password = min; password <= max; password++) {
            if(matchesCriteria(password)) {
                possiblePasswords.add(password);
            }
        }

        System.out.println("Possible passwords: "+ possiblePasswords.size());
    }

    private static boolean matchesCriteria(int password) {
        String passwordString = String.valueOf(password);
        char[] passwordCharArray = passwordString.toCharArray();

        int size = passwordCharArray.length;
        int[] doubles = new int[10];
        for (int i = 0; i < size; i++) {
            if(i < size - 1 && passwordCharArray[i] > passwordCharArray[i + 1])
                return false;
            doubles[Character.getNumericValue(passwordCharArray[i])]++;
        }

        return  passwordString.length() == 6 &&
                password >= min &&
                password <= max &&
                Arrays.stream(doubles).anyMatch(i -> i == 2);
    }

    @Test
    public void testMatchingTrue1() {
        Assert.assertTrue(matchesCriteria(223456));
    }

    @Test
    public void testMatchingTrue2() {
        Assert.assertTrue(matchesCriteria(555566));
    }

    @Test
    public void testMatchingTrue3() {
        Assert.assertTrue(matchesCriteria(223455));
    }

    @Test
    public void testMatchingTrue4() {
        Assert.assertTrue(matchesCriteria(188899));
    }

    @Test
    public void testMatchingTrue5() {
        Assert.assertTrue(matchesCriteria(224455));
    }

    @Test
    public void testMatchingTrue6() {
        Assert.assertTrue(matchesCriteria(222233));
    }

    @Test
    public void testMatchingFalse1() {
        Assert.assertFalse(matchesCriteria(456789));
    }

    @Test
    public void testMatchingFalse2() {
        Assert.assertFalse(matchesCriteria(111111));
    }

    @Test
    public void testMatchingFalse3() {
        Assert.assertFalse(matchesCriteria(223450));
    }

    @Test
    public void testMatchingFalse4() {
        Assert.assertFalse(matchesCriteria(123789));
    }

    @Test
    public void testMatchingFalse5() {
        Assert.assertFalse(matchesCriteria(17789));
    }

    @Test
    public void testMatchingFalse6() {
        Assert.assertFalse(matchesCriteria(234555));
    }

    @Test
    public void testMatchingFalse7() {
        Assert.assertFalse(matchesCriteria(234445));
    }
}
