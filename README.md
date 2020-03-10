
[Clusters Of Adjacent Cells (Java implementation)](https://github.com/antukhov/assessment-tests/blob/master/ClustersOfAdjacentCells.java)
 
 Given a field represented as regular two-sized array filled with values 0 or 1

| X/Y | 0 | 1 | 2 | 3 | 4 |
|--|--|--|--|--|--|
| **0** | **1** | 0 | 0 | 0 | 0
| **1** | **1** | **1** | 0 | 0 | 0
| **2** | 0 | 0 | **1** | 0 | 0
| **3** | **1** | 0 | 0 | 0 | **1**
| **4** | **1** | **1** | **1** | **1** | **1**

Let's imagine that every 1s-cell is a separated house and all 0s-cells are trees.
Houses who have adjacent cells on X or Y axes are clusters. The diagonal joint between them doesn't work.
 
In example above [X,Y]:
- [0,0], [1,0], [1,1] - 1st cluster on the 1st and 2nd rows
- [2,2] - 2nd cluster which doesn't have adjacent cells on X or Y axis with value 1
- 3rd cluster placed on rows with index 3 and 4, it contains 7 houses
 
 **Final target: to find amount clusters within the given field**
