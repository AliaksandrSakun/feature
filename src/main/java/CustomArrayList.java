import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<E> {

    private E[] array;
    private int size;

    public CustomArrayList() {
        this(10);
    }

    public CustomArrayList(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("illegal size:" + initSize);
        }
        this.array = (E[]) new Object[initSize];
    }

    public boolean add(int index, E element) {
        checkRange(index);
        ensureCapacity(this.size + 1);
        System.arraycopy(this.array, index, array, index + 1, size - index);
        array[index] = element;
        this.size++;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] newArray = c.toArray();

        while (array.length < size + newArray.length) {
            increaseArrayCapacity();
        }
        System.arraycopy(newArray, 0, array, size, newArray.length);
        size += newArray.length;
        return true;
    }

    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.array[i] = null;
        }
        this.size = 0;
    }

    public E get(int index) {
        E e = this.array[index];
        return e;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void remove(int index) {
        System.arraycopy(array, index++, array, index, size - index);
        array[size] = null;
        size--;
    }


    public void remove(E element) {
        if (element == null) {
            for (int i = 0; i < this.size; i++) {
                if (this.array[i] == null) {
                    fastRemove(i);
                    return;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.array[i])) {
                    fastRemove(i);
                    return;
                }
            }
        }
    }

    public void sort(Comparator<? super E> c) {
        if (c == null) {
            sort(array, 0, size - 1, Comparator.naturalOrder());
        } else {
            sort(array, 0, size - 1, c);
        }
    }

    private void sort(Object[] arr, int left, int right, Comparator c) {
        if (left < right) {
            int mid = quick(arr, left, right, c);
            sort(arr, left, mid - 1, c);
            sort(arr, mid, right, c);
        }
    }

    private int quick(Object[] arr, int left, int right, Comparator c) {
        Object mid = arr[left + (right - left) / 2];
        while (left <= right) {
            while (c.compare(arr[left], mid) < 0) {
                left++;
            }

            while (c.compare(arr[right], mid) > 0) {
                right--;
            }
        }
        return left;
    }

    private void ensureCapacity(int needCapacity) {
        if (needCapacity > array.length) {
            Object[] oldElements = this.array;
            int newSize = this.size * 2 + 1;
            this.array = (E[]) new Object[newSize];
            this.array = (E[]) Arrays.copyOf(oldElements, newSize);
        }
    }

    private void increaseArrayCapacity() {
        E[] newArr = (E[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArr, 0, size);
        array = newArr;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= (this.size + 1)) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
    }

    private void fastRemove(int index) {
        int movedNumber = this.size - index - 1;
        if (movedNumber > 0) {
            System.arraycopy(this.array, index + 1, this.array, index, movedNumber);
        }
        this.array[--this.size] = null;
    }
}
