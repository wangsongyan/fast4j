package cn.wangsy.fast4j.test;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;










import org.apache.commons.lang.StringUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;

import com.alibaba.fastjson.JSON;

/** 
 * @author wangsy
 * @date 创建时间：2016年8月13日 上午11:47:00
 * @version 1.0
 */
public class EasypoiTest {
	
	@org.junit.Test
	public void importTest() throws SQLException, ClassNotFoundException{
		ImportParams params = new ImportParams();
	    params.setTitleRows(2);
	    params.setHeadRows(1);
	    params.setKeyIndex(null);
	    params.setStartSheetIndex(1);
	    params.setSheetNum(1);
	    params.setNeedSave(true);
	    long start = new Date().getTime();
	    List<AccountEntity> list = ExcelImportUtil.importExcel(new File("F:\\杂乱无章\\史艳娇\\账本.xlsx"), AccountEntity.class, params);
	    //System.out.println(list.toString());
	    //System.out.println(JSON.toJSON(list));
	    
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
	    Statement statement = connection.createStatement();
	    
	    System.out.println("count:"+list.size());
	    for(AccountEntity entity:list){
	    	if(StringUtils.isNotBlank(entity.getBalance())){
	    		Double f = Double.parseDouble(entity.getBalance());
	    		BigDecimal b = new BigDecimal(f);  
	    		double f1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	    		entity.setBalance(String.valueOf(f1));
	    	}
	    	System.out.println(entity.toString());
	    	statement.execute(entity.toString());
	    }
	    statement.close();
	    connection.close();
	}
	
}
