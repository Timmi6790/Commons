package de.timmi6790.commons;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

class PairTest {
    private static final String EXAMPLE_LEFT = "ADSSADDS A SA DS DSAD ";
    private static final String EXAMPLE_RIGHT_STRING = "DSSDSDASDASDA SA SADDSASAD ASD";
    private static final int EXAMPLE_RIGHT_INT = 100;
    private final static Pair<String, String> EXAMPLE_SAME_TYPE_PAIR = new Pair<>(EXAMPLE_LEFT, EXAMPLE_RIGHT_STRING);
    private final static Pair<String, Integer> EXAMPLE_DIFFERENT_TYPE_PAIR = new Pair<>(EXAMPLE_LEFT, EXAMPLE_RIGHT_INT);


    @Test
    void getLeftSameTypes() {
        AssertionsForClassTypes.assertThat(EXAMPLE_SAME_TYPE_PAIR.getLeft()).isEqualTo(EXAMPLE_LEFT);
    }

    @Test
    void getLeftDifferentTypes() {
        AssertionsForClassTypes.assertThat(EXAMPLE_DIFFERENT_TYPE_PAIR.getLeft()).isEqualTo(EXAMPLE_LEFT);
    }

    @Test
    void getRightSameTypes() {
        AssertionsForClassTypes.assertThat(EXAMPLE_SAME_TYPE_PAIR.getRight()).isEqualTo(EXAMPLE_RIGHT_STRING);
    }

    @Test
    void getRightDifferentTypes() {
        AssertionsForClassTypes.assertThat(EXAMPLE_DIFFERENT_TYPE_PAIR.getRight()).isEqualTo(EXAMPLE_RIGHT_INT);
    }

    @Test
    void setLeft() {
        final String newLeftValue = "D";
        final Pair<String, String> pair = new Pair<>(EXAMPLE_LEFT, EXAMPLE_RIGHT_STRING);
        pair.setLeft(newLeftValue);
        AssertionsForClassTypes.assertThat(pair.getLeft()).isEqualTo(newLeftValue);
    }

    @Test
    void setRight() {
        final String newRightValue = "D";
        final Pair<String, String> pair = new Pair<>(EXAMPLE_LEFT, EXAMPLE_RIGHT_STRING);
        pair.setRight(newRightValue);
        AssertionsForClassTypes.assertThat(pair.getRight()).isEqualTo(newRightValue);
    }
}