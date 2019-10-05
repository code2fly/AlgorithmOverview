
public class UnionFindUsingQuickUnion implements UnionFind {

    private int[] id;

    public UnionFindUsingQuickUnion(int N) {
        this.id = new int[N];
        // assign initial val
        for (int i=0 ; i < N; i++) {
            id[i] = i;
        }
        
    }


    // union part is complex as all objects entry needs to be changed which are part of component that are being unioned
    // almost an O(N) operation for union (bad if there are too many unions)
    public void union(int p, int q) {
        int rootOfP = getRoot(p);
        this.id[rootOfP] = getRoot(q);
    }



    // connected query is quick and simple and executes in O(1)
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