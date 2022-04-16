package CITS2200;

import java.util.ArrayDeque;
import CITS2200.BinaryTree;
import CITS2200.Iterator;
import CITS2200.OutOfBounds;

public class BinTree<E> extends BinaryTree<E> {
	public BinTree() {
		super();
	}

	public BinTree(E item, BinaryTree<E> ltree, BinaryTree<E> rtree) {
		super(item, ltree, rtree);
	}
	BinaryTree<E> root = this;
	public boolean hasLeft() {
		return !(this.getLeft().isEmpty());
	}

	public boolean hasRight() {
		return !(this.getRight().isEmpty());
	}

	public boolean equals(Object o) {
		// TODO: Implement equals
		 if(!(o instanceof CITS2200.BinaryTree) || o == null)
	            return false; //Object is not a BinaryTree or child of binary tree.
	        //CHECK IF BOTH TREES ARE EMPTY (TRUE)
	        if(this.isEmpty() && ((BinaryTree<?>)o).isEmpty()) //special case
	            return true;
	        if(this.isEmpty() | ((BinaryTree<?>)o).isEmpty())
	            return false;
	        if(this.getItem().equals( ((BinaryTree<?>)o).getItem() )) //CHECK IF EQUAL LEFT SUBTREES
	              return this.getLeft().equals(((BinaryTree<?>)o).getLeft()) && this.getRight().equals(((BinaryTree<?>)o).getRight());
	        return false;
	}

	public class BinTreeIterator<E> implements Iterator<E> {

        /**
         * Using ArrayDeque ADT
         */
        private ArrayDeque<E> trees;

        /**
         * Constructor for iterator implementing the ArrayDeque
         * @param root
         */
        public BinTreeIterator(BinTree<E> root)
        {
            trees = new ArrayDeque<E>();
            inOrder(root);
        }

        private void inOrder(BinaryTree<E> b)
        {
            if(!b.isEmpty())
            {
                inOrder(b.getLeft());
                trees.add(b.getItem());
                inOrder(b.getRight());
            }
        }

        /**
         * Checks if there is any other item that hasn't been seen in the tree
         * @return true iff there are other items that have yet to be iterated, else false
         */

        public boolean hasNext() {
            return !trees.isEmpty();
        }

        /**
         *
         * @return the next item in tree
         * @throws OutOfBounds if there is no next element
         */
        public E next() throws OutOfBounds {
            if(trees.isEmpty())
            {
                throw new OutOfBounds("OutOfBounds");
            }
            return trees.remove();

        }
    }

    /**
     *
     * @return an iterator of E type
     */
    public Iterator<E> iterator()
    {
        // TODO: Implement iterator
        // NOTE: You may need to create an inner class to implement the iterator
        return new BinTreeIterator<E>(this);
    }
}