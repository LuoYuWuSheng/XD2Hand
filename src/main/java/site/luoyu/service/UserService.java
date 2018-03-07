package site.luoyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.luoyu.dao.entity.UserStudent;
import site.luoyu.dao.mapper.UserStudentMapper;
import site.luoyu.model.User;
import java.io.UnsupportedEncodingException;

/**
 * Created by luoyu on 2018/3/7.
 * 目前对service的理解是，仅仅是一种特殊的bean
 * 通过@service方式来注解，通过@autowired来使用
 * 其余的没有区别，这里需要再确定
 */
//todo 这里的user都依赖于model中的user 而不直接依赖于dao中的内容。这样做的目的是为了当数据库改变的时候前段代码不需要改变
//    每次都会遇到这个问题，直接封装好的entity 不能直接放到前台。但是又不知道怎么封装，这是一个临时办法。
@Service
public class UserService {

    @Autowired
    private UserStudentMapper userStudentRepository;

    /**
     * 用户登录
     * @param user
     *      传入想要登录操作的用户
     */
    //todo 登录操作通过名称来标识，没有处理重名的问题
    public User login(User user){
        UserStudent loginResult = userStudentRepository.userLogin(user.getName(), user.getPasswd());
        User result = null;
        if (loginResult != null) result = new User(loginResult);
        return result;
    }

    /**
     * 用户注册服务
     * @param user
     *      学生
     * @return 是否成功
     */
    //todo bug 保存的时候竟然只保存一个
    public boolean register(User user) {
        UserStudent userStudent = new UserStudent();
        String encode = null;
        try {
            encode = new String(user.getName().getBytes("iso8859-1"),"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        userStudent.setName(encode);
        userStudent.setPasswd(user.getPasswd());
        userStudentRepository.insert(userStudent);
        return true;
    }

    /**
     * 用户信息保存接口，用户保存信息，更改信息都通过这里来保存。
     * @param user
     *      学生
     * 注册服务
     */
    public void updateInfo(User user){
        UserStudent userStudent = userStudentRepository.selectByPrimaryKey(user.getStuId());
        userStudent.setName(user.getName());
    	userStudent.setPasswd(user.getPasswd());
        userStudentRepository.updateByPrimaryKey(userStudent);

    }
}
