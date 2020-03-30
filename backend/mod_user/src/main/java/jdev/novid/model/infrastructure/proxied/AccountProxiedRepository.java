package jdev.novid.model.infrastructure.proxied;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jdev.novid.common.identity.UserId;
import jdev.novid.component.persistence.PersistenceQualifiers;
import jdev.novid.model.domain.Account;
import jdev.novid.model.infrastructure.AccountRepository;

@Component
@Qualifier(PersistenceQualifiers.PROXIED)
public class AccountProxiedRepository implements AccountRepository {

    @Autowired
    @Qualifier(PersistenceQualifiers.JPA)
    private AccountRepository accountJpaRepository;

    @Autowired
    @Qualifier(PersistenceQualifiers.AEROSPIKE)
    private AccountRepository accountAerospikeRepository;

    @Override
    public void save(Account domain) {

        this.accountJpaRepository.save(domain);
        this.accountAerospikeRepository.save(domain);

    }

    @Override
    public void delete(UserId id) {

    }

    @Override
    public Account get(UserId id) {

        return null;

    }

}
