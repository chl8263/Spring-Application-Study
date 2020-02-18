# ExceptionHandler

Exception Handler is for handle when occurred error. When occurred error, execute `ExceptionHandler` that made by programmer.

In below code, when an `/excep` request comes in, throw custom error.  

~~~java
@Controller
public class ExController {

    @GetMapping("/excep")
    public String hello(){
        throw new Exexception();
    }
~~~

Custom exception `Exexception` is just extend RuntimeException.

~~~java
public class Exexception extends RuntimeException {
}
~~~

If want to show custom error, using `@ExceptionHandler` annotation that means any error coming into this controller will be handled here.

~~~java
@ExceptionHandler(Exexception.class)
    public @ResponseBody AppError sampleError(Exexception e){
        AppError appError = new AppError();

        appError.setMessage("error.app.key");
        appError.setReason("IDK");
        return appError;
    }
~~~

