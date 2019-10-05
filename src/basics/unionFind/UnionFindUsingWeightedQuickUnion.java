public class UnionFindUsingWeightedQuickUnion implements UnionFind {

private int[] id;
private int[] sz;

    public UnionFindUsingWeightedQuickUnion(int N) {
        this.id = new int[N];
        this.sz = new int[N];
        // assign initial val
        for (int i=0 ; i < N; i++) {
            id[i] = i;
            sz[i] = 1
        }
        
    }


    // union part is complex as all objects entry needs to be changed which are part of component that are being unioned
    // almost an O(N) operation for union (bad if there are too many unions)
    @Override
    public void union(int p, int q) {
        int rootOfP = getRoot(p);
        int rootOfQ = getRoot(q);
        if(rootOfP == rootOfQ) {
            return;
        }
        if sz[rootOfP] < sz[rootOfQ]  {
            this.id[rootOfP] = rootOfQ;
            sz[rootOfQ] += sz[rootOfP] ;
        }
        else {
            this.id[rootOfQ] = rootOfP;
            sz[rootOfP] += sz[rootOfQ];
        }

    }



    // connected query is quick and simple and executes in O(1)
    @Override
    public boolean connected(int p , int q ) {
        if(getRoot(p) == getRoot(q)) {
            return true;
        }
        return false;
    }


    private int getRoot(int object) {
        int item = object;
        int parent = this.id[item];
        while(item != parent) {
            item = parent;
            parent = this.id[item];
        }
        return item;
    }

    public void showData() {
        System.out.print("[ ");
        for(int i =0; i < this.id.length ; i++ ) {
            System.out.print( this.id[i] + " ," );
        }
        System.out.print(" ]");
    }



}