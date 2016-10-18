package by.testing.oauth;

import by.testing.entities.account.Account;
import by.testing.repository.account.AccountRepository;
import by.testing.utils.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
class CustomUserDetailsService implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Autowired
	public CustomUserDetailsService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) {
		Account account = accountRepository.findByLoginIgnoreCase(username);
		if (account == null) {
			ExceptionUtils.throwUsernameNotFoundException(getClass());
		}
		return account;
	}

}
