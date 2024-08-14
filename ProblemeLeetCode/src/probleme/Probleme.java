package probleme;

import java.lang.reflect.Array;
import java.util.*;

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


    //Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
    public static int p28(int[] nums){

        Arrays.sort(nums);
        int c=0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]!=nums[i-1]){
                c++;
            }
            if(c==2){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }


    //A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
    public static boolean p29(int num){


        int sum =0;
        for(int i =1; i <= num;i++){
            if(num % i ==0){
                sum+= i;
            }
        }
        if(sum == num){
            return true;
        }
        return false;
    }


    //The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
    public static int p30(int n){
        if(n<2){
            return n;
        }
        return p30(n-1)+p30(n-2);
    }


    //Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).
    static class p31{

        private Queue<Integer> queue = new LinkedList<>();


        public void push(int x) {
            queue.add(x);
            for(int i = 1;i<queue.size();i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.remove();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }

    }


    //There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

    public static int p32(int[] tickets, int k){

        int time =0;

        for(int i = 0 ;i < tickets.length;i++){
            if(i <= k) {
                time += Math.min(tickets[k], tickets[i]);
            }
            else {
                time += Math.min(tickets[k] - 1, tickets[i]);
            }
        }
        return time;
        

    }


    // Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. ????

    public static List<String> p33(int n){
        return null;

    }


    //Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
    public static int p34(int[] nums, int target){
        for(int i =0 ; i < nums.length;i++){
            if (target == nums[i]){
                return i;
            }
        }
        return -1;
    }


    // Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    public static int[] p35(int[] nums, int target){

        int i = 0;
        int j = nums.length-1;
        int len[] = {-1 , -1};
        if(nums.length == 1)
        {
            if(nums[0] == target)
            {
                return new int[]{0, 0};
            }
            return new int[]{-1, -1};
        }
        while(i <= j)
        {
            if(nums[i] != target)
            {
                i++;
            }
            if(nums[j] != target)
            {
                j--;
            }
            if(nums[i] == target && nums[j] == target)
            {
                len[0] = i;
                len[1] = j;
                break;
            }
        }
        return len;
    }


    //Given an integer array nums, find the
    //subarray
    // with the largest sum, and return its sum.
    public static int p36(int[] nums){

        int rez = nums[0];
        int sum =0;

        for(int i =0; i < nums.length;i++){
            if(sum < 0){
                sum = 0;
            }
            sum += nums[i];
            rez = Math.max(rez, sum);

        }

        return rez;

    }


    // An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

    public static boolean p37(int[] nums){


        for(int i = 0; i < nums.length-1;i++){
            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }
        return true;
    }


    // For each queries[i], you need to find the index of the queries[i]th occurrence of x in the nums array. If there are fewer than queries[i] occurrences of x, the answer should be -1 for that query.
    public static int[] p38(int[] nums, int[] queries, int x){

        List<Integer> oc = new ArrayList<>();

        for(int i=0; i < nums.length;i++){
            if(nums[i] == x){
                oc.add(i);
            }
        }

        int[] rez = new int[queries.length];
        for(int i =0; i < queries.length;i++){
            if(queries[i] <= oc.size()){
                rez[i] = oc.get(queries[i] -1);
            }else{
                rez[i] = -1;
            }

        }
        return rez;
    }


    //Your laptop keyboard is faulty, and whenever you type a character 'i' on it, it reverses the string that you have written. Typing other characters works as expected.
    public static String p39(String s){

        StringBuilder rez = new StringBuilder();

        for(int i =0; i < s.length();i++){
            if(s.charAt(i) != 'i'){
                rez.append(s.charAt(i));
            }
            if(s.charAt(i) == 'i'){
                rez.reverse();
            }

        }
        return rez.toString();
    }


    //You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:
    //
    //Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
    //Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.
    //Keep repeating the steps again, alternating left to right and right to left, until a single number remains.
    //Given the integer n, return the last number that remains in arr.
    public static int p40( int n){

        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 ==1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }


    // Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
    //
    //Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column),
    // where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

    public static int p41(char[][] board){

        return 0;

    }

    //Given an integer array nums of unique elements, return all possible
    //subsets
    // (the power set).
    //
    //The solution set must not contain duplicate subsets. Return the solution in any order.???



    //Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    public static void p42(int[] nums){

        int k =0;

        for(int i =0; i < nums.length;i++){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }

        }

        for(int i = k; i < nums.length;i++){
            nums[i] = 0;
        }

    }


    // Given two integer arrays nums1 and nums2, return an array of their
    //intersection
    //. Each element in the result must be unique and you may return the result in any order.
    public static int[] p43(int[] nums1, int[] nums2) {


        int[] list = new int[1001];


        for(int nums : nums1){
            list[nums]++;
        }


        for(int nums: nums2){
            if(list[nums] == 1){
                list[nums] = 3;
            }

            if(list[nums] == 2){
                list[nums] = 4;
            }
        }


        List<Integer> rez = new ArrayList<>();
        for(int i =0;i<list.length;i++){
            if(list[i]== 3){
                rez.add(i);
            }
            if(list[i]== 4){
                rez.add(i);
                rez.add(i);
            }
        }

        int[] f = new int[rez.size()];

        for(int i =0; i < f.length;i++){
            f[i] = rez.get(i);
        }
        return f;


    }

    
    //Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
    public static int[] p44(int[] nums1, int[] nums2){

        List<Integer> rez = new ArrayList<>();

        int i = 0, j = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {  // nums1[i] == nums2[j]
                rez.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] f = new int[rez.size()];


        for (int k = 0; k < f.length; k++) {
            f[k] = rez.get(k);
        }

        return f;

    }


    //You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    //
    //Merge nums1 and nums2 into a single array sorted in non-decreasing order.
    public static void p45(int[] nums1, int m, int[] nums2, int n){

        int i =0, j =0 ;

        for( i =m; i < nums1.length;i++){
            if(nums1[i] == 0){
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
    }


    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    public static int p46(int n){

        if(n == 0 || n == 1){
            return 1;
        }

        return p46(n-1) + p46(n-2);

    }


    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    //
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    public static int p47(int[] prices){

        int buy = prices[0];
        int profit = 0;


        for(int i =0 ; i < prices.length;i++){
            if(prices[i] < buy){
                buy = prices[i];
            }

            profit = Math.max(profit, prices[i] - buy);


        }
        return profit;
    }


    //Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
    public static int p48(int[] nums){

        int p = 1;
        int ct = 0;

        Arrays.sort(nums);

        for(int i = nums.length-1; i >= 0; i--){
            if( ct == 3){
                break;
            }
            p *= nums[i];
            ct++;
        }
        return p;

    }


    //There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
    //
    //You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
    public static boolean p49(String moves){


        int x =0;
        int y =0;

        for(int i =0;i < moves.length();i++){
            if(moves.charAt(i) == 'U'){
                x++;
            }
            if(moves.charAt(i) == 'D'){
                x--;
            }
            if(moves.charAt(i) == 'L'){
                y++;
            }
            if(moves.charAt(i) == 'R'){
                y--;
            }
        }

        return x == 0 && y == 0;

    }

    //A self-dividing number is a number that is divisible by every digit it contains.
    //
    //For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    //A self-dividing number is not allowed to contain the digit zero.
    public static List<Integer> p50(int left, int right){

        List<Integer> list = new ArrayList<>();

        for(int i = left; i <= right;i++){
            if(selfDividing(i)){
                list.add(i);
            }
        }
        return list;
    }

    public static boolean selfDividing(int n) {

        int divisor = 1;
        while (n / divisor >= 10) {
            divisor *= 10;
        }


        while (divisor > 0) {
            int digit = (n / divisor) % 10;

            if (digit == 0 || n % digit != 0) {
                return false;
            }

            divisor /= 10;
        }

        return true;
    }



}
