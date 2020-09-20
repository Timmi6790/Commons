package de.timmi6790.commons.utilities;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class EnumUtilitiesTest {
    @Test
    void getPrettyNames() {
        final List<String> shouldValues = new ArrayList<>();
        for (final TestEnum testEnum : TestEnum.values()) {
            shouldValues.add(EnumUtilities.getPrettyName(testEnum));
        }

        assertThat(EnumUtilities.getPrettyNames(TestEnum.values())).isEqualTo(shouldValues);
    }

    @Test
    void getPrettyName() {
        AssertionsForClassTypes.assertThat(EnumUtilities.getPrettyName(TestEnum.TEST)).isEqualTo("Test");

        AssertionsForClassTypes.assertThat(EnumUtilities.getPrettyName(TestEnum.TEST_VALUE)).isEqualTo("TestValue");

        AssertionsForClassTypes.assertThat(EnumUtilities.getPrettyName(TestEnum.REALLY_LONG_TEST_VALUE)).isEqualTo("ReallyLongTestValue");
    }

    @Test
    void getIgnoreCase() {
        // Should find
        AssertionsForClassTypes.assertThat(EnumUtilities.getIgnoreCase("test", TestEnum.values()))
                .isPresent()
                .hasValue(TestEnum.TEST);

        AssertionsForClassTypes.assertThat(EnumUtilities.getIgnoreCase("testvalue", TestEnum.values()))
                .isPresent()
                .hasValue(TestEnum.TEST_VALUE);

        AssertionsForClassTypes.assertThat(EnumUtilities.getIgnoreCase("TesTValue", TestEnum.values()))
                .isPresent()
                .hasValue(TestEnum.TEST_VALUE);

        // Should not find
        AssertionsForClassTypes.assertThat(EnumUtilities.getIgnoreCase("Tesd", TestEnum.values()))
                .isNotPresent();

        AssertionsForClassTypes.assertThat(EnumUtilities.getIgnoreCase("", TestEnum.values()))
                .isNotPresent();
    }

    private enum TestEnum {
        TEST,
        TEST1,
        TEST3,
        VALUE,
        TEST_VALUE,
        LONG_TEST_VALUE,
        REALLY_LONG_TEST_VALUE
    }
}