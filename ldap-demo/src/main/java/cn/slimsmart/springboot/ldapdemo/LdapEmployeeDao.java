package cn.slimsmart.springboot.ldapdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.stereotype.Repository;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import java.util.List;

/**
 * Created by zhutw on 2018/3/8.
 */
@Repository
public class LdapEmployeeDao {

    @Value("${spring.ldap.domain}")
    private String domain;
    @Autowired
    private LdapTemplate ldapTemplate;

    public  Employee findByAccountName(String accountName){
        ldapTemplate.setIgnorePartialResultException(true);
        List<Employee> employees  = ldapTemplate.search(LdapQueryBuilder.query().where("objectclass").is("person").and("sAMAccountName").is(accountName)
                ,new MyAttributesMapper());
        return employees==null || employees.size() == 0 ? null : employees.get(0);
    }
         //base : OU=云平台部1,OU=平台技术中心1,OU=01总部
      //  person, organizationalPerson, user
    public List<Employee> findAll(String base,String objectclass){
        ldapTemplate.setIgnorePartialResultException(true);
        List<Employee> employees = ldapTemplate.search(base, "(objectclass=person)",new MyAttributesMapper());
        return employees;
    }

    public  Employee auth(String username,String password){
        ldapTemplate.setIgnorePartialResultException(true);
        ldapTemplate.getContextSource().getContext(username+domain,password);
        return findByAccountName(username);
    }

    private static class MyAttributesMapper implements  AttributesMapper<Employee>{
        public Employee mapFromAttributes(Attributes attributes)
                throws javax.naming.NamingException {
            Employee employee = new Employee();
            Attribute employeeNumber = attributes.get("employeeNumber");
            employee.setId(employeeNumber==null ? null : (String)employeeNumber.get());


            Attribute sAMAccountName = attributes.get("sAMAccountName");
            employee.setAccountName(sAMAccountName==null ? null : (String)sAMAccountName.get());

            Attribute company = attributes.get("company");
            employee.setCompany(company==null ? null : (String)company.get());

            Attribute department = attributes.get("department");
            employee.setDepartment(department==null ? null : (String)department.get());
            Attribute description = attributes.get("description");
            employee.setDescription(description==null ? null : (String)description.get());

            Attribute displayName = attributes.get("displayName");
            employee.setDisplayName(displayName==null ? null : (String)displayName.get());

            Attribute userPrincipalName = attributes.get("userPrincipalName");
            employee.setEmail(userPrincipalName==null ? null : (String)userPrincipalName.get());

            Attribute msExchWhenMailboxCreated = attributes.get("msExchWhenMailboxCreated");
            employee.setEntryTime(msExchWhenMailboxCreated==null ? null : ((String)msExchWhenMailboxCreated.get()).substring(0,8));

            Attribute physicalDeliveryOfficeName = attributes.get("physicalDeliveryOfficeName");
            employee.setLeaveTime(physicalDeliveryOfficeName==null ? null : (String)physicalDeliveryOfficeName.get());

            Attribute sn = attributes.get("sn");
            employee.setName(sn==null ? null : (String)sn.get());
            Attribute telephoneNumber = attributes.get("telephoneNumber");
            employee.setTelephoneNumber(telephoneNumber==null ? null : (String)telephoneNumber.get());
            return employee;
        }
    }
}
