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