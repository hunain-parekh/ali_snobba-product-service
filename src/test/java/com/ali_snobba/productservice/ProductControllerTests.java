package com.ali_snobba.productservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.BDDMockito.*;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ali_snobba.productservice.Controller.ProductController;
import com.ali_snobba.productservice.Model.Product;
import com.ali_snobba.productservice.Repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;
import java.util.Optional;

@AutoConfigureJsonTesters
@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTests {

	@Autowired
    private MockMvc mvc;

    @Mock
    private IProductRepository productRepo;

	@InjectMocks
	private ProductController productController;

	private JacksonTester<Product> jsonProduct;
	private JacksonTester<List<Product>> jsonProducts;

	@BeforeEach
	public void setUp(){
		JacksonTester.initFields(this, new ObjectMapper());
		mvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void cansaveProductSuccessfully() throws Exception {
		String myName = "Ruby Slippers";
		String myShortDesc = "An impressive pair of slippers featuring thousands of real rubies.";
		String myLongDesc = "Harry Winston has carefully crafted these fantastic shoes. Each pair boasts a total of 4,600 gemstones including 1,350 carats of premium rubies and 50 carats of diamonds. You’ll be the talk of the town when you wear these slippers (not to mention the target of shoe thieves everywhere). Harry makes no promise about how comfortable these slippers are though.";
		String myImageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Long myProductPrice = 684750000L;
		Product product = Product.builder()
							.name(myName)
							.shortDesc(myShortDesc)
							.longDesc(myLongDesc)
							.imageLink(myImageLink)
							.price(myProductPrice)
							.build();
		mvc.perform(post("/api/product")
			.contentType(MediaType.APPLICATION_JSON)
			.content(jsonProduct.write(product).getJson()))
			.andExpect(status().isOk());
		verify(productRepo, times(1)).save(product);
	}

	@Test
	public void canGetAllProducts() throws Exception{
		String myName = "Ruby Slippers";
		String myShortDesc = "An impressive pair of slippers featuring thousands of real rubies.";
		String myLongDesc = "Harry Winston has carefully crafted these fantastic shoes. Each pair boasts a total of 4,600 gemstones including 1,350 carats of premium rubies and 50 carats of diamonds. You’ll be the talk of the town when you wear these slippers (not to mention the target of shoe thieves everywhere). Harry makes no promise about how comfortable these slippers are though.";
		String myImageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Long myProductPrice = 684750000L;
		Product product1 = Product.builder()
							.name(myName)
							.shortDesc(myShortDesc)
							.longDesc(myLongDesc)
							.imageLink(myImageLink)
							.price(myProductPrice)
							.build();
		Product product2 = Product.builder()
							.name(myName)
							.shortDesc(myShortDesc)
							.longDesc(myLongDesc)
							.imageLink(myImageLink)
							.price(myProductPrice)
							.build();
		given(productRepo.findAll()).willReturn(List.of(product1, product2));
		mvc.perform(get("/api/product/all")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonProducts.write(List.of(product1, product2)).getJson()));
	}

	@Test
	public void canGetProductById() throws Exception{
		Long myId = 1L;
		String myName = "Ruby Slippers";
		String myShortDesc = "An impressive pair of slippers featuring thousands of real rubies.";
		String myLongDesc = "Harry Winston has carefully crafted these fantastic shoes. Each pair boasts a total of 4,600 gemstones including 1,350 carats of premium rubies and 50 carats of diamonds. You’ll be the talk of the town when you wear these slippers (not to mention the target of shoe thieves everywhere). Harry makes no promise about how comfortable these slippers are though.";
		String myImageLink = "https://raw.githubusercontent.com/jeff-lent/Alisnobba/main/Capstone/ActualRubyRubySlippers.jpg";
		Long myProductPrice = 684750000L;
		Product product = Product.builder()
							.name(myName)
							.shortDesc(myShortDesc)
							.longDesc(myLongDesc)
							.imageLink(myImageLink)
							.price(myProductPrice)
							.build();
		given(productRepo.findById(myId)).willReturn(Optional.of(product));
		mvc.perform(get("/api/product/1")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().json(jsonProduct.write(product).getJson()));
	}
}

