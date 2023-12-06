import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
public class SortingAppTest {
    @ParameterizedTest
    @MethodSource("provideArrays")
    public void testSortingAppWithValidInput(int[] input, int[] expectedSorted) {
        SortingApp.main(input);
        assertArrayEquals(expectedSorted, SortingApp.sortNumbers(input));
    }

    private static Stream<Arguments> provideArrays() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 8, 1, 7}, new int[]{1, 2, 5, 7, 8}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{3}, new int[]{3}),
                Arguments.of(new int[]{9, 5, 2, 7, 1, 8, 4, 6, 3}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}),
                Arguments.of(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 1}),
                Arguments.of(new int[]{-5, 0, 5}, new int[]{-5, 0, 5})
                // Add more test cases as needed
        );
    }

    @Test
    public void testSortingAppWithNoArguments() {
        int[] args = {};
        SortingApp.main(args);

        assertEquals(true, SortingApp.getErrorMessage(args));
    }
}
