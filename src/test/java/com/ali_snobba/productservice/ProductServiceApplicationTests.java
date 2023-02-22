package com.ali_snobba.productservice;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ali_snobba.productservice.Model.Product;

@SpringBootTest
class ProductServiceApplicationTests {


	@Test
	void contextLoads() {
	}

	@Test
	void getAndSetProductID(){
		Product product = new Product();
		Long myId = 1L;
		product.setId(myId);
		assertEquals(myId, product.getId());
	}

	@Test
	void getAndSetProductName(){
		Product product = new Product();
		String myName = "Ruby Slippers";
		product.setName(myName);
		assertEquals(myName, product.getName());
	}

	@Test
	void getAndSetProductShortDesc(){
		Product product = new Product();
		String myShortDesc = "An impressive pair of slippers featuring thousands of real rubies.";
		product.setShortDesc(myShortDesc);
		assertEquals(myShortDesc, product.getShortDesc());
	}

	@Test
	void getAndSetProductLongDesc(){
		Product product = new Product();
		String myLongDesc = "Harry Winston has carefully crafted these fantastic shoes. Each pair boasts a total of 4,600 gemstones including 1,350 carats of premium rubies and 50 carats of diamonds. You’ll be the talk of the town when you wear these slippers (not to mention the target of shoe thieves everywhere). Harry makes no promise about how comfortable these slippers are though.";
		product.setLongDesc(myLongDesc);
		assertEquals(myLongDesc, product.getLongDesc());
	}

	@Test
	void getAndSetProductImageLink(){
		Product product = new Product();
		String myImageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		product.setImageLink(myImageLink);
		assertEquals(myImageLink, product.getImageLink());
	}

	@Test
	void getAndSetProductPrice(){
		Product product = new Product();
		Long myProductPrice = 684750000L;
		product.setPrice(myProductPrice);
		assertEquals(myProductPrice, product.getPrice());
	}

	@Test
	void allArgsConstructorProduct(){
		Long myId = 1L;
		String myName = "Ruby Slippers";
		String myShortDesc = "An impressive pair of slippers featuring thousands of real rubies.";
		String myLongDesc = "Harry Winston has carefully crafted these fantastic shoes. Each pair boasts a total of 4,600 gemstones including 1,350 carats of premium rubies and 50 carats of diamonds. You’ll be the talk of the town when you wear these slippers (not to mention the target of shoe thieves everywhere). Harry makes no promise about how comfortable these slippers are though.";
		String myImageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Long myProductPrice = 684750000L;
		Product product = new Product(myId,myName,myShortDesc,myLongDesc,myImageLink,myProductPrice);
		assertEquals(myId, product.getId());
		assertEquals(myName, product.getName());
		assertEquals(myShortDesc, product.getShortDesc());
		assertEquals(myLongDesc, product.getLongDesc());
		assertEquals(myImageLink, product.getImageLink());
		assertEquals(myProductPrice, product.getPrice());
	}

	@Test
	void builderProduct(){
		Long myId = 1L;
		String myName = "Ruby Slippers";
		String myShortDesc = "An impressive pair of slippers featuring thousands of real rubies.";
		String myLongDesc = "Harry Winston has carefully crafted these fantastic shoes. Each pair boasts a total of 4,600 gemstones including 1,350 carats of premium rubies and 50 carats of diamonds. You’ll be the talk of the town when you wear these slippers (not to mention the target of shoe thieves everywhere). Harry makes no promise about how comfortable these slippers are though.";
		String myImageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Long myProductPrice = 684750000L;
		Product product = Product.builder()
							.id(myId)
							.name(myName)
							.shortDesc(myShortDesc)
							.longDesc(myLongDesc)
							.imageLink(myImageLink)
							.price(myProductPrice)
							.build();
		assertEquals(myId, product.getId());
		assertEquals(myName, product.getName());
		assertEquals(myShortDesc, product.getShortDesc());
		assertEquals(myLongDesc, product.getLongDesc());
		assertEquals(myImageLink, product.getImageLink());
		assertEquals(myProductPrice, product.getPrice());
	}
}
