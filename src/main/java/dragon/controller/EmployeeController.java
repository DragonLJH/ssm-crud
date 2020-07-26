package dragon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dragon.bean.Employee;
import dragon.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


//	@RequestMapping("emps")
	public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn,Model model) {
		//引入PageHelper插件
		//在查询之前只需要调用，传入页码，以及每页的大小	
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的查询就是分页查询
		List<Employee> employeeList = employeeService.getEmps();
		
		//使用PageInfo包装查询后的结果，只需要将PageINfo交给页面
		PageInfo pageInfo = new PageInfo(employeeList);
		model.addAttribute("pageInfo", pageInfo);

		return "list";
	}
	
	@RequestMapping("emps")
	@ResponseBody
	public PageInfo getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		//引入PageHelper插件
		//在查询之前只需要调用，传入页码，以及每页的大小	
		PageHelper.startPage(pn, 5);
		//startPage后面紧跟的查询就是分页查询
		List<Employee> employeeList = employeeService.getEmps();
		
		//使用PageInfo包装查询后的结果，只需要将PageINfo交给页面
		PageInfo pageInfo = new PageInfo(employeeList);

		return pageInfo;
	}

}
