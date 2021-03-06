package de.timmi6790.commons.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilitiesTest {
    @ParameterizedTest
    @ValueSource(strings = {"", " ", " test", "test", "test dsad s asdas sa asddasads ", "Hello", "HeLLO"})
    void capitalize(final String value) {
        if (value.isEmpty()) {
            return;
        }

        final String result = StringUtilities.capitalize(value);
        assertThat(result).isEqualTo(value.substring(0, 1).toUpperCase() + value.substring(1));
    }

    @Test
    void capitalizeEmpty() {
        assertThat(StringUtilities.capitalize("")).isEmpty();
    }
}
