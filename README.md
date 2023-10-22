# 4th semester Graphs Theory assignment

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
    <li>Depth search</li>
    <li>Shortest paths</li>
</ol>

## Matrices examples:

<table>
    <caption>Non-directed:</caption>
    <tr>
        <th></th> <th>A</th> <th>B</th>
    </tr>
    <tr>
        <th>A</th> <td>0</td> <td>1</td>
    </tr>
    <tr>
        <th>B</th> <td>1</td> <td>0</td>
    </tr>
</table>

<table>
    <caption>Directed:</caption>
    <tr>
        <th></th> <th>A</th> <th>B</th>
    </tr>
    <tr>
        <th>A</th> <td>0</td> <td>1</td>
    </tr>
    <tr>
        <th>B</th> <td>0</td> <td>0</td>
    </tr>
</table>

<table>
    <caption>Weighted:</caption>
    <tr>
        <th></th> <th>A</th> <th>B</th>
    </tr>
    <tr>
        <th>A</th> <td>0</td> <td>3</td>
    </tr>
    <tr>
        <th>B</th> <td>3</td> <td>0</td>
    </tr>
</table>

<table>
    <caption>Weighted Directed:</caption>
    <tr>
        <th></th> <th>A</th> <th>B</th>
    </tr>
    <tr>
        <th>A</th> <td>0</td> <td>0</td>
    </tr>
    <tr>
        <th>B</th> <td>3</td> <td>0</td>
    </tr>
</table>
