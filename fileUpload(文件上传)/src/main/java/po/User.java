package po;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xlf on 2018/9/14.
 */
public class User {

    private Integer id;
    private String name;
    private String pwd;
    private Phone phone;

//    private List<Phone> phones;
//
//    public List<Phone> getPhones() {
//        return phones;
//    }
//
//    public void setPhones(List<Phone> phones) {
//        this.phones = phones;
//    }

    private Set<Phone> phones = new HashSet<>();

    private Map<String, Phone> map=new HashMap<String, Phone>();


    public User() {
        phones.add(new Phone());
        phones.add(new Phone());
        phones.add(new Phone());
    }

    public Map<String, Phone> getMap() {
        return map;
    }

    public void setMap(Map<String, Phone> map) {
        this.map = map;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone=" + phone +
                ", phones=" + phones +
                ", map=" + map +
                '}';
    }
}
