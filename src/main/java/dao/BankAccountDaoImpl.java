package dao;

import config.Util;
import dto.BankAccount;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import java.util.List;

public class BankAccountDaoImpl implements BankAccountDao{
    @Override
    public void createDetails(BankAccount b) {
        EntityManager em = Util.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(b);
        tx.commit();
        em.close();
    }

    @Override
    public List<BankAccount> showDetails() {
        EntityManager em = Util.getEntityManager();
        Query q = em.createQuery("SELECT p FROM BankAccount AS p");
        List<BankAccount> bank = q.getResultList();
        return bank;
    }

    @Override
    public void updateDetails(BankAccount b) {
        EntityManager em = Util.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        BankAccount temp = em.find(BankAccount.class,b.getActNumber());
        temp.setCustomerName(b.getCustomerName());
        temp.setCity(b.getCity());
        tx.commit();
        em.close();
    }

    @Override
    public void deleteDetails(BankAccount b) {
        EntityManager em = Util.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        BankAccount temp = em.find(BankAccount.class,b.getActNumber());
        em.remove(temp);
        tx.commit();
    }

    @Override
    public List<BankAccount> displayAcc(int b) {
        EntityManager em = Util.getEntityManager();
        Query q = em.createQuery("Select p from BankAccount as p where p.actNumber=:val ");
        q.setParameter("val",b);
        List<BankAccount> bank = q.getResultList();
        return bank;

    }

    @Override
    public List<BankAccount> displayAcc(String s) {
        EntityManager em = Util.getEntityManager();
        Query q = em.createQuery("Select p from BankAccount as p where p.customerName=:val ");
        q.setParameter("val",s);
        List<BankAccount> bank = q.getResultList();
        return bank;
    }

    @Override
    public List<String> fetch2(String s) {
        EntityManager em = Util.getEntityManager();
        Query q = em.createQuery("Select p.city from BankAccount as p where p.customerName=:val ");
        q.setParameter("val",s);
        List<String> bank = q.getResultList();
        return bank;
    }

    @Override
    public List<BankAccount> displayBank(int b) {
        EntityManager em = Util.getEntityManager();
        Query q = em.createQuery("Select p from BankAccount as p where p.branchCode=:val ");
        q.setParameter("val",b);
        List<BankAccount> bank = q.getResultList();
        return bank;
    }

    @Override
    public List<Object[]> groupBy() {
        EntityManager em = Util.getEntityManager();
        Query q = em.createQuery("SELECT e.city,e.actNumber,e.customerName from BankAccount AS e group by e.city,e.actNumber,e.customerName");
        List<Object[]> bank = q.getResultList();
        return bank;
    }
}
