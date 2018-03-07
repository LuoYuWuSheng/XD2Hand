package site.luoyu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import site.luoyu.dao.entity.UserStudent;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 这里定义的是和用户相关的信息。
 * 底层直接调用dao中的内容进行持久化
 * Created by luoyu on 2018/3/7.
 */
@Component
public class User {

    private int stuId;
//  Spring 校验这里的信息是写死的，其实可以利用资源文件实现Spring对多语言的支持，没有做继续尝试
    @NotNull(message = "用户名不能为空")
    @Size(min = 6, max = 10,message = "用户名最小不少于6个，最多不多于10个")
    private String name;
    private String nickname;
    private String phoneNumber;
    private String email;
    private int classes_id;
    private String portrait;
    @NotNull(message = "密码不能为空")
    @JsonIgnoreProperties
    private String passwd;

    //无参构造函数
    public User() {
    }

    /**
     * 从entity构造
     * @param stu
     *      传过来的stu实体
     */
    public User(UserStudent stu) {
        this.stuId = stu.getStuId();
        this.name = stu.getName();
        this.nickname = stu.getNickname();
        this.phoneNumber = stu.getPhonenumber();
        this.email = stu.getEmail();
        this.classes_id = stu.getClasses();
        this.portrait = stu.getPortrait();
        this.passwd = stu.getPasswd();
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClasses() {
        return classes_id;
    }

    public void setClasses(int classes) {
        this.classes_id = classes;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
}
