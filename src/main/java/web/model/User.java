package web.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="lastName")
    private String lastName;

    @Column(name="age")
    private Byte age;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    public User() {
    }

    public User(String name, String lastName, Byte age, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public User(Long id, String name, String lastName, Byte age, String email, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
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
}
