## Steps to developing usable algorithm (we will use the same in union find )- 
---------
![alt](/resources/images/01.jpeg) 

### Union Find algo - 
  * A set of algorithms to solve the dynamic connectivity problem.

## 1. Model the Problem - 

**Problem -** Dynamic connectivity problem
  * Given N set of objects check if they are connected or not.
    * for this we postulate/assume that objects are connected each other via union command
    * can be checked if they are connected or not using find/connected query. 


**Model the problem**   - understand main elements of the problem that needs to be solved i.e. in this case Objects and connection between those objects.

  - **Model the objects** - 
    - Applications of these union find algo involves objects of all types such as pixels in images, computers in network, friends in social network etc..
    - For programming purpose to reduce complexity we associate those objects with a name or better with integers 0 to N-1.
      - using integers makes it easy as these integers can now be used as index to an array to quickly access info relevant to each object.
      - also this would suppress lot of irrelavant details for union find(which can anytime be enriched using things like symbol table)
  

  - **Model the connections** - 
    - we assume that 'is connected to' here is an equivanlence relation (reflexive,symmetric,transitive)
    - hence we can divide objects into sets of connected components i.e. {0} {1,2,5,6,7} -> 2 connected components
    - basically our algo's rely on connected components to efficiently answer connected query.


  - **Implementing the operations** - 
    - i) find query - check if 2 objects are in same connected component.
    - ii) union command - replace components containing 2 objects with their union.

  - **Define UnionFind data-type(API)**- 
  ```java
    public class UnionFind {

      UnionFind(int N);   // initialize union find DS with N objects (0 to N-1)
      
      public abstract void union(int p, int q);  // add connection b/w p and q

      public abstract connected(int p , int q ); // are p and q in the same component ??

    }
  
  ```


## 2. Find algo to solve it - 

  1. **Quick find -(eager approach)** 
  - Data structure 
      - integer array id[] of length N
      - Interpretation: p and q are connected if an only if they have same id.


![alt](/resources/images/02.PNG)


  - ***find implementation*** - check if p and q have same id.
  - ***union implementation*** - to merge components containing p and q , change all entries containing value id[p] with value id[q]
    
 - **Problems with Quick find** - 
    * quick find is too slow for huge problems, initialize is O(N), union is O(N) , find is O(1)
    * union is too expensive - it takes N^2(quardratic) array access to process sequence of N union commands on N objects.
      * Quardratic algorithms do not scale basically if we have 1 billion objects and it takes 1 second for computer to access those 10^9 objects , in order to perform
      union operations on all those 10^9 objects it will take around 10^18 seconds which is around 35 years.

![alt](/resources/images/03.PNG)

  2. **Quick union -(lazy approach to algo design as we try to avoid doing work until we have to)** 
  - Data structure 
      - integer array id[] of length N
      - Interpretation: id[i] is parent of i.
      - Root of i is id[id[id[.....id[i]]]] - find it until it stops changing.


![alt](/resources/images/04.PNG)


  - ***find implementation*** - check if p and q have same root.
  - ***union implementation*** - to merge components change the root of p to point to root of q i.e. set id of p's root to id of q's root.
    
 - **Problems with Quick Union** - 
    * quick union is also too slow for huge problems, initialize is O(N), union is O(N) - need to find roots , find is O(N)


![alt](/resources/images/05.PNG)



## 3. Find solutions to problems in algo - ***Quick Union improvements*** - 

  1. Weighting - 
      * Weighted quick union -  balance tree by linking root of smaller tree to root of larger tree.
      * Depth of any node x can be atmost lg N i.e. log N to the base 2. explain why???
      * intialization is O(N) , union is O(lg N) , find/connected query is O(lg N)
      * can we optimize it further ?? yes .

  2. Path compresssion
      * basically here just after computing the root of a node 'p', set the root of each examined node to point to that root.(this way the tree gets flattened.)
      * 
