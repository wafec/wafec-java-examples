package springsecurity.customfilter;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/content")
public class ContentApi {
    @GetMapping("/text")
    public String getText() {
        return "Some text";
    }

    @GetMapping("/hello")
    @Secured("SOME_ROLE")
    public String getHello() {
        return "Hello";
    }
}
