import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mtc.app.config.AppConfig;
import com.mtc.app.dao.ProductDAO;
import com.mtc.app.vo.Product;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductDAO productDAO = applicationContext.getBean(ProductDAO.class);

		Product product1 =  new Product(36,"Wrist watch", 1000, "Fastrack",55);
		Product product2 =  new Product(37,"chapati", 10, "Homemade",5);
		Product product3 =  new Product(38,"rice", 100, "basmati",20);
		
		List<Product> products = new ArrayList<>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		productDAO.insertBatch(products);
		
	}

}
