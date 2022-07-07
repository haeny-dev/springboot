package com.example.springbootspock;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.springbootspock.exception.NegativeNumberException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FeeCalculateTypeTest {

    @Test
    void calculate_금액이_주어지면_원단위_반올림_결과가_반환된다() throws Exception {
        // given
        FeeCalculateType feeCalculator = FeeCalculateType.WON_UNIT_CUT;

        // when & then
        assertThat(feeCalculator.calculate(500)).isEqualTo(500L);
        assertThat(feeCalculator.calculate(495)).isEqualTo(490L);
    }

    @Test
    void calculate_음수가입력되면_예외발생 () throws Exception {
        // given
        FeeCalculateType feeCalculator = FeeCalculateType.WON_UNIT_CUT;

        // when & then
        assertThatThrownBy(() -> feeCalculator.calculate(-1))
            .isInstanceOf(NegativeNumberException.class)
            .hasMessage("음수는 허용하지 않습니다.");
    }

}