
public class UnionFindUsingQuickFind implements UnionFind {

    private int[] objects;

    public UnionFindUsingQuickFind(int N) {
        this.objects = new int[N];
        // assign initial val
        for (int i=0 ; i < N; i++) {
            objects[i] = i;
        }
        
    }


    // union part is complex as all objects entry needs to be changed which are part of component that are being unioned
    // almost an O(N) operation for union (bad if there are too many unions)
    public void union(int p, int q) {
        if(connected(p,q)) {
            return ;
        }
        int currentValue = objects[p];
        int valueToChangeTo = objects[q];
        for (int i = 0; i < objects.length  ; i++) {
            if(objects[i] == currentValue) {
                objects[i] = valueToChangeTo;
            }
        }
    }



    // connected query is quick and simple and executes in O(1)
    public boolean connected(int p , int q ) {
        if(objects[p] == objects[q]) {
            return true;
        }
        return false;
    }


    public void showData() {
        System.out.print("[ ");
        for(int i =0; i < this.objects.length ; i++ ) {
            System.out.print( this.objects[i] + " ," );
        }
        System.out.print(" ]");
    }

}