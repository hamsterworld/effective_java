package effective.java.item26.ch3;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * 이것이 generic 을 사용했을때의 이점
 */
public class AccountRepository extends GenericRepository<Account>{

//    private Set<Account> accounts;
//
//    public AccountRepository() {
//        this.accounts = new HashSet<>();
//    }
//
//    public Optional<Account> findById(Long id){
//        return accounts.stream().filter(a -> a.getId().equals(id)).findAny();
//    }
//
//    public void add(Account account){
//        this.accounts.add(account);
//    }

}
