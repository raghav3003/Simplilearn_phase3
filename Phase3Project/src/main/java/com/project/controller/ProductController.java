package com.project.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.ProductEntity;
import com.project.repository.ProductRepository;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
    ProductRepository productRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/all")
	public List<ProductEntity> getAllProduct(){
		return productRepository.findAll();
    }
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	public void addProduct(@RequestBody ProductEntity pe) {
		Date x = new Date(System.currentTimeMillis());
//		LocalDateTime myDateObj = LocalDateTime.now();
////	    System.out.println("Before formatting: " + myDateObj);
//	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		System.out.println(x);
		pe.setCreatedDate(x);
		productRepository.save(pe);
    }
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody ProductEntity pe) {
		if(productRepository.findById(id).isPresent()) {
            ProductEntity oldProductEntity=productRepository.findById(id).get();
            oldProductEntity.setBrand(pe.getBrand());
            oldProductEntity.setCategory(pe.getCategory());
            oldProductEntity.setColor(pe.getColor());
            oldProductEntity.setCreatedDate(pe.getCreatedDate());
            oldProductEntity.setDiscount(pe.getDiscount());
            oldProductEntity.setPrice(pe.getPrice());
            oldProductEntity.setSeason(pe.getSeason());
            productRepository.save(oldProductEntity);
        }
    }
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
    public void deleteProduct(@PathVariable int id)  {
		productRepository.deleteById(id);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/search/brand/{brand}")
    public List<ProductEntity> findProductByBrandName(@PathVariable String brand)  {
		return productRepository.findByBrand(brand);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/search/season/{season}")
    public List<ProductEntity> findProductBySeasonName(@PathVariable String season)  {
		return productRepository.findBySeason(season);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/search/category/{category}")
    public List<ProductEntity> findProductByCategoryName(@PathVariable String category)  {
		return productRepository.findByCategory(category);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/search/color/{color}")
	public List<ProductEntity> findProductByColorName(@PathVariable String color)  {
		return productRepository.findByColor(color);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/search/price/{order}")
	public List<ProductEntity> findProductByPrice(@PathVariable String order)  {
		
		List<ProductEntity> products = productRepository.findAll();
		Collections.sort(products, Comparator.comparing(ProductEntity::getPrice));
		
		if (order.toLowerCase().equals("asc")) {
			return products;
		} else if (order.toLowerCase().equals("desc")) {
			Collections.reverse(products);
			return products;
		}
		return null;
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/search/date/{order}")
	public List<ProductEntity> findProductByDate(@PathVariable String order)  {
		
		List<ProductEntity> products = productRepository.findAll();
		Collections.sort(products, Comparator.comparing(ProductEntity::getCreatedDate));
		
		if (order.toLowerCase().equals("asc")) {
			return products;
		} else if (order.toLowerCase().equals("desc")) {
			Collections.reverse(products);
			return products;
		}
		return null;
    }
	
}
