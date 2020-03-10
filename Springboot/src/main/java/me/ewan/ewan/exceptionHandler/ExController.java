package me.ewan.ewan.exceptionHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExController {

    @GetMapping("/excep")
    public String hello() {
        throw new Exexception();
    }

    @ExceptionHandler(Exexception.class)
    public @ResponseBody
    AppError sampleError(Exexception e) {
        AppError appError = new AppError();

        appError.setMessage("error.app.key");
        appError.setReason("IDK");
        return appError;
    }

}
