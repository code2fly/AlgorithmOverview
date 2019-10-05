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

  2. **Quick union -** 
  