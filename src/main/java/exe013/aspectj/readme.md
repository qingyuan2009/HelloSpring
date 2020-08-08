# AspectJ 支持5种类型的通知

1.	@Before 前置通知
2.	@After	后置通知
3.	@AfterReturning	返回通知，方法返回结果后执行
4.	@AfterThrowing	异常通知
5.	@Around	环绕通知，围绕着方法执行，可以理解为前置，后置，返回，异常通知的结合体


# POM
<!-- AOP -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aop</artifactId>
	<version>5.2.1.RELEASE</version>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aspects</artifactId>
	<version>5.2.1.RELEASE</version>
</dependency>

<!-- aspectJ -->
<dependency>
	<groupId>net.sourceforge.cglib</groupId>
	<artifactId>com.springsource.net.sf.cglib</artifactId>
	<version>2.2.0</version>
</dependency>

<dependency>
	<groupId>org.aopalliance</groupId>
	<artifactId>com.springsource.org.aopalliance</artifactId>
	<version>1.0.0</version>
</dependency>

<dependency>
	<groupId>org.aspectj</groupId>
	<artifactId>com.springsource.org.aspectj.weaver</artifactId>
	<version>1.7.2.RELEASE</version>
</dependency>