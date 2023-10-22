package org.sid.ekservice.mappers;

import org.sid.ekservice.DTO.BankAccountResponseDTO;
import org.sid.ekservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);     //bankAccount->bankAccountResponseDTO
        return bankAccountResponseDTO;
    }
}
