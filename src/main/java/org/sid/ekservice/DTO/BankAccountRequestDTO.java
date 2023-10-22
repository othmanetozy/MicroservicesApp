package org.sid.ekservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ekservice.enums.AccountType;

@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class BankAccountRequestDTO {

    private Double balance;
    private String currency;
    private AccountType type;
}
