# 4th semester Graphs Theory assessment

## GraphMatrix
An <b>adjacency matrix</b> based data structure to provide relationship between vertices on a given graph.

Constraints:

<ul>
    <li>Simple graphs only: no parallel or loop edges</li>
    <li>Digraphs or non directed graphs</li>
</ul> 

## Methods
<ol>
    <li>Complete graph: iterates through every edge. Returns false in case there's not an edge in between two vertices.</li>
    <li>Isomorphism</li>
    <li>Range search</li>
    <li>Shortest paths</li>
    <li>Min spanning tree</li>
</ol>

## Matrices examples:

Non-directed:     (A - B)
|     |  A  |  B  |
|---- |---- |---- |
|  A  |  0  |  1  |
|  B  |  1  |  0  |

Digraph:          (A -> B)
|     |  A  |  B  |
|---- |---- |---- |
|  A  |  0  |  1  |
|  B  |  0  |  0  |     

Weighted:         (A - B: 3)
|     |  A  |  B  |
|---- |---- |---- |
|  A  |  0  |  3  |
|  B  |  3  |  0  |

Weighted digraoh: (B -> A: 3)
|     |  A  |  B  |
|---- |---- |---- |
|  A  |  0  |  0  |
|  B  |  3  |  0  |
