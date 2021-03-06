package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.app.mapper.AppsEntity;
import hello.app.mapper.AppsMapper;
import hello.user.mapper.UsersEntity;
import hello.user.mapper.UsersMapper;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private AppsMapper appsMapper;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/users")
    public List<UsersEntity> users() {
        //(new UsersEntity()).g
        List<UsersEntity> lists = usersMapper.findAll();
        return lists;
    }

    @RequestMapping("/apps")
    public List<AppsEntity> apps() {
        //(new UsersEntity()).g
        List<AppsEntity> lists = appsMapper.findAll();
        return lists;
    }
}
