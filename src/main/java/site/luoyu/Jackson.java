package site.luoyu;

import com.fasterxml.jackson.databind.ObjectMapper;
import site.luoyu.model.UserModel;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by luoyu on 2018/3/7.
 */
public class Jackson {

    public String testJackson(){

        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            File tempFile = new File(".");
            URL path = Jackson.class.getResource("/");
            System.out.println(path.getPath());
            UserModel userModel = mapper.readValue(new File(Jackson.class.getResource("/").getPath()+"/test.json"), UserModel.class);
            System.out.println(userModel.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        new Jackson().testJackson();
    }
}
