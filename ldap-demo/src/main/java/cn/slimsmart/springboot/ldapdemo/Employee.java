package cn.slimsmart.springboot.ldapdemo;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.util.StringUtils;

import javax.naming.Name;

/**
 * Created by zhutw on 2018/3/8.
 */
public class Employee {
    private String id;
    private String accountName;
    private String name;
    private String displayName;
    private String department;
    private String entryTime;
    private String leaveTime;
    private String email;
    private String company;
    private String telephoneNumber;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Integer getStatus() { // 0 正常 1 离职
        return StringUtils.isEmpty(id) ? 1 : 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", accountName='" + accountName + '\'' +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", department='" + department + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", leaveTime='" + leaveTime + '\'' +
                ", email='" + email + '\'' +
                ", company='" + company + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
