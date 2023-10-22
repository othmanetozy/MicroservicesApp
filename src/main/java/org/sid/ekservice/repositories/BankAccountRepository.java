package org.sid.ekservice.repositories;

import org.sid.ekservice.entities.BankAccount;
import org.sid.ekservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    @RestResource(path = "/bytype")
    List<BankAccount> findByType(@Param("t") AccountType type);   //serach/bytype?t=...
}
