package site.luoyu.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;
import site.luoyu.dao.entity.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 这里定义的是和用户相关的信息。
 * 底层直接调用dao中的内容进行持久化
 * Created by luoyu on 2018/3/7.
 */
@Component
public class UserModel {

    private int stuId;
//  Spring 校验这里的信息是写死的，其实可以利用资源文件实现Spring对多语言的支持，没有做继续尝试
    @NotNull(message = "用户名不能为空")
    @Size(min = 6, max = 10,message = "用户名最小不少于6个，最多不多于10个")
    private String name;
    @NotNull(message = "密码不能为空")
    @JsonIgnoreProperties
    private String passwd;
//    true for seller false for buyer
    private Boolean type;

    //无参构造函数
    public UserModel() {
    }

    /**
     * 从entity构造
     * @param stu
     *      传过来的stu实体
     */
    public UserModel(User stu) {
        this.stuId = stu.getUserId();
        this.name = stu.getName();
        this.passwd = stu.getPasswd();
        this.type = stu.getType();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
}
