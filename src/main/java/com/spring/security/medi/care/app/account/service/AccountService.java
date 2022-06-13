package com.spring.security.medi.care.app.account.service;

import java.util.List;

import com.spring.security.medi.care.app.account.domain.Account;

/**
 * = Javadoc in Asciidoc
 * 
 * Sample comments in `Asciidoctor`.
 * 
 * @author eruiz
 */
public interface AccountService {

    /**
     * Finds the *Account* with the provided com.spring.wlg.account number.
     * 
     * @param number The com.spring.wlg.account number
     * @return The com.spring.wlg.account
     * @throws AccountNotFoundException If no such com.spring.wlg.account exists.
     */
    Account findOne(String number) throws AccountNotFoundException;

    /**
     * Return a listing of all *Account* for a given customer.
     * 
     * @param owner
     *            Name of the _owner_ of the accounts.
     * @return the com.spring.wlg.account listing
     */
    List<Account> findAllAccounts(String owner);

    /**
     * Saves the given entity.
     * 
     * @param account
     */
    void save(Account account);

    /**
     * Creates a new com.spring.wlg.account.
     * 
     * @param account
     * @return created com.spring.wlg.account
     */
    Account create(Account account);
}
