/*
Name: Cui Li LIM
SRN: 201813956
 */

// This is incomplete (no static boolean 'found', etc), and I may have misunderstood the task?

class BinarySearch {

    static void printArray(int[] x) {
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }

    }

    // x is the sorted array we're searching in, key is the element we are looking for.
    // we search from x[i-1 to x[j-1].
    static int binsearch (int key, int[] x, int i, int j) {
        int k = (j-i)/2; // because integer automatically deletes the decimal, it is floored.
        if (k == 0) {
            return k;
        } else if (x[k] == key) {
            return k;
        } else if (x[k] > key) {
            return binsearch(key,x,i,k);
        } else if (x[k] < key) {
            return binsearch(key,x,k,j);
        }
        return binsearch(key,x,i,j);
    }

    public static void main (String[] args) {
        if (args.length < 1) {
            System.out.println("Please give me a key to search for and its range. Thanks");
            return;
        }
        int key = Integer.parseInt(args[0]);
        int [] x = {1,3,6,7,7,7,9};
        int i = Integer.parseInt(args[1]) - 1;
            if (i < 0) {
                return;
            }
        int j = Integer.parseInt(args[2]) - 1;
            if (j >= x.length) {
                return;
            }
        System.out.print("Testing a small array: ");
        printArray(x);
        System.out.println();
        System.out.print("The key " + key + " is found at index ");
        System.out.print(binsearch(key,x,i,j));
        System.out.println(" within the array indexes of " + i + " and " + j);
    }

}