package by.testing.repository.account;

import by.testing.entities.account.Account;
import by.testing.repository.SimpleRepository;

import java.util.List;

/**
 * Created by Анастасия on 06.09.2016.
 */
public interface AccountRepository extends SimpleRepository<Account> {

    Account findByLoginIgnoreCase(String login);

    List<Account> findAll();
}
