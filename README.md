#��Դ
Spring-�����ݶ��ư�-�й��-spring - java

# HelloSpring

���Bean���õ�xml�ļ�

# ʹ��annotation

*	@Component: ��IOC������������
*	@Repository: ��IOC��������ĳ־û������
*	@Servic: ��IOC���������ҵ���߼������
*	@Controller: ��IOC��������ı�������������

��4��ע��ʹ����û�����𣬿��Զ�ʹ��@Component, ����ֻ�������ڹ������

# MVC

*	��ͼ��/�����㣺 MVC
	V����ͼ��  JSP...
	C�����Ʋ㣬����̨����ͨ��ģ�Ͳ㷵�ظ���ͼ  --> @Controller
	M��ģ�Ͳ�
*	ҵ���߼���: service  --> @Service
*	���ݷ��ʲ�/�־ò㣺 DAO  --> @Repository

Controller(MVC) <-> Service <-> DAO

# Autowired
ע�������Y��ͨ�^�ӿ��{��bean
Autowired������byType, Ȼ������byName

**@Repository("dao")**   //ָ��IDֵ
**@Autowired(required=false)**  // required=false, ���b����b�䣬����Ҳ���󮐳�
**@Qualifier("userJDBCImpl")**  // ���Ԅ��b����ָ����Ҫ�b������
private UserDAO dao;

# �ӑB����
1.	��춽ӿڌ��F�ӑB���� JDK
2.	����^�Ќ��F�ӑB���� Cglib, Javassist

//�ӑB������ǄӑB���ɵģ� Ĭ�J����memory�У� �@�Y���԰������浽Ӳ�P
Properties properties = System.getProperties();
properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//����com�ļ��A�п������ɵĴ���� $Proxy0.class

# AOP
1.	���й�ע�㣺 ��ÿ�������г�ȡ������ͬһ��Ǻ���ҵ�� ���緽���е�ǰ�ú�����־����
2.	����(Aspect): ��װ���й�ע����Ϣ���࣬ÿ����ע������Ϊһ��֪ͨ����
3.	֪ͨ(Advice)���������Ҫ��ɵĸ������幤��
4.	Ŀ��(Target): ��֪ͨ�Ķ���
5.  ����(Proxy)�������Ĵ������
6.	���ӵ�(JointPoint): ���й�ע�����ʵ���ڶ�Ӧ�����е�λ�á��ݺ����꣺
	�����꣺������ ����add(int i, int j), sub, multiple, divid...
	�����꣺������ʼ�������쳣�� ��������
7.	�����(PointCut): ����־�������������ӵ㣬����ζ�����������

# AspectJ

# Spring��JDBC��֧��
Ϊ��ʹJDBC��������ʹ�ã�Spring��JDBC API�϶�����һ������㣬�Դ˽���һ��JDBC��ȡ���
Spring�ṩJDBCTemplate, ��DAO Util����





