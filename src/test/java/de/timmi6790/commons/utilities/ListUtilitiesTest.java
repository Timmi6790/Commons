package de.timmi6790.commons.utilities;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ListUtilitiesTest {
    @Test
    void toStringList() {
        final List<Integer> intValues = Arrays.asList(1, 2, 3, 4, 5);
        final List<String> convertValues = ListUtilities.toStringList(intValues, String::valueOf);
        assertThat(convertValues).containsExactly("1", "2", "3", "4", "5");
    }

    @Test
    void toTypeList() {
        final List<Double> doubleValues = Arrays.asList(2.1, 3.5, 6.9, 9.5);
        final List<Integer> convertValues = ListUtilities.toTypeList(doubleValues, Double::intValue);
        assertThat(convertValues).containsExactly(2, 3, 6, 9);
    }
}