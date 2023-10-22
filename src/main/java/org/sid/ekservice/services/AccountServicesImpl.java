package org.sid.ekservice.services;

import org.sid.ekservice.DTO.BankAccountRequestDTO;
import org.sid.ekservice.DTO.BankAccountResponseDTO;
import org.sid.ekservice.entities.BankAccount;
import org.sid.ekservice.mappers.AccountMapper;
import org.sid.ekservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServicesImpl implements AccountServices {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .currency(bankAccountDTO.getCurrency())
                .type(bankAccountDTO.getType())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(saveBankAccount);

        return bankAccountResponseDTO;
    }
}
