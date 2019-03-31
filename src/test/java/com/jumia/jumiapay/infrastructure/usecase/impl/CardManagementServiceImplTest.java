package com.jumia.jumiapay.infrastructure.usecase.impl;

import com.jumia.jumiapay.infrastructure.dto.BankCardDTO;
import com.jumia.jumiapay.persistence.models.BankCard;
import com.jumia.jumiapay.persistence.service.BankCardService;
import com.jumia.jumiapay.web.exceptions.BadRequestException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CardManagementServiceImplTest {
    @Mock
    private BankCardService bankCardService;

    @InjectMocks
    CardManagementServiceImpl cardManagementService;

    @Test(expected = BadRequestException.class)
    public void whenCardNumberEmptyReturnMethodToThrowEx_thenExIsThrown() {
        //Arrange
        String cardNumber = "";

        //Act
        when(cardManagementService.resolveCardDetails(cardNumber)).thenThrow(new BadRequestException(anyString()));
    }

    @Test(expected = BadRequestException.class)
    public void whenCardNumberNotNumericReturnMethodToThrowEx_thenExIsThrown() {
        //Arrange
        String cardNumber = "asdfgliwe";

        //Act
        when(cardManagementService.resolveCardDetails(cardNumber)).thenThrow(new BadRequestException(anyString()));
    }

    @Test(expected = BadRequestException.class)
    public void whenCardNumberLessThanSixReturnMethodToThrowEx_thenExIsThrown() {
        //Arrange
        String cardNumber = "78478";

        //Act
        when(cardManagementService.resolveCardDetails(cardNumber)).thenThrow(new BadRequestException(anyString()));
    }

    @Test()
    public void givenCardNumberExistInDBWhenResolveCardDetailsThenReturnBankCardDetails() {
        //Arrange
        String cardNumber = "539923";
        BankCard bankCard = new BankCard();
        bankCard.setBank("FIRST BANK OF NIGERIA PLC");
        bankCard.setScheme("mastercard");
        bankCard.setType("debit");

        //Act
        when(bankCardService.findBankCardByCardNumber(cardNumber)).thenReturn(Optional.of(bankCard));
        BankCardDTO bankCardDTO = cardManagementService.resolveCardDetails(cardNumber);

        //Assert
        assertEquals(bankCardDTO.getBank(), "FIRST BANK OF NIGERIA PLC");
        assertEquals(bankCardDTO.getScheme(), "mastercard");
        assertEquals(bankCardDTO.getType(), "debit");
    }

}