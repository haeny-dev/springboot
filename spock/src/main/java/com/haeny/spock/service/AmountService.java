package com.haeny.spock.service;

import com.haeny.spock.repository.AmountRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class AmountService {

    private final AmountRepository amountRepository;

    private Long amount;

    public void saveAmount() {
        amountRepository.save();
        amountRepository.save();
    }

}
