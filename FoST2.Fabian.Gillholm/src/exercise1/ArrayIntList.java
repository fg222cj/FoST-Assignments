package exercise1;

import da1031.AbstractIntCollection;
import da1031.IntList;

/**
 * Created by Fabian Gillholm on 2015-09-22.
 * See interface for details about what each function does.
 */
public class ArrayIntList extends AbstractIntCollection implements IntList {
    public void add(int n) {
        if(this.values.length == this.size) {
            this.resize();
        }
        this.values[this.size++] = n;
    }

    public void addAt(int n, int index) {
        if(this.values.length == this.size) {
            this.resize();
        }

        for(int i = this.size; i >= index; i--) {
            this.values[i] = this.values[i - 1];
        }
        this.values[index] = n;
        this.size++;
    }

    public void remove(int index) {
        for(int i = index; i < size; i++) {
            this.values[i] = this.values[i + 1];
        }
        this.size--;
    }

    public int get(int index) {
        return this.values[index];
    }

    public int indexOf(int n) {
        for(int i = 0; i < this.size; i++) {
            if(this.values[i] == n) {
                return i;
            }
        }
        return -1;
    }
}
