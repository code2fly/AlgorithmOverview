public class UnionFindClient {

    public static void main(String[] args) {
        int numberOfObjects = 10;
        UnionFind uf = new UnionFindUsingQuickFind(numberOfObjects);
        uf.union(0,5);
        uf.union(5,6);
        uf.union(1,6);
        uf.union(1,2);
        uf.union(2,7);
        uf.union(3,8);
        uf.union(3,4);
        uf.union(9,4);

        System.out.println("Conntected(0,1) : " + uf.connected(0,1));
        System.out.println("Conntected(0,8) : " + uf.connected(0,8));
        System.out.println("Conntected(3,9) : " + uf.connected(3,9));
        
    }


}