package by.testing.service.account;

import by.testing.entities.account.Account;
import by.testing.service.SimpleService;

import java.util.List;

/**
 * Created by Анастасия on 06.09.2016.
 */
public interface AccountService extends SimpleService<Account> {

    /**
     * Get all accounts
     * @return
     */
    List<Account> getAll();
}
