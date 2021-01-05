package davenkin;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import mapper.GrammarMapper;
import pojo.Grammar;
import pojo.Mean;
import java.util.*;
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

    @RequestMapping("/search")
    public List<Mean> findById(@RequestParam("keyword") String keyword) {
        System.out.println(keyword);
        List<Mean> means = grammarMapper.findByKeyword(keyword);
        return means;
    }
}
