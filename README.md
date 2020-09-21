# Data-Structures-with-Java

# Description
This repository is designed to emulate certain components of the Java Collections Framework and to demonstrate their 
usage in modern software engineering. An emphasis is placed on the implementation of Collections and the management 
of their use. 

Additionally, this sample provides compile-time type safety for the given collections by leveraging Java's Generic 
Programming facilities.

# Usage
Since the code is for demonstration only, several components of the Java Collections Framework are not implemented. 
However, sample code for many of the most common Collections, as well as their sample usages, are provided. For more 
information on their usage, please see the Projects folder.

# Libraries
Please visit https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html for more detailed information on the
Java Collections Framework

# System Components

***ArrayQueue***\
An ArrayQueue is a First-in/First-out data structure of ordered items such that items can be inserted at one end
(called the rear) and removed from the other end (called the front).
1. Beyond Integer.MAX_VALUE elements, the size method does not work.
2. An ArrayQueue's capacity cannot exceed Integer.MAX_VALUE.
3. The capacity of this ArrayQueue can change after it's created by directly or indirectly activated the 
ensureCapacity() method. However, the capacity is limited by the amount of free memory. Any attempt to exceed the free 
memory will result in an OutOfMemoryError.

***DoubleArraySeq***\
A DoubleArraySeq is a collection of double numbers. The sequence can have a special "current element", which is 
specified and accessed through four methods available in the sequence class (start, getCurrent, advance, and isCurrent).
1. The capacity of a sequence can change after it's created, but the maximum capacity is limited by the amount of free 
memory on the machine. The constructor, addAfter, addBefore, clone, and concatenation will result in an 
OutOfMemoryError when free memory is exhausted.
2. A sequence's capacity cannot exceed the maximum integer 2,147,483,647 (Integer.MAX_VALUE). Any attempt to create a 
larger capacity results in a failure due to an arithmetic overflow.

***DoubleLinkedSeq***\
A DoubleLinkedSeq is a sequence of double numbers. The sequence can have a special "current element", which is 
specified and accessed through four methods (start, getCurrent, advance, and isCurrent).
1. Beyond Integer.MAX_VALUE elements, the size method does not work.

***HashTable***\
A HashTable is a collection used to map keys to values. Any non-null object can be used as a key or as a value.
Traditionally, the class is implemented using Java Generics but, our implementation will make use of integer keys
and String values.
1. A HashTable's performance is affected by it's initial capacity, which should always be a twin prime to optimize
performance.
2. This implementation using Open Addressing to resolve collisions. Meaning that if multiple values are hashed to the 
same bucket, then we search for the next open bucket in a sequential manner.

***LinkedList***\
A LinkedList is a sequence of generic types. The sequence can have a special "current element", which is specified and 
accessed through four methods (start, getCurrent, advance, and isCurrent).
1. Beyond Integer.MAX_VALUE elements, the size method does not work.

***LinkedQueue***\
A LinkedQueue is a First-in/First-out data structure of ordered items such that items can be inserted at one end
(called the rear) and removed from the other end (called the front). The item at the front of the Queue is called
the first item.
1. Beyond Integer.MAX_VALUE elements, the size method does not work.

***LinkedStack***\
A LinkedStack is a sequence of nodes. The LinkedStack is a first-in/last-out data structure meaning that items are
added to the top of the stack and only removed when every item on top of it has been removed.
1. Beyond Integer.MAX_VALUE elements, the size method does not work.

***List***\
An interface for the List based Collections, which provides the user precise control over where in the list each 
element is inserted. Beyond this control, the interface stipulates several helper methods such as isCurrent, size, 
advance, among others.

***Map***\
An interface for the Map based Collections, which provides a mechanism to map key value pairs. Additionally, a map 
cannot contain duplicate keys and each key can map to at most one value.

***Queue***\
An interface for the Queue based Collections, which provides a mechanism for a First-in/First-out data structure of 
ordered items such that items can be inserted at one end (called the rear) and removed from the other end (called the 
front). Additionally, the interface stipulates several helper methods such has isEmpty and size.

***Edge***\
An edge is a link in a graph that connects two vertices. We sometimes say that the edge "connects" its two vertices
in an undirected graph. Each edge is associated with a source and target vertices in a directed graph.

The order of the two connected vertices in an undirected graph is unimportant, so it does not matter whether we say
"This edge connects vertices u and v", or "This edge connects vertices v and u." However, the order is important in
a directed graph.

***EdgeList***\
An EdgeList is a linked list used to connect n vertices in a Graph. List number i provides the connections for
vertex i. To be specific: For each entry j in list number i, there is an edge from i to j. Representing a graph as
an edge list is more efficient than an adjacency matrix representation when iterating a loop that executes for each
edge with a particular source vertex is a more common operation.

***Graph***\
A Graph is a non-linear data structure consisting of nodes and links between the nodes. A Graph can come in several
varieties including an undirected graph or directed graph. Graphs can also have multiple edges and allow for loops;
however, our implementation restricts these use cases and requires that the Graph not have multiple edges or loops.
1. Beyond Integer.MAX_VALUE, the size method, the size method does not work.

***GraphQueue***\
A GraphQueue is used to implement a breadth-first search of a Graph. The queue keeps track of which vertices might
still have unprocessed neighbors. The search beings with a starting vertex, which is processed, marked, and placed
in this queue.

***Vertex***\
A Vertex is used by a Graph and has a label and an edge connecting itself to another Vertex in the graph. If the label 
and edges are a null reference, then the Vertex has no connections in the Graph.

***BTNode***\
A BTNode<E> provides a node for a binary tree with a reference to an E object as the data in each node.
1. Beyond Integer.MAX_VALUE elements, treeSize is wrong.
2. Nodes can be dynamically created or destroyed (not subject to static memory allocation like arrays). However, they 
are limited by the amount of free memory on the heap.

***DoubleNode***\
A DoubleNode provides a node for a linked list with double data in each node.
1. Lists can be of any length, limited only by the amount of free memory on the heap. But beyond Integer.MAX_VALUE, the 
answer from listLength is incorrect because of arithmetic overflow.

***GraphNode***\
A GraphNode is used to implement a breadth-first search of a Graph. The node is used by a queue to  keep track of
which vertices might still have unprocessed neighbors. The search beings with a starting vertex, which is processed,
marked, and placed in this queue.

***Node***\
A generic Node is an object that contains data and a connection to any subsequent element through a reference link.
1. Nodes can be dynamically created or destroyed (not subject to static memory allocation like arrays). However, they 
are limited only by the amount of free memory on the heap and beyond Integer.MAX_VALUE, the answer from any size 
operation is incorrect.

# Limitations
This library is limited in scope and does not provide the full capabilities of the Java Collections Framework. To 
handle more complex use cases, please visit https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html
