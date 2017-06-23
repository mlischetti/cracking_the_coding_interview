package com.mlischetti.cracking_the_coding_interview.bigO;

public class AdditionalProblems {

    /**
     * Algorithm runs in time O(b)
     * The loop iterates through b.
     *
     * @param a
     * @param b
     * @return
     */
    int product(int a, int b) {
        int sum = a;
        for (int i = a; i < b; i++) {
            sum += a;
        }
        return sum;
    }

    /**
     * Algorithm runs in time O(b)
     * The recursive code iterates through b call, since it subtracts one at each level.
     *
     * @param a
     * @param b
     * @return
     */
    int power(int a, int b) {
        if (b < 0) {
            return 0; //error
        } else if (b == 1) {
            return a;
        } else {
            return a * power(a, b - 1);
        }
    }

    /**
     * Algorithm runs in time O(1)
     * It does a constant amount of work.
     *
     * @param a
     * @param b
     * @return
     */
    int mod(int a, int b) {
        if (b <= 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    /**
     * Integer division (assume a and b are both positive)
     * <p>
     * Algorithm runs in time O(a / b)
     * <p>
     * The variable count will eventually equal ~. The while loop iterates count times. Therefore, it
     * iterates ~ times.
     *
     * @param a
     * @param b
     * @return
     */
    int div(int a, int b) {
        int count = 0;
        int sum = 0;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    /**
     * The following code computes the (integer) square root of a number. If the number is not a
     * perfect square (there is no integer square root), then it returns -1. It does this by successive
     * guessing. If n is 100, it first guesses 50. Too high? Try something lower - halfway between 1
     * and 50. What is its runtime?
     * <p>
     * Algorithm runs in time O(log(n))
     * <p>
     * This algorithm is essentially doing a binary search to find the square root. Therefore, the
     * runtime is O(log n)
     * <p>
     * Output:
     * sqrt(100)
     * sqrt_helper(100, 1, 100)
     * sqrt_helper(100, 1, 49)
     * sqrt_helper(100, 1, 24)
     * sqrt_helper(100, 1, 11)
     * sqrt_helper(100, 7, 11)
     * sqrt_helper(100, 10, 11)
     *
     * @param n
     * @return
     */
    int sqrt(int n) {
        return sqrt_helper(n, 1, n);
    }

    int sqrt_helper(int n, int min, int max) {
        System.out.println("sqrt_helper(" + n + "," + min + "," + max + ")");
        if (max < min) return -1; // no square root

        int guess = (min + max) / 2;
        if (guess * guess == n) { // found it!
            return guess;
        } else if (guess * guess < n) { // too low
            return sqrt_helper(n, guess + 1, max); // try higher
        } else { // too high
            return sqrt_helper(n, min, guess - 1); // try lower
        }
    }

    public static void main(String[] args) {
        AdditionalProblems ap = new AdditionalProblems();
//        ap.sqrt(100);
        System.out.println(ap.sumDigits(54));
    }


    /**
     * The following code computes the (integer) square root of a number. If the number is not
     * a perfect square (there is no integer square root), then it returns -1. It does this by trying
     * increasingly large numbers until it finds the right value (or is too high). What is its runtime?
     * <p>
     * Algorithm runs in time O(sqrt(n))
     * <p>
     * This is just a straightforward loop that stops when guess * guess > n (or, in other
     * words, when guess > sqrt (n »).
     *
     * @param n
     * @return
     */
    int sqrt2(int n) {
        for (int guess = 1; guess * guess <= n; guess++) {
            if (guess * guess == n) {
                return guess;
            }
        }
        return -1;
    }

    /**
     * If a binary search tree is not balanced, how long might it take (worst case) to find an element in it?
     *
     * O(n), where n is the number of nodes in the tree. The max time to find an element is the depth tree. The
     * tree could be a straight list downwards and have depth n.
     */

    /**
     * You are looking for a specific value in a binary tree, but the tree is not a binary search tree.
     * What is the time complexity of this?
     *
     * O(n). Without any ordering property on the nodes, we might have to search through all the nodes.
     */

    /**
     * The appendToNew method appends a value to an array by creating a new, longer array and
     * returning this longer array. You've used the appendToNew method to create a copyArray
     * function that repeatedly calls appendToNew. How long does copying an array take?
     * <p>
     * Algorithm runs in time O(n * n)
     * <p>
     * O(n2), where n is the number of elements in the array. The first call to appendToNew takes 1 copy. The
     * second call takes 2 copies. The third call takes 3 copies. And so on. The total time will be the sum of 1
     * through n, which is O(n2).
     *
     * @param array
     * @return
     */
    int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew(copy, value);
        }
        return copy;
    }

    int[] appendToNew(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }
        // add new element
        bigger[bigger.length - 1] = value;
        return bigger;
    }

    /**
     * The following code sums the digits in a number. What is its big 0 time?
     * Algorithms runs in O(log n)
     * <p>
     * O(log n). The runtime will be the number of digits in the number. A number with d digits can have a
     * value up to led. If n = led, then d = log n. Therefore, the runtime is O(log n).
     *
     * @param n
     * @return
     */
    int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
            System.out.println("sum: " + sum + ", n: " + n);
        }
        return sum;
    }

    /**
     * The following code prints all strings of length k where the characters are in sorted order. It
     * does this by generating all strings of length k and then checking if each is sorted. What is its
     * runtime?
     * <p>
     * Algorithm runs in time O(n * n * 24)
     * <p>
     * 0 (k * c k), where k is the length of the string and c is the number of characters in the alphabet. It takes
     * O(ck) time to generate each string. Then, we need to check that each of these is sorted, which takes
     * O(k) time
     */
    int numChars = 26;

    void printSortedStrings(int remaining) {
        printSortedStrings(remaining, "");
    }

    void printSortedStrings(int remaining, String prefix) {
        if (remaining == 0) {
            if (islnOrder(prefix)) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < numChars; i++) {
                char c = ithLetter(i);
                printSortedStrings(remaining - 1, prefix + c);
            }
        }
    }

    boolean islnOrder(String s) {
        for (int i = 1; i < s.length(); i++) {
            int prev = ithLetter(s.charAt(i - 1));
            int curr = ithLetter(s.charAt(i));
            if (prev > curr) {
                return false;
            }
        }
        return true;
    }

    char ithLetter(int i) {
        return (char) (((int) 'a') + i);
    }

    /**
     * The following code computes the intersection (the number of elements in common) of two
     * arrays. It assumes that neither array has duplicates. It computes the intersection by sorting
     * one array (array b) and then iterating through array a checking (via binary search) if each
     * value is in b. What is its runtime?
     * <p>
     * Algorithm runs in time O(b log b + a log b)
     * <p>
     * O(b log b + a log b). First, we have to sort array b, which takes O(b log b) time. Then, for each
     * element in a, we do binary search in O(log b) time. The second part takes O(a log b) time.
     **/
    int intersection(int[] a, int[] b) {
        mergesort(b);
        int intersect = 0;
        for (int x : a) {
            if (binarySearch(b, x) >= 0) {
                intersect++;
            }
        }
        return intersect;
    }

    void mergesort(int[] a) {

    }

    int binarySearch(int[] a, int x) {
        return -1;
    }

}