
使用apache-tomcat-7.0.54 + spring 3.0.5 + Jersey 1.18.1构建restful web services
##示例说明
***
###web.xml中针对servlet-mapping的设置

```
<servlet-mapping>
        <servlet-name>Rest_Servlet</servlet-name>
        <!-- Redirect any calls to our jersey servlet -->
        <url-pattern>/rest/*</url-pattern>
</servlet-mapping>
```
###测试 Hello 应用程序
当然我输入的是：<http://localhost:8080/rest/rest/hello>，您将看到响应“Hello World”.

注：第一个rest为app名称，第二个rest为servlet-mapping映射参数，

当然，我们也可以设置<url-pattern>/*</url-pattern>，

```
<servlet-mapping>
        <servlet-name>Rest_Servlet</servlet-name>
        <!-- Redirect any calls to our jersey servlet -->
        <url-pattern>/*</url-pattern>
</servlet-mapping>
```
则请求的url为：<http://localhost:8080/rest/hello>

##构建restful web服务
***
###HTTP 方法
HTTP 方法映射到资源的 CRUD（创建、读取、更新和删除） 操作。尽管您可以做一些小修改，比如让 PUT 方法变成创建或更新，但基本的模式如下：

*   HTTP GET：获取/列出/检索单个资源或资源集合。
*   POST：新建资源。通常通过填写表单创建新联系人。也就是说，HTML 表单将 POST 到服务器，服务器创建并维护新创建的联系人
*   HTTP PUT：更新现有资源或资源集合。
*   HTTP DELETE：删除资源或资源集合。


###使用curl与REST服务通讯
Curl 是一个流行的命令行工具，可以向使用 HTTP 和 HTTPS 协议的服务器发送请求。这是一个与 RESTful Web 服务通讯的好工具，因为它可以通过任何 HTTP 方法发送内容。

现在，我们初始化获取所有联系人的第一个 curl 命令:

```
curl http://localhost:8080/rest/rest/hello
```

结果：响应内容将使用XML返回并包含所有联系人。

```
curl –HAccept:application/json http://localhost:8080/rest/rest/hello
```
结果：响应将是一个包含所有联系人的 JSON 字符串

现在，我将 PUT 一个新的联系人，

```
curl -X PUT -HContent-type:application/xml --data "<contact><id>foo</id><name>bar</name></contact>" http://localhost:8080/Jersey/rest/contacts/foo
```
一个通过 “foo” 识别的新联系人将添加到联系人存储库。

##参考链接
<http://www.ibm.com/developerworks/cn/web/wa-aj-tomcat/>