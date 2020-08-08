#来源
Spring-大数据定制版-尚硅谷-spring - java

# HelloSpring

详见Bean配置的xml文件

# 使用annotation

*	@Component: 受IOC容器管理的组件
*	@Repository: 受IOC容器管理的持久化层组件
*	@Servic: 受IOC容器管理的业务逻辑层组件
*	@Controller: 受IOC容器管理的表述层控制器组件

这4个注解使用上没有区别，可以都使用@Component, 区分只是有助于管理理解

# MVC

*	视图层/表述层： MVC
	V：视图层  JSP...
	C：控制层，讲后台数据通过模型层返回给视图  --> @Controller
	M：模型层
*	业务逻辑层: service  --> @Service
*	数据访问层/持久层： DAO  --> @Repository

Controller(MVC) <-> Service <-> DAO

# Autowired
注意例子裏的通過接口調用bean
Autowired是先用byType, 然後在用byName

**@Repository("dao")**   //指定ID值
**@Autowired(required=false)**  // required=false, 能裝配就裝配，不行也不報異常
**@Qualifier("userJDBCImpl")**  // 在自動裝配是指定需要裝配的類名
private UserDAO dao;

# 動態代理
1.	基於接口實現動態代理： JDK
2.	基於繼承實現動態代理： Cglib, Javassist

//動態代理類都是動態生成的， 默認是在memory中， 這裏可以把它保存到硬盤
Properties properties = System.getProperties();
properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//可以com文件夾中看到生成的代理類： $Proxy0.class

# AOP
1.	横切关注点： 从每个方法中抽取出来的同一类非核心业务， 比如方法中的前置后置日志功能
2.	切面(Aspect): 封装横切关注点信息的类，每个关注点体现为一个通知方法
3.	通知(Advice)：切面必须要完成的各个具体工作
4.	目标(Target): 被通知的对象
5.  代理(Proxy)：创建的代理对象
6.	连接点(JointPoint): 横切关注点具体实现在对应程序中的位置。纵横坐标：
	横坐标：方法， 比如add(int i, int j), sub, multiple, divid...
	纵坐标：方法开始，捕获异常， 方法结束
7.	切入点(PointCut): 把日志功能运用在连接点，就意味着这是切入点

# AspectJ

# Spring对JDBC的支持
为了使JDBC更加易于使用，Spring在JDBC API上定义了一个抽象层，以此建立一个JDBC存取框架
Spring提供JDBCTemplate, 与DAO Util类似





