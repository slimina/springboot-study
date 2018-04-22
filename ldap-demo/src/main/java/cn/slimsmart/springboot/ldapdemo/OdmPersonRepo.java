package cn.slimsmart.springboot.ldapdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

/**
 * Created by zhutw on 2018/3/8.
 */
public class OdmPersonRepo {
    @Autowired
    private LdapTemplate ldapTemplate;

    public Person create(Person person) {
        ldapTemplate.create(person);
        //        ldapTemplate.authenticate()
        return person;
    }
}
