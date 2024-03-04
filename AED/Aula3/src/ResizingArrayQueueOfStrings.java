public class ResizingArrayQueueOfStrings {

    private String[] queue;
    private int N = 0;
    public ResizingArrayQueueOfStrings() {
        queue = new String[1];
        N = queue.length;
    }

    public void enqueue(String item) {
        if(N == queue.length) {
            queue[N++] = item;
        }
    }

    public String dequeue() {
        if(N == 0) {
            System.out.println("A string já está vazia.");
        }
        String item = queue[0];
        for(int i = 0; i < N - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[--N] = null;
        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return queue.length;
    }

    public void shift() {
        String item = queue[N - 1];
        for(int i = 0; i < N - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[0] = item;
    }

    public static void main(String[] args) {

    }
}
