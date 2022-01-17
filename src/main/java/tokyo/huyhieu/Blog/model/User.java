package tokyo.huyhieu.Blog.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotEmpty(message = "Id may not be null")
    @Column(name = "user_name", unique = true)
    private String userName;

    @NotEmpty(message = "Id may not be null")
    @Column(name = "password")
    private String passWord;

    @NotEmpty(message = "Id may not be null")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "status")
    private boolean status;

    @Column(name = "role")
    private boolean role;

    @NotEmpty(message = "Id may not be null")
    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments;

    public User() {
    }

    public User(long id, String userName, String passWord, String email, boolean status, boolean role, String fullName, Set<Comment> comments) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.status = status;
        this.role = role;
        this.fullName = fullName;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
