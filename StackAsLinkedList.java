package stack;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StackAsLinkedList extends AbstractContainer
        implements Stack {

    private static class MyLinkedList {

        private Element getHead() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private static class Element {

            public Element() {
            }

            private Object getData() {
                throw new UnsupportedOperationException("Not yet implemented");
            }

            private Element getNext() {
                throw new UnsupportedOperationException("Not yet implemented");
            }
        }

        public MyLinkedList() {
        }

        private void purge() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private void prepend(Object obj) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private Object getFirst() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private void extractFirst() {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
    int count;
    protected MyLinkedList list;

    public StackAsLinkedList() {
        list = new MyLinkedList();
    }

    public void purge() {
        list.purge();
        count = 0;
    }

    public Object getTop() {
        if (count == 0) {
            try {
                throw new ContainerEmptyException();
            } catch (ContainerEmptyException ex) {
                Logger.getLogger(StackAsLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            return list.getFirst();
        }
        return 0;
    }

    public void push(Object obj) {
        list.prepend(obj);
        count++;

    }

    public Object pop() {
        if (count == 0) {
            try {
                throw new ContainerEmptyException();
            } catch (ContainerEmptyException ex) {
                Logger.getLogger(StackAsLinkedList.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Object obj = list.getFirst();
            list.extractFirst();
            count--;
            return obj;
        }
        return 0;
    }

    public Iterator iterator() {
        return new Iterator() {

            private MyLinkedList.Element position =
                    list.getHead();

            public boolean hasNext() {
                return position != null;
            }

            public Object next() {
                if (position == null) {
                    try {
                        throw new NoSuchElemenException();
                    } catch (NoSuchElemenException ex) {
                        Logger.getLogger(StackAsLinkedList.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    Object obj = position.getData();
                    position = position.getNext();
                    return obj;
                }
                return 0;
            }

            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
    }
}
