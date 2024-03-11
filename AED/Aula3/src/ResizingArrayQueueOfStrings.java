public class ResizingArrayQueueOfStrings {

    private String[] queue;
    private int first, last;
    public ResizingArrayQueueOfStrings() {
        queue = new String[2];
        last = 0; first = 0;
    }

    public void enqueue(String item) {
        if (last == queue.length) {
            resize(2 * queue.length);
        }
        queue[last++] = item;
    }


    public String dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue underflow ...");
        }
        String item = queue[first];
        queue[first++] = null;
        if(last - first < queue.length / 4)
            resize(queue.length / 2);
        return item;
    }

    public boolean isEmpty() {
        return first == last;
    }

    public int size() {
        if(first <= last)
            return first - last;
        else
            return queue.length - first + last;


    }

    public void shift() {
        String l = queue[last];
        for(int i = first; i < last; i++) {
            queue[i] = queue[i + 1];
        }
        queue[first] = l;
        last++;
    }

    public void resize(int capacity) {
        String[] a = new String[capacity];
        for(int i = first; i < last; i++) {
            a[i - first] = queue[i];
        }
        queue = a;
        last = last - first;
        first = 0;
    }


    public static void main(String[] args) {

    }
}
