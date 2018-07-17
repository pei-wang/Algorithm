package tree;

public class BinaryTree<T extends Comparable> {

    public void delete(T t) {
        remove(rootNode, t);
    }

    private BinaryNode<T> remove(BinaryNode<T> rootNode, T t) {
        if (rootNode == null) {
            return rootNode;
        }
        int result = rootNode.data.compareTo(t);
        if (result == 0) {
            if (rootNode.left == null && rootNode.right == null) {
                return null;
            }
            if (rootNode.left == null && rootNode.right != null) {
                return rootNode.right;
            }
            if (rootNode.left != null && rootNode.right == null) {
                return rootNode.left;
            }
            rootNode.data = findMin(rootNode);
            rootNode.right = remove(rootNode.right, rootNode.data);

        } else if (result < 0) {
            rootNode.right = remove(rootNode.right, t);
        } else if (result > 0) {
            rootNode.left = remove(rootNode.left, t);
        }
        return rootNode;
    }

    private T findMin(BinaryNode<T> rootNode) {
        T result;
        if (rootNode.left == null) {
            return rootNode.data;
        } else {
            result = findMin(rootNode.left);
        }
        return result;
    }

    static class BinaryNode<T extends Comparable> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T data) {
            this.data = data;
        }
    }

    private BinaryNode<T> rootNode;

    public BinaryTree() {
        this.rootNode = null;
    }

    public void insert(T t) {
        rootNode = insert(rootNode, t);
    }

    private BinaryNode<T> insert(BinaryNode<T> rootNode, T t) {
        if (rootNode == null) {
            return new BinaryNode<T>(t);
        } else if (rootNode.data.compareTo(t) < 0) {
            rootNode.right = insert(rootNode.right, t);
        } else if (rootNode.data.compareTo(t) > 0) {
            rootNode.left = insert(rootNode.left, t);
        }
        return rootNode;
    }

    public boolean contains(T t) {
        return contains(rootNode, t);
    }


    private boolean contains(BinaryNode<T> rootNode, T data) {
        if (rootNode == null) {
            return false;
        } else if (rootNode.data.compareTo(data) == 0) {
            return true;
        } else if (rootNode.data.compareTo(data) < 0) {
            return contains(rootNode.right, data);
        } else if (rootNode.data.compareTo(data) > 0) {
            return contains(rootNode.left, data);
        }
        return false;
    }
}


