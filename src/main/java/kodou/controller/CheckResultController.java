package kodou.controller;

import kodou.model.CheckResult;
import kodou.model.ResultCode;
import kodou.model.Site;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckResultController {

    @RequestMapping("/results")
    public CheckResult CheckResult(@RequestParam(value="name", defaultValue="hi") String name) {
        return new CheckResult(new Site("Google","www.google.com",80,5), ResultCode.OK);
    }

}
