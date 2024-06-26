package probleme;

import java.util.ArrayList;
import java.util.Arrays;

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

}
