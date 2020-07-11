package stack;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackAsArray extends AbstractContainer
        implements Stack {

    protected Object[] array;

    public StackAsArray(int size) {
        array = new Object[size];
    }
    int count;

    public void purge() {
        while (count > 0) {
            array[--count] = null;
        }
    }

    public Object getTop() {
        if (count == 0) {
            try {
                throw new ContainerEmptyException();
            } catch (ContainerEmptyException ex) {
                Logger.getLogger(StackAsArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return array[count - 1];
        }
        return 0;
    }

    public void push(Object object) {
        if (count == array.length) {
            try {
                throw new ContainerFullException();
            } catch (ContainerFullException ex) {
                Logger.getLogger(StackAsArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            array[count++] = object;
        }
    }

    public Object pop() {
        if (count == 0) {
            try {
                throw new ContainerEmptyException();
            } catch (ContainerEmptyException ex) {
                Logger.getLogger(StackAsArray.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Object result = array[--count];
            array[count] = null;
            return result;
        }
        return 0;

    }

    public Iterator iterator() {
        return new Iterator() {

            private int position = count - 1;

            public boolean hasNext() {
                return position >= 0;
            }

            public Object next() {
                if (position < 0) {
                    try {
                        throw new NoSuchElemenException();
                    } catch (NoSuchElemenException ex) {
                        Logger.getLogger(StackAsArray.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return array[position--];
                }
                return 0;
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
}
