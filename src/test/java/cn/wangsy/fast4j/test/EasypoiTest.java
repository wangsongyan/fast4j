package cn.wangsy.fast4j.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
















import javax.json.Json;

import org.apache.commons.io.IOUtils;
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
	public void importTest() throws SQLException, ClassNotFoundException, IOException{
		ImportParams params = new ImportParams();
	    params.setTitleRows(2);
	    params.setHeadRows(1);
	    params.setKeyIndex(null);
	    params.setStartSheetIndex(3);
	    params.setSheetNum(1);
	    params.setNeedSave(true);
	    long start = new Date().getTime();
	    List<AccountEntity> list = ExcelImportUtil.importExcel(new File("C:\\Users\\songy\\Downloads\\账本.xlsx"), AccountEntity.class, params);
	    //System.out.println(list.toString());
	    //System.out.println(JSON.toJSON(list));
	    
	   // Class.forName("com.mysql.jdbc.Driver");
	   // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet?useUnicode=true&characterEncoding=utf-8", "root", "mysql");
	   // Statement statement = connection.createStatement();
	    
	    List<Bill> bills = new ArrayList<Bill>();
	    
	    //System.out.println("count:"+list.size());
	    for(AccountEntity entity:list){
	    	if(StringUtils.isNotBlank(entity.getBalance())){
	    		Double f = Double.parseDouble(entity.getBalance());
	    		BigDecimal b = new BigDecimal(f);  
	    		double f1 = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
	    		entity.setBalance(String.valueOf(f1));
	    	}
	    	//System.out.println(entity.toString());
	    	//statement.execute(entity.toString());
	    	
	    	
	    	Bill bill = new Bill();
	    	bill.setOperator(entity.getOperator());
	    	bill.setPurpose(entity.getPurpose());
	    	bill.setSummary(entity.getSummary());
			if(StringUtils.isNotBlank(entity.getInput())){
				bill.setValue(entity.getInput());
				bill.setFlag("0");
	    	}else if(StringUtils.isNotBlank(entity.getOutput())){
	    		bill.setValue(entity.getOutput());
		    	bill.setFlag("1");
	    	}
	    	bill.setBalance(entity.getBalance());
	    	
	    	try{
				Calendar calendar = Calendar.getInstance();
				calendar.clear();
				calendar.set(Calendar.YEAR, Integer.parseInt(entity.getYear()==null?"2016":entity.getYear()));
				calendar.set(Calendar.MONTH, Integer.parseInt(entity.getMonth())-1);
				calendar.set(Calendar.DATE, Integer.parseInt(entity.getDay()));
				//SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//Date date = mDateFormat.format(calendar.getTime());
				bill.setCreateDate(calendar.getTime());
			}catch(Exception exception){
			}
	    	
	    	bills.add(bill);
	    }
	    System.out.println(JSON.toJSON(bills));
	    String pathString = "C:/Users/songy/Desktop/wsy-credit";
	    File file = new File(pathString);
	    if(!file.exists()){
	    	file.createNewFile();
	    }
	    FileOutputStream output = new FileOutputStream(file);
	    IOUtils.write(JSON.toJSON(bills).toString(), output,"UTF-8");
	    //statement.close();
	   // connection.close();
	}
	
}
