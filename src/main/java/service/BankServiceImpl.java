package service;

import dao.BankAccountDao;
import dao.BankAccountDaoImpl;
import dto.BankAccount;

import java.util.List;

public class BankServiceImpl implements BankService{
    private BankAccountDao bankAccountDao = new BankAccountDaoImpl();

    @Override
    public void createDetails(BankAccount b) {
        bankAccountDao.createDetails(b);
    }

    @Override
    public List<BankAccount> showDetails() {
         return bankAccountDao.showDetails();
    }

    @Override
    public void updateDetails(BankAccount b) {
        bankAccountDao.updateDetails(b);
    }

    @Override
    public void deleteDetails(BankAccount b) {
        bankAccountDao.deleteDetails(b);
    }

    @Override
    public List<BankAccount> displayAcc(int b) {
        return bankAccountDao.displayAcc(b);
    }

    @Override
    public List<BankAccount> displayAcc(String s) {
        return bankAccountDao.displayAcc(s);
    }

    @Override
    public List<String> fetch2(String s) {
        return bankAccountDao.fetch2(s);
    }

    @Override
    public List<BankAccount> displayBank(int b) {
        return bankAccountDao.displayBank(b);
    }

    @Override
    public List<Object[]> groupBy() {
        return bankAccountDao.groupBy();
    }
}
