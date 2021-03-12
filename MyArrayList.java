import java.util.ArrayList;

/**
 * An implementation of the ArrayList data structure
 * 
 * @author
 */
public class MyArrayList<T> {
    protected T[] a;
    protected int size;

    /**
     * Constructor
     */
    public MyArrayList() //makes new array list and sets size at 0
    {
        a = (T[]) new Object[10];
        size=0;
    }


    /**
     * Adds an item to the end of the list
     * @param item the items to add
     */
    public void add(T item) //adds item to end of arraylist
    {
        if (size == a.length) {
            grow_array();
        }
        a[size++] = item;
    }

    /**
     * Adds an item to the list at a certain position
     * @param pos the position to add the item at
     * @param item the item to add
     */

    public void add(int pos, T item) //adds item at given position
    {
        if (size == a.length) {
            grow_array();
        }
        for (int i = size; i > pos; i--)
            a[i] = a[i- 1];
        a[pos] = item;
        ++size;

    }

    /**
     * Gets the item at the position
     * @param pos position to get the item
     */
    public T get(int pos) throws Exception // returns item at index
    {
        if (pos < 0 || pos >= size) {
            throw new Exception("Invalid Position");
        }
        return a[pos];
    }

    /**
     * Removes and returns the item at a position
     * @param pos the position to remove
     * @return the item at the position
     */

    public T remove(int pos) throws Exception //returns item after removing it from arraylist
    {
        if (pos < 0 || pos >= size) {
            throw new Exception("Invalid Position");
        }

        // copy item in the array
        T item = a[pos];

        // move stuff in array over
        for (int i = pos; i <size-1 ; i++) {
            a[i] = a[i+1];
        }

        size -= 1;
        return item;
    }

    /**
     * The size of the arraylist
     * @return
     */
    public int size() //returns size
    {
        return size;
    }

    /**
     * Rotates the array to the right by k steps.
     * @param k the number of steps to rotate right
     */

    // setup private helper function that rotates reverses the array
    public void reverse(T [] arr, int start, int end) {
        while (start<end) {
            T temp = (T) arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate(int k) {
        k = k % a.length;
        // first reverse all numbers
        reverse(a, 0, size-1);
        reverse(a, 0 , k-1);
        reverse(a, k, size-1);
    }


    /**
     * Dynamically grow the array with the size of the ArrayList
     */
    private void grow_array() //doubles size of array
    {
        T [] new_arr = (T[]) new Object[size *= 2];
        for (int i = 0; i < size; i++)
            new_arr[i] = a[i];
        a = new_arr;
    }

    @Override
    public String toString()
    {
        String result = "";
        for(int i=0; i< size; i++)
        {
            result = result + a[i] + " ";
        }
        return result;
    }

}