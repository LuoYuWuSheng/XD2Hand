package site.luoyu;

import org.springframework.stereotype.Component;

/**
 * Created by luoyu on 2018/3/7.
 * 这是要给spring bean的示例，
 * 属性必须要有getter 与setter才行
 * 然后在spring的配置文件中进行配置就行
 *
 *  <bean id="testBean" class="site.luoyu.testBean">
        <property name="name" value="hahaha"/>
    </bean>
 */
@Component
public class testBean {
    private String name;
    private int age;
    public String publicName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }
}
