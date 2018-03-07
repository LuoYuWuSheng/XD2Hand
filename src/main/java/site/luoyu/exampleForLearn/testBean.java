package site.luoyu.exampleForLearn;

/**
 * Computer user luoyu
 * Created by 张洋 on 2018/3/7.
 */
public class testBean {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public void Say() {
        System.out.println(name);
    }
}

