## Apollo github

github上为我们提供了详细的文档，架构解析以及原理解析

<https://github.com/ctripcorp/apollo>

## Apollo服务端搭建环境

### 1.环境要求

1.虚拟机内存：2g以上

2.JDK1.8

3.mysql5.7+

### 2.Apollo的搭建

1.将Apollo项目下载下来

![1559197134240](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559197134240.png)

![1559197571159](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559197571159.png)

![1559197819925](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559197819925.png)

这里下载的两个项目区别在于，apollo-master是源码和依赖jar包（建议打到本地maven仓库），而apollo-build-scripts-master是整个Apollo的环境包，启动shell脚本就可以启动整个Apollo服务环境。

2.创建Apollo服务的数据库

Apollo项目运行依赖两个mysql数据库，分别是apolloconfigdb(配置文件数据存放)和apollopotaldb（门户网站的数据库）

![1559198198071](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559198198071.png)

数据库要求版本在mysql5.7+的原因是Apollo的数据库一个表结构中可能存在多个timestamp类型数据，这在mysql5.7以前是会报错的。

数据库创建完成后：

![1559198335270](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559198335270.png)

3.上传apollo-build-scripts-master.zip到服务器后解压，修改demo.sh文件

![1559200979690](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559200979690.png)

启动demo.sh

![1559201127536](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559201127536.png)

关闭防火墙（不关闭防火墙将访问不到服务）

![1559201332470](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559201332470.png)

我们可以看到Apollo已经启动

1.eureka注册中心

![1559201539256](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559201539256.png)

2.Apollo门户（默认账号密码：apollo	admin）

![1559201556958](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559201556958.png)

![1559201750480](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559201750480.png)

### 3.应用端的接入

1.引用端引入apollo和eureka的

```xml
<!-- apollo -->
<dependency>
	<groupId>com.ctrip.framework.apollo</groupId>
	<artifactId>apollo-client</artifactId>
	<version>1.1.0</version>
</dependency>
    
<!-- https://mvnrepository.com/artifact/org.springframework.cloud/spring-cloud-starter-netflix-eureka-client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    <version>2.0.0.RELEASE</version>
</dependency>
```

2.配置eureka注册中心

```yaml
eureka:
  client:
    service-url:
      # eureka注冊中心的配置，集群用 
      defaultZone: http://192.168.1.106:8080/eureka
```

3.指定apollo读取配置的环境

如果是在windows环境中，需要在C:/opt/settings/server.properties文件中指定读取的配置环境

如果是在linux环境中，需要在/opt/settings/server.properties文件中指定读取的配置环境

比如设置env为DEV:

env=DEV

![1559492198249](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492198249.png)

4.在应用项目下创建app.properties文件以及apollo-env.properties文件，请注意路径问题，apollo默认会从这样的路径下读取这两个文件

![1559492359145](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492359145.png)

resources/META_INF/app.properties以及resources/apollo-env.properties

两个文件的内容分别如下：

![1559492463490](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492463490.png)

![1559492478072](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492478072.png)

5.在启动类上添加@EnableApolloConfig注解

![1559492569043](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492569043.png)

6.测试

编写测试类

![1559492622618](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492622618.png)

2.进入Apollo门户系统

![1559492675868](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492675868.png)

注意，AppId就是app.properties中的app.id属性值，新建了配置后发布，访问接口：

![1559492751733](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492751733.png)

修改此配置的值再重新发布

![1559492812979](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492812979.png)

![1559492832982](C:\Users\84644\AppData\Roaming\Typora\typora-user-images\1559492832982.png)

直接刷新接口就能获取到修改后的配置，说明应用端接入成功

