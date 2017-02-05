/**
Problem Statement: Given a string, print the minimum number of characters you have to remove from the string to make it a good string.
A good string is a string in which all the characters are distinct.
Note : All characters are in small case.
Example : given an input string 'abcd', your program should output 1, because We can make a good string by removing one of the two 'a'.
*/

/**
This can be solved by many ways. But one optimised way is using hashing.
Algorithm :
As given, all charecters will be in small cases. So, we will take an array 'coutns' of size 26.
Initialize this array with 0s.
Now traverse each character of the input string and increament count of each character in 'counts' array.
Once we reach to end of the string, traverse 'counts' array and add value - 1 at that index to counter if the value is > 1.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class GoodStrings {
	public static void main(String args[] ) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	String line = br.readLine();
        	int a[] = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        	int c = 0;

        	for (int i = 0; i < line.length(); i++) {
            	a[line.charAt(i) - 97]++;
        	}
        	for (int i = 0; i < a.length; i++) {
            		if(a[i] > 0) {
                		c = c + a[i] - 1;
            		}
        	}
        	System.out.println(c);
	}
}
