package cn.wangsy.fast4j.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.wangsy.fast4j.web.model.dao.customized.UserDao;
import cn.wangsy.fast4j.web.model.entity.gen.User;

/** 
 * 说明：
 * @author wangsy
 * @date 创建时间：2016年8月9日 下午3:56:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:*.xml")
public class DataSourceTest {

	@Resource
	private DataSource dataSource;
	
	@Resource
	private UserDao userDao;

	@org.junit.Test
	public void getUserById(){
		User user = userDao.getUserById("27db6cac190a410eb571dd386139e1a3");
		System.out.println(user.getUserName());
	}
	
	
	public void testDataSource() throws SQLException {
		Connection connection = dataSource.getConnection();
		// connection.getMetaData()

		String sql = "select * from user";
		Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery(sql);
		ResultSetMetaData m = rs.getMetaData();

		int columns = m.getColumnCount();
		// 显示列,表格的表头
		for (int i = 1; i <= columns; i++) {
			System.out.print(m.getColumnName(i));
			System.out.print("\t\t");
		}

		System.out.println();
		// 显示表格内容
		while (rs.next()) {
			for (int i = 1; i <= columns; i++) {
				System.out.print(rs.getString(i));
				System.out.print("\t\t");
			}
			System.out.println();
		}
		connection.close();
		
	}
	
}
