package org.sid.ekservice.entities;

import org.sid.ekservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = BankAccount.class, name = "P1")
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();

}
