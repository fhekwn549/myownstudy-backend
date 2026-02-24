package com.ubisam.example2;

import static io.u2ware.common.docs.MockMvcRestDocs.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.ubisam.example2.helloes.Hello;
import com.ubisam.example2.helloes.HelloRepository;


@SpringBootTest
@AutoConfigureMockMvc //웹 테스트
class Example2ApplicationTests {

	@Autowired
	private HelloRepository helloRepository;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {

		Hello h = new Hello();
		h.setName("name1");
		h.setEmail("abc@abc.com");
		helloRepository.save(h);
	}

	//웹 요청 Test
	@Test
	void contextLoad2() throws Exception {
		//perform : 요청 구간
		//andDo : 응답 구간(결과가 나오고 나서 무언가를 하고 싶을때)
		//andExpect : 검증 구간(결과를 기대하는 구간)

		Hello h = new Hello();
		h.setName("name1");
		h.setEmail("abc@abc.com");
		//save
		mockMvc.perform(post("/helloes").content(h)).andDo(print()).andExpect(is2xx());

		mockMvc.perform(get("/helloes")).andDo(print()).andExpect(is2xx());
	}
}
