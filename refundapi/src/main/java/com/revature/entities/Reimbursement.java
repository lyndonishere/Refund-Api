package com.revature.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reimbursement")
public class Reimbursement {
    
    // fields represent data in our database
    @Id
    @GeneratedValue
    private int reimbursement_id;
    private String employee_username;
    private String employee_name;
    private String reimbursement_title;
    private int amount;
    private String reimbursement_reason;
    private java.sql.Date request_date;
    private String status;
    private String decision_reason;

    // we need an empty constructor for Hibernate
    public Reimbursement(){}

    // having this partial constructor will help us to make sure we don't accidentally set a bad id
    public Reimbursement(String employee_username, String employee_name, String reimbursement_title, int amount, String reimbursment_reason, java.sql.Date request_date, String status, String decision_reason){
        this.employee_username = employee_username;
        this.employee_name = employee_name;
        this.reimbursement_title = reimbursement_title;
        this.amount = amount;
        this.reimbursement_reason = reimbursment_reason;
        this.request_date = request_date;
        this.status = status;
        this.decision_reason = decision_reason;
    }

    // this constructor will allow our code to full create Reimbursement objects from pre-existing data in our table
    public Reimbursement(int reimbursement_id, String employee_username, String employee_name, String reimbursement_title, int amount, String reimbursment_reason, java.sql.Date request_date, String status, String decision_reason){
        this.reimbursement_id = reimbursement_id;
        this.employee_username = employee_username;
        this.employee_name = employee_name;
        this.reimbursement_title = reimbursement_title;
        this.amount = amount;
        this.reimbursement_reason = reimbursment_reason;
        this.request_date = request_date;
        this.status = status;
        this.decision_reason = decision_reason;
    }

    // this constructor is for manager approval/denial
    public Reimbursement(int reimbursement_id, String status, String decision_reason){
        this.reimbursement_id = reimbursement_id;
        this.status = status;
        this.decision_reason = decision_reason;
    }


    // getters and setters
    public int getReimbursement_id() {
        return reimbursement_id;
    }

    public void setReimbursement_id(int reimbursement_id) {
        this.reimbursement_id = reimbursement_id;
    }

    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getReimbursement_title() {
        return reimbursement_title;
    }

    public void setReimbursement_title(String reimbursement_title) {
        this.reimbursement_title = reimbursement_title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getReimbursement_reason() {
        return reimbursement_reason;
    }

    public void setReimbursement_reason(String reimbursement_reason) {
        this.reimbursement_reason = reimbursement_reason;
    }

    public java.sql.Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(java.sql.Date request_date) {
        this.request_date = request_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDecision_reason() {
        return decision_reason;
    }

    public void setDecision_reason(String decision_reason) {
        this.decision_reason = decision_reason;
    }

    // making it print out as a string
    @Override
    public String toString() {
        return "Reimbursement [amount=" + amount + ", decision_reason=" + decision_reason + ", employee_name="
                + employee_name + ", employee_username=" + employee_username + ", reimbursement_id=" + reimbursement_id
                + ", reimbursement_reason=" + reimbursement_reason + ", reimbursement_title=" + reimbursement_title
                + ", request_date=" + request_date + ", status=" + status + "]";
    }    
    
}
