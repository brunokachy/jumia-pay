package com.jumia.jumiapay.persistence.service.impl;

import com.jumia.jumiapay.persistence.models.BankCard;
import com.jumia.jumiapay.persistence.repository.BankCardRepository;
import com.jumia.jumiapay.persistence.service.BankCardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by bruno on
 * Sat, 30 Mar, 2019
 */
@Slf4j
@Service
public class BankCardServiceImpl implements BankCardService {

    private BankCardRepository bankCardRepository;

    public BankCardServiceImpl(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    @Override
    public Optional<BankCard> findById(Long aLong) {
        return bankCardRepository.findById(aLong);
    }

    @Override
    public BankCard getRecordById(Long aLong) throws RuntimeException {
        return findById(aLong).orElseThrow(() -> new RuntimeException("Record not found: BankCard with Id: " + aLong));
    }

    @Override
    public BankCard saveRecord(BankCard record) {
        return bankCardRepository.save(record);
    }

    @Override
    public Optional<BankCard> findBankCardByCardNumber(String cardNumber) {
        return bankCardRepository.findBankCardByCardNumber(cardNumber);
    }

    @Override
    public Page<BankCard> getBankCards(int startIndex, int size) {
        Pageable pageable = PageRequest.of(startIndex, size);
        return bankCardRepository.getBankCards(pageable);
    }
}
