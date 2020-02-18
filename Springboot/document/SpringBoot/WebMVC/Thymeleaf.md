# Thymeleaf

Thymeleaf is one of template engine that Spring Boot supports auto configuration.

There are several template engine that Spring Boot supports

* FreeMarker
* Groovy
* Thymeleaf
* Mustache

JSP not recommend because not working when JAR packaging and should packaging as WAR.

Let's look at the simple code.

There is `Controller` for return view.

~~~java
@Controller
public class ThController {

    @GetMapping("/Ewan")
    public String hello(Model model){
        model.addAttribute("name", "ewan");

        return "hello";
    }
}
~~~

`Model` Object can put attribute value and convey view that name is 'hello.**'.

And there is `hello.html` in templates folder.

If want Thymeleaf, should write `xmlns:th="http://www.thymeleaf.org"` in the `html` tag.

~~~html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1 th:text="${name}"></h1>
</body>
</html>
~~~

Can use the value passed to model as write `th:text="${name}"`