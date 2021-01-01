package davenkin;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import mapper.GrammarMapper;
import pojo.Grammar;
@RestController("/helloworld")
public class HelloController {

    private HelloWorld helloWorld;

    @Autowired
    private GrammarMapper grammarMapper;

    public HelloController(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

    @GetMapping
    public String hello() {
        return helloWorld.hello();
    }

    @RequestMapping("/find")
    public String findById() {
        Grammar grammar = grammarMapper.findByID(10002);
        return grammar.getTitle();
    }
}
