package dao;

import dto.BankAccount;

import java.util.List;

public interface BankAccountDao {
    public void createDetails(BankAccount b);
    public List<BankAccount> showDetails();
    public void updateDetails(BankAccount b);
    public void deleteDetails(BankAccount b);
    public List<BankAccount> displayAcc(int b);
    public List<BankAccount> displayAcc(String s);
    public List<String> fetch2(String s);
    public List<BankAccount> displayBank(int b);
    List<Object[]> groupBy();
}
