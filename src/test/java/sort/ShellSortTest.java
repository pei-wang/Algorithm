package sort;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ShellSortTest {
    @Test
    public void shouldReturnASortedArray() {
        int[] arr = new int[]{1, 4, 3, 5, 7};
        int[] result = ShellSort.sort(arr);

        assertThat(result[0], is(1));
        assertThat(result[1], is(3));
        assertThat(result[2], is(4));
        assertThat(result[4], is(7));
    }
}
