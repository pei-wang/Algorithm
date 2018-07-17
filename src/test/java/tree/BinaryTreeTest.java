package tree;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BinaryTreeTest {
    BinaryTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinaryTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(5);
    }

    @Test
    public void shouldReturnBinaryTreeWhenInsertNodes() {
    }

    @Test
    public void shouldReturnTrueIfTreeContainsNodeWanted() {
        assertThat(tree.contains(1), is(true));
    }

    @Test
    public void shouldReturnFalseIfTreeNotContainsData() {
        int NOT_CONTAINED = 99;
        assertThat(tree.contains(NOT_CONTAINED), is(false));
    }

    @Test
    public void shouldDeleteExistedElementWhichIsTheLeftNode() {
        tree.delete(5);
        assertThat(tree.contains(5), is(false));
    }

    @Test
    public void shouldDeleteExistedElementWhichOnlyhaveRightChild() {
        tree.delete(2);
        assertThat(tree.contains(2), is(false));
    }

    @Test
    public void shouldDeleteExistedElementWhichOnlyHasLeftChild() {
        tree.insert(4);
        tree.delete(5);
        assertThat(tree.contains(5), is(false));
    }

    @Test
    public void shouldDeleteExistedElementWhichHasLeftChildAndRightChild() {
        tree.insert(3);
        tree.insert(4);
        tree.insert(8);
        tree.insert(6);
        tree.insert(7);

        tree.delete(5);
        assertThat(tree.contains(5), is(false));
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }
}
