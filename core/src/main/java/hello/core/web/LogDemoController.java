package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    // private final ObjectProvider<MyLogger> myLoggerProvider; // DL 역할
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        // MyLogger myLogger = myLoggerProvider.getObject(); // 필요한 시점에 주입을 받음
        System.out.println("myLogger.getClass() = " + myLogger.getClass()); // 진짜 myLogger가 아님
        myLogger.setRequestURL(requestURL); 

        myLogger.log("Controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
