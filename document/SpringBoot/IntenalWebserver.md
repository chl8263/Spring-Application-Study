# Internal Web Server

First of all, spring boot isn't one of server. It just create WebServer instance internally.

To create internal WebServer, like below.

1. Create Tomcat Object.
2. Set port.
3. Add context at Tomcat.
4. Create Servlet.
5. Add Servlet at Tomcat.
6. Mapping Servlet at Tomcat.
7. Execute Tomcat and wait.

Here is executable WebServer without Springboot internal WebServer.

~~~java
public static void main(String[] args) throws LifecycleException {
    Tomcat tomcat = new Tomcat();   //1. Create Tomcat Object.
    tomcat.setPort(7070);   //2. Set port.

    Context context = tomcat.addContext("/", "/");  //3. Add context at Tomcat.

    HttpServlet servlet = new HttpServlet() {   //4. Create Servlet.
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter writer = resp.getWriter();
            writer.println("<html>");
            writer.println("<body>");
            writer.println("hello!");
            writer.println("</body>");
            writer.println("</html>");
        }
    };

    String servletName = "helloServelet";
    tomcat.addServlet("/",servletName, servlet);    //5. Add Servlet at Tomcat.
    context.addServletMappingDecoded("/hello", servletName);    //6. Mapping Servlet at Tomcat.

    tomcat.start();     //7. Execute Tomcat and wait.
}
~~~

But, If use SpringBoot, do not have to care about above setting.

SpringBoot execute internal WebServer write as below code.

~~~java
SpringApplication app = new SpringApplication(Application.class);
app.run(args);
~~~

If don't want running as WebServer, can write below setting at `application.properties`.
~~~
spring.main.web-application-type=none
~~~

Then, SprungBoot run as normal application.

Also can setting port number what you want as shown below.

~~~
server.port=7070
~~~

If want setting an available port automatically, write code as shown below.

~~~
server.port=0
~~~
