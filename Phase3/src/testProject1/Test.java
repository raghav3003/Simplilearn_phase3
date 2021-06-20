package testProject1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r = new ClassPathResource("applicationContext.xml");
		BeanFactory bf =new XmlBeanFactory(r);
		Employee s = (Employee) bf.getBean("e");
		s.display();
		
	}

}
