package dragon.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

import dragon.bean.Employee;

/**
 * 使用spring测试模块提供测试的请求功能，测试crud的准确性
 * 
 * @author dragon
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {  "classpath*:spring-mvc.xml" ,"classpath*:applicationContext.xml"})
public class MvcTest {

	// 传入springmvc的ioc 需要@WebAppConfiguration
	@Autowired
	WebApplicationContext context;

	// 虚拟mvc请求，获取 处理结果
	MockMvc mockMvc;

	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPage() throws Exception {
		// 模拟请求拿到返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "1")).andReturn();

		MockHttpServletRequest request = result.getRequest();
		
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
		
		
		System.out.println("当前页面："+pi.getPageNum());
		System.out.println("总记录数："+pi.getTotal());
		System.out.println("总页码："+pi.getPages());
		System.out.println("当前页需要连续显示的页码数");
		int [] item = pi.getNavigatepageNums();
		for(int i : item) {
			System.out.println(""+i);
		}
		System.out.println("当前数量页面："+pi.getSize());
		
		List<Employee> EmployeeList = pi.getList();
		
		for(Employee emp : EmployeeList) {
			System.out.println("ID："+emp.getEmpId()+"===>"+"Name:"+emp.getEmpName());
		}
		
	}
}
