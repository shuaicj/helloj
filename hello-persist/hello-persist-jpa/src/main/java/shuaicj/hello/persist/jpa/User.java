package shuaicj.hello.persist.jpa;

import javax.persistence.*;
import java.util.Date;

/**
 * A java bean representing a user.
 *
 * @author shuaicj 2017/01/15
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false, unique = true, updatable = false, length = 32)
    private String username;

    @Column(nullable = false, length = 60)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time", nullable = false, updatable = false)
    private Date createdTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_time", nullable = false)
    private Date updatedTime;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @PrePersist
    protected void prePersist() {
        createdTime = updatedTime = new Date();
    }

    @PreUpdate
    protected void preUpdate() {
        updatedTime = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
