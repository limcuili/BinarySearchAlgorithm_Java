class BinarySearch {

    static boolean found;

    static int counter;

    static int binsearch(int key, int[] x, int start, int end) {
        // give a sorted array x, searched for key amount x[start]...x[end-1]
        // and returns the smallest index i such taht x[i] >= key if there is such an i,
        // otherwise return end.

        counter++; // using counter for Exercise 3.4 to count iterations
        if (end == start) {
            found = (start < x.length && key == x[start]);
            return start;
        }
        int mid = (start+end)/2;
        if (key <= x[mid]) {
            return binsearch(key, x, start, mid);
        } else {
            return binsearch(key, x,mid+1, end);
        }
    }

    // This is a wrapper method - note that Java allows the same names, however
    // it must have a different signature, ie. parameter requirements are different.
    static int binsearch(int key, int[] x) {
        found = false;
        counter = 0;
        return binsearch(key,x,0,x.length);
    }

    // For Exercise 3.4 - observe we need a test search to reinitialize counter and boolean found.
    // Tests are kept separate from development
    static void testSearch (int key, int[] x) {
        found = false;
        counter = 0;
        int i = binsearch(key,x,0,x.length);
        if (found) {
            System.out.print("Key " + key + " found at index " + i );
        } else {
            System.out.print("Key " + key + " not found, should be at index " + i);
        }
        System.out.println(", after " + counter + " binary search iterations.");
    }

    // optional exercise
    static int[] insert(int key, int[] x) {
        int position = binsearch(key,x);
        int[] y = new int[x.length + 1];
        for (int i = 0; i < position; i++) {
            y[i] = x[i];
        }
        y[position] = key;
        for (int i = position+1; i < y.length; i++) {
            y[i] = x[i-1];
        }
        return y;
    }

    public static void main(String[] args) {
        int[] x;
        // testing Exercise 3.2
        x = new int[] {1,4,4,4,8,9};
        System.out.println(binsearch(8,x,0,6));
        System.out.println(binsearch(8,x,3,5));
        System.out.println(binsearch(4,x,0,6));
        System.out.println(binsearch(7,x,0,6));
        x = new int[] {1,2,3,4,5};
        System.out.println(binsearch(0,x,0,5));
        System.out.println(binsearch(6,x,0,5));

        // testing Exercise 3.4
        x = new int[]{1, 3, 6, 7, 7, 7, 9};
        testSearch(0, x);
        testSearch(1, x);
        testSearch(7, x);
        testSearch(10, x);

        System.out.println();
        x = new int[10_000_000];
        for (int i = 0; i < x.length; i++) {
            x[i] = 2*i;
        }
        testSearch(5_000_000, x);
        testSearch(5_000_001, x);

        System.out.println();
        for (int i = 0; i < x.length; i++) {
            x[i] = 10;
        }
        testSearch(10,x);
        testSearch(9,x);
        testSearch(11,x);

        System.out.println();
        for (int i = 0; i < x.length/2 -1; i++) {
            x[i] = 1;
        }
        for (int i = x.length/2 -1; i < x.length; i++) {
            x[i] = 2;
        }
        testSearch(0,x);
        testSearch(1,x);
        testSearch(2,x);
        testSearch(3,x);

        // Test optional exercise
        System.out.println();
        x = new int[] {1,3,6,7,7,7,9};
        x = insert(7, x);
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println();

    }


}