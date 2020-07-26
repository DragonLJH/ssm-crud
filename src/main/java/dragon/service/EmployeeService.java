package dragon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dragon.bean.Employee;
import dragon.dao.EmployeeMapper;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	
	public void setEmployeeMapper(EmployeeMapper employeeMapper) {
		this.employeeMapper = employeeMapper;
	}


	/**
	 * 查询所有员工数据（分页查询）
	 * @return 
	 */
	public List<Employee> getEmps() {
		return employeeMapper.selectByExampleWithDept(null);
	}

}
