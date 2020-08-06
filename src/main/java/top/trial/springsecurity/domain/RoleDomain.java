package top.trial.springsecurity.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @Author gaoyx1469
 * @Date 2020/8/6
 * @Version 1.0
 */
public class RoleDomain implements Serializable {
    private String id;
    private String name;
    private String nickname;
    private String describe;
    private List<UserDomain> users;

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

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public List<UserDomain> getUsers() {
        return users;
    }

    public void setUsers(List<UserDomain> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleDomain{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", describe='" + describe + '\'' +
                ", users=" + users +
                '}';
    }
}
