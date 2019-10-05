
/**
Goal - Desgin efficient DS for Union Find
    - keep in mind while designing algo (to design optimized algo taking both into perspective.)
        - no. of objects N can be huge
        - no. of operations(union or connected) M can be huge
 */
public interface UnionFind {

    //  UnionFind(int N);   - initialize union find DS with N objects (0 to N-1)
    
    public void union(int p, int q);  // add connection b/w p and q

    public boolean connected(int p , int q ); // are p and q in the same component ??

}
