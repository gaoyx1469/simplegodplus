package top.trial.springsecurity.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/8/6
 * @Version 1.0
 */
public class UserDomain implements Serializable {
    private String id;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private String phoneNumber;
    private String birthday;
    private String status;
    private String statusStr;
    private String createDate;
    private String updateDate;
    private List<RoleDomain> roles;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<RoleDomain> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDomain> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday='" + birthday + '\'' +
                ", status='" + status + '\'' +
                ", statusStr='" + statusStr + '\'' +
                ", createDate='" + createDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", roles=" + roles +
                '}';
    }
}
