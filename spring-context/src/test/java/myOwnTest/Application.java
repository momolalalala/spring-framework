package myOwnTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lxj on 2016/6/29.
 */
@Configuration
@ComponentScan
public class Application {

    //这里就相当于 <bean id="mockMessageService" class="myOwnTest.MessageService" />
    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            @Override
            public String getMessage() {
                return "hello world!";
            }
        };
    }

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = ac.getBean(MessagePrinter.class);
        printer.printService();
        MessageService ms = (MessageService)ac.getBean("mockMessageService");
        System.out.println("ms: " + ms.getMessage());
    }
}
