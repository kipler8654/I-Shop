package ua.ishop.trofimov.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    static Long currentId = 0L;
    Long userId;
    String email;
    String password;
    String passwordNotEncoded;
    LocalDateTime createDate;
    LocalDateTime updateDate;
    List<Role> role;

    public User() {
    }

    public User(Long userId, String email, String passwordNotEncoded) {
        this.userId = userId;
        this.email = email;
        this.passwordNotEncoded = passwordNotEncoded;
        currentId = userId;
    }

    public User(String email, String passwordNotEncoded) {
        this.userId = ++currentId;
        this.email = email;
        this.passwordNotEncoded = passwordNotEncoded;
    }

    public User(Long userId, String email, String password, String passwordNotEncoded, LocalDateTime createDate, LocalDateTime updateDate) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.passwordNotEncoded = passwordNotEncoded;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void setOneRole(Role role) {
        if (this.role == null) {
            this.role = new ArrayList<>();
            if (role.getName() != null) {
                this.role.add(role);
            }
        } else {
            if (role.getName() != null) {
                this.role.add(role);
            }
        }
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordNotEncoded() {
        return passwordNotEncoded;
    }

    public void setPasswordNotEncoded(String passwordNotEncoded) {
        this.passwordNotEncoded = passwordNotEncoded;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}