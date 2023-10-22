package org.sid.ekservice.services;

import org.sid.ekservice.DTO.BankAccountRequestDTO;
import org.sid.ekservice.DTO.BankAccountResponseDTO;
import org.sid.ekservice.entities.BankAccount;

public interface AccountServices {
     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    }

