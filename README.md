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


