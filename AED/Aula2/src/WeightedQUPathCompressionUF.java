public class WeightedQUPathCompressionUF {

    private int[] size;
    private int[] id;

    public WeightedQUPathCompressionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pid = root(p);
        int qid = root(q);

        if (pid == qid) {
            System.out.println("Already connected");
        }

        if (pid > qid) {
            id[qid] = pid;
            size[qid] += size[pid];
        } else {
            id[pid] = qid;
            size[pid] += size[qid];
        }
    }

}
