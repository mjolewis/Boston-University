// FILE BTNode.java from the package edu.bostonuniversity.nodes

package edu.bostonuniversity.nodes;

/**********************************************************************************************************************
 * A BTNode<E> provides a node for a binary tree with a reference to an E object as the data in each node.
 *
 * @note
 *  Beyond Integer.MAZx_VALUE elements, treeSize is wrong.
 *
 * @author mlewis
 * @version Nov 3, 2019
 *********************************************************************************************************************/

public class BTNode<E> {
    // Invariant of the BTNode<E> class
    //  1. The instance variable data stores the data of each node.
    //  2. The instance variable left is a reference to the left child of the activating node. If there is no left
    //     child, left is a null reference.
    //  3. The instance variable right is a reference to the right child of the activating node. If there is no right
    //     child, right is a null reference.
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
     * public E getData()
     * Accessor method to retrieve the activating nodes data.
     * @return E
     *  The activating nodes data.
     */
    public E getData() {
        return data;
    }

    /**
     * public BTNode<E> getLeft()
     * Accessor method that returns a reference to the activating nodes left child.
     * @return BTNode<E>
     *  A reference to this nodes left child. Note that this may be a null reference, which indicates that there is no
     *  left child.
     */
    public BTNode<E> getLeft() {
        return left;
    }

    /**
     * public BTNode<E> getRight()
     * Accessor method that returns a reference to the activating nodes right child.
     * @return BTNode<E>
     *  A reference to this nodes right child. Note that this may be a null reference, which indicates that there is no
     *  right child.
     */
    public BTNode<E> getRight() {
        return right;
    }


    /**
     * public void setData()
     * Mutator method that updates the data in the activating node to the specified data.
     * @param data
     *  The new data for the activating node.
     * @postcondition
     *  The data for the activating node has been set to the specified data.
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * public void setLeft()
     * Mutator method that updates the reference of the left node to the specified node.
     * @param left
     *  The new reference node for this activating objects left child.
     * @postcondition
     *  The reference variable left for the activating node has been set to the specified reference variable.
     */
    public void setLeft(BTNode<E> left) {
        this.left = left;
    }

    /**
     * public void setRight()
     * Mutator method that updates the reference of the right node to the specified node.
     * @param right
     *  The new reference node for this activating objects right child.
     * @postcondition
     *  The reference variable right for the activating node has been set to the specified reference variable.
     */
    public void setRight(BTNode<E> right) {
        this.right = right;
    }
}
