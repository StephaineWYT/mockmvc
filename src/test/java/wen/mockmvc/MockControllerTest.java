package wen.mockmvc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import wen.mockmvc.controller.MockController;
import wen.mockmvc.pojo.User;
import wen.mockmvc.service.MockService;

import static org.mockito.BDDMockito.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(MockController.class)
@Slf4j
public class MockControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MockService mockService;

    @Before
    public void setUp() {
        User user = new User(1L, "123", "123");

        // given方法，调用特定方法时返回特定值时使用
        given(mockService.getUser(any())).willReturn(user);

    }

    /**
     * 执行流程:
     * MockMvcRequestBuilders.get() 返回一个MockHttpServletRequestBuilder对象;
     * MockHttpServletRequestBuilder.param() 添加请求传值，可以带多个参数; (这里并没有使用到)
     * MockHttpServletRequestBuilder.accept(MediaType.TEXT_HTML_VALUE)) 设置返回类型; (这里并没有使用到)
     * <p>
     * mockMvc.perform()方法，执行一个RequestBuilder请求，调用controller的业务处理逻辑，perform()方法返回ResultActions，返回操作结果，通过ResultActions，提供了统一的验证方式;
     * <p>
     * ResultActions.andExpect添加执行完成后的断言，验证执行结果是否正确;
     * ResultActions.andDo添加一个MockMvcResultHandlers结果处理器，表示要对结果做点什么事情，如此处使用MockMvcResultHandlers.print()输出整个响应结果信息;
     * ResultActions.andReturn表示执行完成后返回相应的结果。
     *
     * @throws Exception
     */
    @Test
    public void getAuthUser() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/mock/user/16"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }


}

