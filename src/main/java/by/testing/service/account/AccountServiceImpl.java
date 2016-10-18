package by.testing.service.account;

import by.testing.entities.account.Account;
import by.testing.repository.account.AccountRepository;
import by.testing.service.SimpleServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Анастасия on 06.09.2016.
 */
@Service
public class AccountServiceImpl extends SimpleServiceImpl<Account, AccountRepository> implements AccountService {

    @Override
    public List<Account> getAll() {
        return repository.findAll();
    }
}
