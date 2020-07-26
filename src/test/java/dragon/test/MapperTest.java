package dragon.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dragon.bean.Employee;
import dragon.dao.DepartmentMapper;
import dragon.dao.EmployeeMapper;

/**
 * 测试dao层的工作
 * @author dragon
 *推荐spring项目使用spring的单元测试，可以自动注入我们需要的组件
 *1、导入springTest模块
 *2、@ContextConfiguration指定spring配置文件的位置
 *3、直接@Autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper employeeMapper; 
	
	@Autowired
	SqlSession sqlSession;
	
	@Test
	public void testCRUD() {
		System.out.println(departmentMapper);
//		Department dept = departmentMapper.selectByPrimaryKey(1);
//		System.out.println(dept);
//		插入部门数据
//		departmentMapper.insertSelective(new Department(null,"运维部"));
//		System.out.println(departmentMapper.selectByPrimaryKey(1));
//		插入员工数据
//		employeeMapper.insertSelective(new Employee(null,"zs","M","123@qq.com",1));
		
//		批量插入员工数据
//		EmployeeMapper mapper =  sqlSession.getMapper(EmployeeMapper.class);
//		
//		for(int i = 0;i < 1000;i ++) {
//			String uid = UUID.randomUUID().toString().substring(0, 5);
//			mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
//		}
//		
//		System.out.println("批量完成");
	}

}
