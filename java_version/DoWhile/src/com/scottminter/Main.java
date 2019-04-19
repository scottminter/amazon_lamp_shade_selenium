package com.scottminter;

public class Main {

    public static void main(String[] args) {
	    int count = 0;
	    while(count != 5) {
            System.out.println("count: " + count);
            count++;
        }

        System.out.println("**************");
	    count = 0;
	    while(true) {
	        if(count == 5) {
	            break;
            }

            System.out.println("count: " + count);
            count++;
        }

        System.out.println("**************");
	    count = 0;
	    do {
            System.out.println("cout: " + count);
            count++;
        } while(count != 6);

        System.out.println("**************");
        int evenCount = 0;
        int num = 5;
        int finishNum = 20;
        while(num <= finishNum) {
            if(!isEven(num)) {
                num++;
                continue;
            }

            System.out.println("Even number " + num);
            evenCount++;
            num++;
        }
        System.out.println("Number of evens: " + evenCount);
    }

    public static boolean isEven(int n) {
        if(n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
