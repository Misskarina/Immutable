package com.karina.Immutable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	BookRepository brepo;
	
	@RequestMapping("/test")
	public String test()
	{
		return "program tested";
	}
	
	@RequestMapping("/save")
	public String save()
	{
		Book b=new Book();
		b.setBookname("One indian girl");
		b.setAuthorname("chetan bhagat");
		b.setPrice(6443);
		brepo.save(b);
		return"data saved";
	}
	
	@RequestMapping("/findall")
	public List<Book> all()
	{
		return brepo.findAll();
		
	}
	
	@RequestMapping("/update/{id}/{bookname}/{authorname}/{price}")
	public String update(@PathVariable int id,@PathVariable String bookname,@PathVariable String authorname,@PathVariable int price)
	{
		Book b1=new Book();
		b1.setBookname(bookname);
		b1.setAuthorname(authorname);
		b1.setPrice(price);
		brepo.save(b1);
		return "data Updated";
	}
	
}
