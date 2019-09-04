package Tasks.Task1;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import Tasks.Task1.models.Message;
import Tasks.Task1.resources.TaskResource;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Task1ApplicationTests {
	
	@Autowired
	private TaskResource resource;
	
	@Autowired
	private MockMvc mockMvc;

	@Test 
	//Testing controller is not null
	public void contextLoads() throws Exception{
		assertThat(resource).isNotNull();
	}
	@Test
	//Tests get request without body return 400
	public void getWOBody() throws Exception{
		this.mockMvc.perform(get("/")).andExpect(status().is(400));
	}
	@Test
	//Tests get with body for 200 response
	public void testGet() throws Exception{
		this.mockMvc.perform(get("/")
				.contentType(new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"))).content("{\n" + 
				"        \"msg\": \"Test msg 123123\"\n" + 
				"    }"))
		.andExpect(status().isOk());
	}
	@Test
	// Tests the Message class and important functions
	public void messageTest() throws Exception{
		Message msg = new Message("test message");
		assertEquals("test message", msg.getMsg());
		assertEquals(Message.class, msg.getClass());
		assertEquals(msg.signMsg().getClass(), byte[].class);
		assertNotEquals(msg.signMsg(), msg.getMsg());
	}
	
	
}
