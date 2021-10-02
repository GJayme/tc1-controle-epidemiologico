package utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public interface EqualityTest<T> {
    T createValue();

    T createOtherValue();

    @Test
    default void should_be_equal() {
        assertThat(createValue()).isEqualTo(createValue());
        assertThat(createValue()).hasSameHashCodeAs(createValue());
    }

    @Test
    default void should_not_be_equal() {
        assertThat(createValue()).isNotEqualTo(createOtherValue());
        assertThat(createValue().hashCode()).isNotEqualTo(createOtherValue().hashCode());
    }
}