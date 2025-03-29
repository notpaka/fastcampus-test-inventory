package com.grizz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ClucalatorTest {

    @Mock
    Calculator calculator;

    @DisplayName("a와 b를 더했을 때, 그 결과는 3이다")
    @Test

    void test1() {
        //given

        Integer a = 1;
        Integer b = 2;

        given(calculator.add(anyInt(),anyInt())).willAnswer(
                invocation -> {
                    Integer first = invocation.getArgument(0);
                    Integer second = invocation.getArgument(1);

                    return first + second;
                }
        );

        // when
        Integer result = calculator.add(a,b);
        Integer expected = a + b;
        assertEquals(expected, result);
    }
}
