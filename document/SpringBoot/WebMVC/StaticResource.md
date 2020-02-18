# StaticResource

When provide static resource in SpringBoot, there are several basic resource location.

 * Basic resource location
    * classpath:/static
    * classpath:/public
    * classpath:/resources/
    * classpath:/META-INF/resources
    * example) “/hello.html” => /static/hello.html
    * spring.mvc.static-path-pattern: Able to change mapping setting
    * spring.mvc.static-locations: Able to change to find resource location
    
The browser send `304` response according to `Last-Modified`.

If want customizing resource location or path, create `addResourceHandlers` and write what you want for own customizing.

~~~java
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/m/**")   //request path
                .addResourceLocations("classpath:/m/")  //ResourceLocations 
                .setCachePeriod(20);
    }
}
~~~