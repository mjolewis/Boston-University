// FILE BTNode.java from the package edu.bostonuniversity.nodes

package edu.bostonuniversity.nodes;

/**********************************************************************************************************************
 * A BTNode<E> provides a node for a binary tree with a reference to an E object as the data in each node.
 *
 * @note
 *  1. Beyond Integer.MAX_VALUE elements, treeSize is wrong.
 *  2. Nodes can be dynamically created or destroyed (not subject to static memory allocation like arrays). However,
 *     they are limited by the amount of free memory on the heap.
 *
 * @author mlewis
 * @version Dec 7, 2019
 *********************************************************************************************************************/

public class BTNode<E> {
    // Invariant of the BTNode<E> class
    //  1. The instance variable count counts the number of times data has occurred in the tree. Thus, our programming
    //     will prevent duplicate entries in the tree and instead count the number of duplicates.
    //  2. The instance variable data stores the data of each node.
    //  3. The instance variable left is a reference to the left child of the activating node. If there is no left
    //     child, left is a null reference.
    //  4. The instance variable right is a reference to the right child of the activating node. If there is no right
    //     child, right is a null reference.
    private int count;
    private E data;
    private BTNode<E> left;
    private BTNode<E> right;

    /**
     * public BTNode()
     * Initialize an empty binary tree.
     * @postcondition
     *  An empty binary tree has been initialized.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this binary tree.
     */
    public BTNode() {
        data = null;
        left = null;
        right = null;
    }

    /**
     * public BTNode(E data, BTNode<E> left, BTNode<E> right)
     * Initialize a new binary tree with the specified data and child references (left and right). Note that the child
     * reference variables can be null, which indicates that there is no left and/or right child(ren).
     * @param data
     *  The initial data for this new node.
     * @param left
     *  The initial reference to this nodes left child. Note that this can be a null reference, which indicates that
     *  there is no left child.
     * @param right
     *  The initial reference to this nodes right child. Note that this can be a null reference, which indicates that
     *  there is no right child.
     */
    public BTNode(E data, BTNode<E> left, BTNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * public int getCount()
     * Accessor method that returns how many times this node has been accessed.
     * @return int
     *  The number of times this node has been accessed.
     */
    public int getCount() { return count; }

    /**
     * public E getData()
     * Accessor method to retrieve the activating nodes data.
     * @return E
     *  The activating nodes data.
     */
    public E getData() { return data; }

    /**
     * public BTNode<E> getLeft()
     * Accessor method that returns a reference to the activating nodes left child.
     * @return BTNode<E>
     *  A reference to this nodes left child. Note that this may be a null reference, which indicates that there is no
     *  left child.
     */
    public BTNode<E> getLeft() { return left; }

    /**
     * public E getLeftmostData()
     * Accessor method that returns the data from the leftmost node of the activating node.
     * @return E
     *  The data from the deepest node that can be reached by following the activating nodes left path.
     */
    public E getLeftmostData() {
        if (left == null) { return data; }
        return left.getLeftmostData();
    }

    /**
     * public BTNode<E> getRight()
     * Accessor method that returns a reference to the activating nodes right child.
     * @return BTNode<E>
     *  A reference to this nodes right child. Note that this may be a null reference, which indicates that there is no
     *  right child.
     */
    public BTNode<E> getRight() { return right; }

    /**
     * public E getRightmostData()
     * Accessor method that returns the data from the rightmost node of the activating node.
     * @return E
     *  The data from the deepest node that can be reached by following the activating nodes right path.
     */
    public E getRightmostData() {
        if (right == null) { return data; }
        return right.getRightmostData();
    }

    /**
     * public void incrementCount()
     * Mutator method that increments the instance variable count by one.
     * @postcondition
     *  The instance variable count has been incremented by one.
     */
    public void incrementCount() { count++; }

    /**
     * public boolean isLeaf()
     * Accessor method to determine if the activating node is a leaf.
     * @return boolean
     *  True if the activating node is a leaf. Otherwise false.
     */
    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    /**
     * public void inorderPrint()
     * An in-order traversal to print the data from this node and all of its descendants in the binary tree.
     * @postcondition
     *  The data of this node and all of its descendants have been written by System.out.println().
     */
    public void inorderPrint() {
        if (left != null) { left.inorderPrint(); }
        System.out.println(data);
        if (right != null) { right.inorderPrint(); }
    }

    /**
     * public void preorderPrint()
     * An pre-order traversal to print the data from this node and all of its descendants in the binary tree.
     * @postcondition
     *  The data of this node and all of its descendants have been written by System.out.println().
     */
    public void preorderPrint() {
        System.out.println(data);
        if (left != null) { left.preorderPrint(); }
        if (right != null) { right.preorderPrint(); }
    }

    /**
     * public void postorderPrint()
     * An post-order traversal to print the data from this node and all of its descendants in the binary tree.
     * @postcondition
     *  The data of this node and all of its descendants have been written by System.out.println().
     */
    public void postorderPrint() {
        if (left != null) { left.postorderPrint(); }
        if (right != null) { right.postorderPrint(); }
        System.out.println(data);
    }

    /**
     * public BTNode<E> removeLeftmost()
     * Mutator method that removes the left most node starting from the activating nodes root.
     * @return BTNode<E>
     *  A reference to the root of the newly modified binary tree. Note that the return value can be null if the
     *  original binary tree had only one node (which has been removed).
     * @postcondition
     *  The binary tree starting at the activating node has had its leftmost node removed.
     */
    public BTNode<E> removeLeftmost() {
        if (left == null) { return right; }
        left = left.removeLeftmost();
        return this;
    }

    /**
     * public BTNode<E> removeRightmost()
     * Mutator method that removes the right most node starting from the activating nodes root.
     * @return BTNode<E>
     *  A reference to the root of the newly modified binary tree. Note that the return value can be null if the
     *  original binary tree had only one node (which has been removed).
     * @postcondition
     *  The binary tree starting at the activating node has had its rightmost node removed.
     */
    public BTNode<E> removeRightmost() {
        if (right == null) { return left; }
        right = right.removeRightmost();
        return this;
    }

    /**
     * public void setData()
     * Mutator method that updates the data in the activating node to the specified data.
     * @param data
     *  The new data for the activating node.
     * @postcondition
     *  The data for the activating node has been set to the specified data.
     */
    public void setData(E data) { this.data = data; }

    /**
     * public void setLeft()
     * Mutator method that updates the reference of the left node to the specified node.
     * @param left
     *  The new reference node for this activating objects left child.
     * @postcondition
     *  The reference variable left for the activating node has been set to the specified reference variable.
     */
    public void setLeft(BTNode<E> left) { this.left = left; }

    /**
     * public void setRight()
     * Mutator method that updates the reference of the right node to the specified node.
     * @param right
     *  The new reference node for this activating objects right child.
     * @postcondition
     *  The reference variable right for the activating node has been set to the specified reference variable.
     */
    public void setRight(BTNode<E> right) { this.right = right; }

    /**
     * public static <E> BTNode<E> treeCopy(BTNode<E> source)
     * Copy a binary tree.
     * @param source
     *  A reference to the root node of the binary tree to be copied. Note that the root may be a null reference.
     * @return BTNode<E>
     *  A copy of the binary tree starting at the source. The return value is a reference to the root node.
     * @postcondition
     *  A binary tree has been copied.
     * @exception OutOfMemoryError
     *  Indicates insufficient memory for this new binary tree.
     */
    public static <E> BTNode<E> treeCopy(BTNode<E> source) {
        BTNode<E> leftCopy;
        BTNode<E> rightCopy;

        if (source == null) { return null; }
        leftCopy = treeCopy(source.left);
        rightCopy = treeCopy(source.right);
        return new BTNode<>(source.data, leftCopy, rightCopy);
    }

    /**
     * public static <E> int treeDepth(BTNode<E> root)
     * Computer the depth of this binary tree.
     * @param root
     *  A reference to the root of a binary tree (which may be an empty tree with a null root).
     * @return int
     *  The depth of this binary tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public static <E> int treeDepth(BTNode<E> root) {
        int leftDepth;
        int rightDepth;

        if (root == null) { return 0; }
        leftDepth = 1 + treeDepth(root.left);
        rightDepth = 1 + treeDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * public static <E> int treeSize(BTNode<E> root)
     * Compute the number of nodes in this binary tree.
     * @param root
     *  A reference to the root of a binary tree (which may be an empty tree with a null root).
     * @return int
     *  The number of nodes in this binary tree.
     * @note
     *  A wrong answer occurs for trees larger than Integer.MAX_VALUE.
     */
    public static <E> int treeSize(BTNode<E> root) {
        if (root == null) { return 0; }
        return 1 + treeSize(root.left) + treeSize(root.right);
    }
}
