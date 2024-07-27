package probleme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Probleme {


    //Given two strings s and t, return true if t is an anagram of s, and false otherwise.
    public static boolean p1(){

        String s = "ana";

        String t = "naa";

        char[] cS = s.toCharArray();
        char[] cT= t.toCharArray();

        Arrays.sort(cS);
        Arrays.sort(cT);

        return Arrays.equals(cS, cT);

    }


    // Write a function that reverses a string. The input string is given as an array of characters s.
    public static void p2(){

        char[] s = {'h','e','l','l','o'};

        int stanga = 0;

        int dreapta = s.length - 1;


        while (stanga < dreapta) {
            char temp = s[stanga];
            s[stanga] = s[dreapta];
            s[dreapta] = temp;
            stanga++;
            dreapta--;
        }

        System.out.println(s);

    }


    // Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
    public static int p3(){

        String s = "leetcode";
        int ok =0;

        for(int i =0; i <s.length()-2;i++){

            char temp = s.charAt(i);
            for(int j = 1;j <s.length()-1;j++){
                if(temp == s.charAt(j)){
                    ok = 1;
                }
            }

            if(ok == 0){
                return i;
            }
        }

        return -1;

    }


    //Given an integer n, return a string array answer (1-indexed) where:
    //
    //answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    //answer[i] == "Fizz" if i is divisible by 3.
    //answer[i] == "Buzz" if i is divisible by 5.
    //answer[i] == i (as a string) if none of the above conditions are true.
    public static void p4(int n){

        ArrayList<String> list = new ArrayList<>();

        for(int i =1 ; i <= n;i++){
            if(i % 3== 0 && i % 5 == 0){
                list.add("FizzBuzz");
            }
            else if(i % 3== 0){
                list.add("Fizz");
            }
            else if(i % 5 == 0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }

        for(int i =0 ; i < list.size();i ++){
            System.out.println(list.get(i));
        }


    }


    // Given a valid (IPv4) IP address, return a defanged version of that IP address.
    public static String p5(String address){

        return address.replace(".", "[.]");

    }


    // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    public static int p6(int [] nums, int val){

        int ct = 0;

        for(int i =0; i < nums.length;i++){
            if (nums[i] != val) {
                nums[ct] = nums[i];
                ct++;
            }
        }
        return ct;

    }


    // Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    public static int p7(int[] nums){

        int[] frec = new int[256];

        for(int i =0; i < nums.length; i++){
            frec[nums[i]]++;
        }

        for(int i =0 ; i < frec.length;i++){
            if(frec[i] == 1){
                return i;
            }
        }
        return -1;
    }

    //Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
    public static int p8(int[] nums){

        int n = nums.length;
        int sum = n * (n+1)/2;
        int sum2 = 0;
        for(int i =0; i < n;i++){
            sum2 += nums[i];
        }

        return sum - sum2;

    }


    // Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
    public static int p9(int n){

        if( n < 10){
            return n;
        }

        int temp = n;

        while(temp > 9){
            temp = suma(temp);
        }

        return temp;

    }

    private static int suma(int n){

        int s =0;
        while(n!= 0){
            int l = n % 10;
            s += l;
            n = n/10;
        }
        return s;
    }


    //Write a function that reverses a string. The input string is given as an array of characters s.
    public static void p10(char[] s){

        int stanga = 0;

        int dreapta = s.length - 1;


        while (stanga < dreapta) {
            char temp = s[stanga];
            s[stanga] = s[dreapta];
            s[dreapta] = temp;
            stanga++;
            dreapta--;
        }

    }
    

    //Given an integer num, return the number of steps to reduce it to zero.
    //In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
    public static int p11(int num) {

        return calc(num, 0);

    }

    static int calc(int num, int count){
        if(num == 0){
            return count;
        }
        if(num%2 == 0){
            return calc(num/2, count+1);
        }else{
            return calc(num-1, count+1);
        }
    }


    // A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height.
    // Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
    public static int p12(int[] heights){

        int[] temp = heights.clone();
        int ct = 0;
        sort(heights);

        for(int i =0; i < heights.length; i++){
            if(temp[i] != heights[i]){
                ct++;
            }
        }

        return ct;

    }
    public static void sort(int[] v){

        for(int i =0 ; i < v.length-1; i++){
            for(int j = i+1; j < v.length; j++){
                if(v[i] > v[j]){
                    int temp = v[i];
                    v[i] = v[j];
                    v[j] = temp;
                }
            }
        }

    }


    //Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
    // You can return the answer in any order.

    public static int[] p13(int[] nums){
        int[] result = new int[2];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[index++] = nums[i];
                if (index == 2) {
                    break;
                }
            }
        }

        return result;

    }

    // Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice,
    // return an array of all the integers that appears twice.

    public static List<Integer> p14(int[] nums){

        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for(int i =0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j]){
                    result.add(nums[i]);
                }
            }
        }
        return result;
    }


    // Given an integer x, return true if x is a palindrome, and false otherwise.
    public static boolean p15(int x){

        if (x < 0){
            return false;
        }

        int reverse = 0;
        int temp = x;

        while (temp != 0){
            int d = temp % 10;
            reverse = reverse * 10 + d;
            temp/=10;
        }
        return (reverse == x);

    }


    //You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
    // The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
    public static int[] p16(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    // Given an integer n, return true if it is a power of two. Otherwise, return false.
    public static boolean p17(int n){

        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return p17(n / 2);

    }


    //Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    public static int p18(String s) {
        char[] list = s.toCharArray();
        int val = 0;

        for (int i = 0; i < list.length; i++) {

            if (i+1 < list.length){
                if (list[i+1] == 'V' && list[i] == 'I'){
                    val+=4;
                    i++;
                    continue;
                }
                else if (list[i+1] == 'X' && list[i] == 'I'){
                    val+=9;
                    i++;
                    continue;
                }
                else if (list[i+1] == 'L' && list[i] == 'X'){
                    val+=40;
                    i++;
                    continue;
                }
                else if (list[i+1] == 'C' && list[i] == 'X'){
                    val+=90;
                    i++;
                    continue;
                }
                else if (list[i+1] == 'D' && list[i] == 'C'){
                    val+=400;
                    i++;
                    continue;
                }
                else if (list[i+1] == 'M' && list[i] == 'C'){
                    val+=900;
                    i++;
                    continue;
                }
            }

            if (list[i] == 'I') {
                val += 1;
            } else if (list[i] == 'V') {
                val += 5;
            } else if (list[i] == 'X') {
                val += 10;
            } else if (list[i] == 'L') {
                val += 50;
            } else if (list[i] == 'C') {
                val += 100;
            } else if (list[i] == 'D') {
                val += 500;
            } else if (list[i] == 'M') {
                val += 1000;
            }
        }
        return val;
    }


    // Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    public static int p19(String haystack, String needle){
        return haystack.indexOf(needle);
    }


    //Given a sorted array of distinct integers and a target value, return the index if the target is found.
    // If not, return the index where it would be if it were inserted in order.
    public static int p20(int[] nums, int target){

        if(target == 0){
            return 0;
        }

        for(int i = 0 ; i < nums.length-1;i++){
            if(nums[i] == target){
                return i;
            }
            if(nums[i] < target && target < nums[i+1]){
                return i+1;
            }
        }

        return nums.length;

    }


    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    public static boolean p21(int[] nums){
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }


    //Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
    public static int p22(int x) {
        int nou =0;


        while(x!=0){

            int uc = x % 10;
            nou = nou * 10 + uc;
            x /= 10;
        }

        return nou;
    }


    //Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
    public static int p23(int[]nums){

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }


    //Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
    public static int p24(int x){
        int l=1;
        int r=x;
        while(l<=r){
            int m=(r-l)/2+l;
            if(m>x/m) {
                r=m-1;
            }
            else if(m<x/m) {
                l=m+1;
            }
            else return m;
        }
        return r;


    }


    //Given an array nums of size n, return the majority element.
    //The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
    public static int p25(int[] nums){

        int[] frec = new int[1000];

        int n = nums.length;

        for(int i =0; i < n;i++){
            frec[nums[i]]++;
        }

        for(int i =0 ; i < frec.length;i++){
            if(i > n / 2 ){
                return i;
            }
        }
        return -1;
    }

    //Write an algorithm to determine if a number n is happy.
    public static boolean p26(int n){

        int sum = n;

        while(sum!= 1){
            sum = calc(sum);
        }
        return true;
    }

    public static int calc(int n){

        int sum =0;
        while(n != 0){
            int uc = n % 10;
            sum = sum + uc * uc;
            n/=10;
        }

        return sum;

    }

    //Given an integer n, return true if n is an ugly number.
    //An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
    public static boolean p27(int n){

        while (n>1) {
            if (n % 5 == 0) {
                n = n / 5;
            } else if (n % 3 == 0){
            n = n / 3;
        }
            else if (n%2==0) {
                n = n / 2;
            }
            else {
                break;
            }
        }
        return n==1;

    }


}
