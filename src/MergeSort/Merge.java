package MergeSort;

public class Merge<T extends Comparable> {

    private T[] items, temp;

    public Merge(T[] items) {
        this.items = items;
        this.temp = (T[]) new Comparable[items.length];
    }
    
    public void sort() {
        this.sort(0, this.items.length - 1);
    }

    private void sort(int left, int right) {
        if (left >= right)
        {
            return;
        }

        //find the middle
        int mid = left + ((right - left) / 2);

        //sort the left half
        this.sort(left, mid);

        //sort the right half
        this.sort(mid + 1, right);

        //merge both halves
        this.merge(left, mid, right);
        
    }


    private void merge(int left, int mid, int right)
    {
        int i = left;// Index value in main array

        int l = left;// Index to the left half
        int r = mid + 1;// Index to the right half

        // update temp as items changed
        for (int x = left; x <= right; x++)
        {
            this.temp[x] = this.items[x];
        }

        while (l <= mid || r <= right)
        {
            if (l > mid)
            {
                //if left sorted, then sort right
                this.items[i] = this.temp[r++];
            }
            else if (r > right)
            {
                //if right sorted, then sort left
                this.items[i] = this.temp[l++];
            }
            else if (this.temp[l].compareTo(this.temp[r]) > 0)
            {
                // If temp[l] is > temp[r]
                this.items[i] = this.temp[r++];
            }
            else
            {
                // If temp[l] is <= temp[r]
                this.items[i] = this.temp[l++];
            }

            i++;
        }
    }

    public T[] getSortedItems()
    {
        return this.items;
    }
}