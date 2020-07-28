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


