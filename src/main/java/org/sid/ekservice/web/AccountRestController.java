package org.sid.ekservice.web;

import org.sid.ekservice.DTO.BankAccountRequestDTO;
import org.sid.ekservice.DTO.BankAccountResponseDTO;
import org.sid.ekservice.entities.BankAccount;
import org.sid.ekservice.mappers.AccountMapper;
import org.sid.ekservice.repositories.BankAccountRepository;
import org.sid.ekservice.services.AccountServices;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController

@RequestMapping("/api")
public class AccountRestController {

    // @Autowired
    private BankAccountRepository bankAccountRepository;
    private AccountServices accountServices;
    private AccountMapper accountMapper;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountServices accountServices, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountServices = accountServices;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> BankAccount() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account % not found"))
                );
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){
                return accountServices.addAccount(requestDTO);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount account = bankAccountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account not found with ID: " + id));

        if (bankAccount.getBalance()!=null)account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        if (bankAccount.getCurrency()!=null) account.setCurrency(bankAccount.getCurrency());
        if (bankAccount.getType()!=null)account.setType(bankAccount.getType());

        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
         bankAccountRepository.deleteById(id);
    }
}
