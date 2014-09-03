web.xml设置
<url-pattern>/rest/*</url-pattern>
==
测试 Hello 应用程序
要测试应用程序，可以打开您的浏览器并输入 URL http://<host>:<port>/<appctx>/rest/hello。您将看到响应 “Hello Jersey”
当然我输入的是：http://localhost:8080/rest/rest/hello，注：第一个rest为app名称，第二个rest为servlet-mapping映射参数，
当然，我们也可以设置<url-pattern>/*</url-pattern>，则请求的Url为：http://localhost:8080/rest/hello
====

rest web services
