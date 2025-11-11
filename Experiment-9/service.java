@Service
public class BankingService {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void transfer(int fromAccId, int toAccId, double amount) {
        Account fromAcc = sessionFactory.getCurrentSession().get(Account.class, fromAccId);
        Account toAcc = sessionFactory.getCurrentSession().get(Account.class, toAccId);

        if(fromAcc.getBalance() >= amount) {
            fromAcc.debit(amount);
            toAcc.credit(amount);
            // Hibernate/JPA will persist and transaction will commit
        } else {
            throw new RuntimeException("Insufficient funds");
        }
    }
}
