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
	V：视图层
	C：控制层，讲后台数据通过模型层返回给视图  --> @Controller
	M：模型层
*	业务逻辑层: service  --> @Service
*	数据访问层/持久层： DAO  --> @Repository