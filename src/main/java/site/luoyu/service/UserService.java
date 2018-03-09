package site.luoyu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.luoyu.dao.entity.User;
import site.luoyu.dao.mapper.UserMapper;
import site.luoyu.model.UserModel;

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
    private UserMapper userMapper;

    /**
     * 用户登录
     * @param userModel
     *      传入想要登录操作的用户
     */
    //todo 登录操作通过名称来标识，没有处理重名的问题
    public UserModel login(UserModel userModel){
        User loginUserModel = userMapper.login(userModel.getName(), userModel.getPasswd());
        UserModel result = null;
        if (loginUserModel != null) result = new UserModel(loginUserModel);
        return result;
    }

    /**
     * 用户注册服务
     * @param userModel
     *      学生
     * @return 是否成功
     */
    //todo bug 保存的时候竟然只保存一个
    public boolean register(UserModel userModel) {
        User user = new User();
        String encode = null;
        try {
            encode = new String(userModel.getName().getBytes("iso8859-1"),"UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setName(encode);
        user.setPasswd(userModel.getPasswd());
        userMapper.insert(user);
        return true;
    }

    /**
     * 用户信息保存接口，用户保存信息，更改信息都通过这里来保存。
     * @param userModel
     *      学生
     * 注册服务
     */
    public void updateInfo(UserModel userModel){
        User user = userMapper.selectByPrimaryKey(userModel.getStuId());
        user.setName(userModel.getName());
    	user.setPasswd(userModel.getPasswd());
        userMapper.updateByPrimaryKey(user);

    }
}
