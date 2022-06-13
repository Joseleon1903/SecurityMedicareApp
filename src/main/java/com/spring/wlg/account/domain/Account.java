package com.spring.wlg.account.domain;


public class Account {

    private Integer id;

    private String number;

    private String type;

    private String creditCardNumber;

    /**
     * Create an empty com.spring.wlg.account.
     */
    protected Account() {}
    
    /**
     * Create a new com.spring.wlg.account.
     * 
     * @param number
     *            the com.spring.wlg.account number
     * @param id
     *            the com.spring.wlg.account id
     */
    public Account(Integer id, String number) {
        this.number = number;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", number=" + number + ", type=" + type
                + ", creditCardNumber=" + creditCardNumber + "]";
    }

}