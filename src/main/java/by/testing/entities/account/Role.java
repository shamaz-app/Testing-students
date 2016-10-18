package by.testing.entities.account;

import by.testing.entities.IdEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * Created by Анастасия on 07.09.2016.
 */
@Entity
public class Role extends IdEntity implements GrantedAuthority {

    @NotNull
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
