package springsecurity.customfilter;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/some")
public class SomeApi {
    @GetMapping("/calc-add")
    public Integer calcAdd(@RequestParam("x") Integer x,
                        @RequestParam("y") Integer y) {
        return x + y;
    }

    @GetMapping("/calc-multiply")
    @Secured("SOME_ROLE")
    public Integer calcMultiply(@RequestParam("x") Integer x,
                                @RequestParam("y") Integer y) {
        return x * y;
    }
}
