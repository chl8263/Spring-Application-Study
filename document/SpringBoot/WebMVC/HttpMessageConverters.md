# HttpMessageConverters

MessageConverters is used to convert Http body to Object or convert Object to Http response Body.

* #### If use `@Controller`, should write `@ResponseBody`.

~~~java
@Controller
public class UserController {

    @PostMapping("/user/create")
    public @ResponseBody User create(@RequestBody User user){
        return user;
    }
}
~~~

* #### If use `@RestController`, can skip `@ResponseBody`.

~~~java
@RestController
public class UserController {
    @PostMapping("/user/create")
    public User create(@RequestBody User user){
        return user;
    }
}
~~~