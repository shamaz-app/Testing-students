package by.testing.service.account;

import by.testing.entities.account.Account;
import by.testing.repository.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Анастасия on 09.09.2016.
 */
public class SecuritYServiceImpl implements SecurityService {

    @Autowired
    private AccountRepository accountRepository;
//
//    @Override
//    public Account getCurrentAccount() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Account currentAccount = accountRepository.findByLoginIgnoreCase(authentication.getName());
//        return currentAccount;
//    }
}
