///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.hn.pojo;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Set;
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlTransient;
//
///**
// *
// * @author Admin
// */
//@Entity
//@Table(name = "account")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
//    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
//    @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
//    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
//    @NamedQuery(name = "Account.findByAvatar", query = "SELECT a FROM Account a WHERE a.avatar = :avatar"),
//    @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
//    @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone"),
//    @NamedQuery(name = "Account.findByFullname", query = "SELECT a FROM Account a WHERE a.fullname = :fullname"),
//    @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address"),
//    @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender"),
//    @NamedQuery(name = "Account.findByUserRole", query = "SELECT a FROM Account a WHERE a.userRole = :userRole")})
//public class Account implements Serializable {
//
//    public static final String ADMIN = "admin";
//    public static final String CUSTOMER = "customer";
//    public static final String DRIVER = "driver";
//    public static final String STAFF ="staff";
//
//
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Basic(optional = false)
//    @Column(name = "id")
//    private Integer id;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
//    @Column(name = "username")
//    private String username;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 100)
//    @Column(name = "password")
//    private String password;
//
//    @Size(max = 300)
//    @Column(name = "avatar")
//    private String avatar;
//
//    @Transient
//    @JsonIgnore
//    private MultipartFile file;
//
//    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
//    @Size(max = 100)
//    @Column(name = "email")
//    private String email;
//    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
//    @Size(max = 20)
//    @Column(name = "phone")
//    private String phone;
//    @Size(max = 100)
//    @Column(name = "fullname")
//    private String fullname;
//    @Size(max = 45)
//    @Column(name = "address")
//    private String address;
//    @Column(name = "gender")
//    private Short gender;
//    @Basic
//    @Column(name = "user_role")
//    private String userRole;
////    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
////    private Collection<Driver> driverCollection;
////    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
////    private Collection<Staff> staffCollection;
////    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
////    private Collection<Customer> customerCollection;
//
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
//    private Set<Driver> driverSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
//    private Set<Staff> staffSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
//    private Set<Customer> customerSet;
//
//    public Account() {
//    }
//
//    public Account(Integer id) {
//        this.id = id;
//    }
//
//    public Account(Integer id, String username, String password, String userRole) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.userRole = userRole;
//    }
//
//    public MultipartFile getFile() {
//        return file;
//    }
//
//    public void setFile(MultipartFile file) {
//        this.file = file;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getAvatar() {
//        return avatar;
//    }
//
//    public void setAvatar(String avatar) {
//        this.avatar = avatar;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getFullname() {
//        return fullname;
//    }
//
//    public void setFullname(String fullname) {
//        this.fullname = fullname;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Short getGender() {
//        return gender;
//    }
//
//    public void setGender(Short gender) {
//        this.gender = gender;
//    }
//
//    public String getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(String userRole) {
//        this.userRole = userRole;
//    }
//
////    @XmlTransient
////    public Collection<Driver> getDriverCollection() {
////        return driverCollection;
////    }
////
////    public void setDriverCollection(Collection<Driver> driverCollection) {
////        this.driverCollection = driverCollection;
////    }
////
////    @XmlTransient
////    public Collection<Staff> getStaffCollection() {
////        return staffCollection;
////    }
////
////    public void setStaffCollection(Collection<Staff> staffCollection) {
////        this.staffCollection = staffCollection;
////    }
////
////    @XmlTransient
////    public Collection<Customer> getCustomerCollection() {
////        return customerCollection;
////    }
//
////    public void setCustomerCollection(Collection<Customer> customerCollection) {
////        this.customerCollection = customerCollection;
////    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Account)) {
//            return false;
//        }
//        Account other = (Account) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "com.hn.pojo.Account[ id=" + id + " ]";
//    }
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Admin
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
        @NamedQuery(name = "Account.findByUsername", query = "SELECT a FROM Account a WHERE a.username = :username"),
        @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
        @NamedQuery(name = "Account.findByAvatar", query = "SELECT a FROM Account a WHERE a.avatar = :avatar"),
        @NamedQuery(name = "Account.findByEmail", query = "SELECT a FROM Account a WHERE a.email = :email"),
        @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone"),
        @NamedQuery(name = "Account.findByFullname", query = "SELECT a FROM Account a WHERE a.fullname = :fullname"),
        @NamedQuery(name = "Account.findByAddress", query = "SELECT a FROM Account a WHERE a.address = :address"),
        @NamedQuery(name = "Account.findByGender", query = "SELECT a FROM Account a WHERE a.gender = :gender"),
        @NamedQuery(name = "Account.findByUserRole", query = "SELECT a FROM Account a WHERE a.userRole = :userRole")})
public class Account implements Serializable {

    public static final String ADMIN = "admin";
    public static final String CUSTOMER = "customer";
    public static final String DRIVER = "driver";

    public static final String STAFF = "staff";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull(message = "Không được để trống")
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;

    @Size(max = 300)
    @Column(name = "avatar")
    private String avatar;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Size(max = 100)
    @Column(name = "fullname")
    private String fullname;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Column(name = "gender")
    private Short gender;
    @Basic
    @Column(name = "user_role")
    private String userRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Driver> driverCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private Collection<Staff> staffCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<Customer> customerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    @JsonIgnore
    private Collection<Comment> commentCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
//    private Set<Driver> driverSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
//    private Set<Staff> staffSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
//    private Set<Customer> customerSet;


    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String username, String password, String userRole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Collection<Driver> getDriverCollection() {
        return driverCollection;
    }

    public void setDriverCollection(Collection<Driver> driverCollection) {
        this.driverCollection = driverCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Staff> getStaffCollection() {
        return staffCollection;
    }

    public void setStaffCollection(Collection<Staff> staffCollection) {
        this.staffCollection = staffCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }



//
//    public Set<Driver> getDriverSet() {
//        return driverSet;
//    }
//
//    public void setDriverSet(Set<Driver> driverSet) {
//        this.driverSet = driverSet;
//    }
//
//    public Set<Staff> getStaffSet() {
//        return staffSet;
//    }
//
//    public void setStaffSet(Set<Staff> staffSet) {
//        this.staffSet = staffSet;
//    }
//
//    public Set<Customer> getCustomerSet() {
//        return customerSet;
//    }
//
//    public void setCustomerSet(Set<Customer> customerSet) {
//        this.customerSet = customerSet;
//    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hn.pojo.Account[ id=" + id + " ]";
    }

}
