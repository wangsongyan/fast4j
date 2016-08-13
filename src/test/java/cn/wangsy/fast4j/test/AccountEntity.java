package cn.wangsy.fast4j.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import cn.wangsy.fast4j.util.AppUtil;

/**
 * @author wangsy
 * @date 创建时间：2016年8月13日 上午11:48:26
 * @version 1.0
 */
@ExcelTarget("accountEntity")
public class AccountEntity implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 主键 */
	private String id;
	/**  */
	@Excel(name = "年", orderNum = "1", needMerge = true)
	private String year;
	/**  */
	@Excel(name = "月", orderNum = "1", needMerge = true)
	private String month;
	/**  */
	@Excel(name = "日", orderNum = "1", needMerge = true)
	private String day;
	/**  */
	@Excel(name = "摘要", orderNum = "1", needMerge = true)
	private String summary;
	/**  */
	@Excel(name = "用途", orderNum = "1", needMerge = true)
	private String purpose;
	/**  */
	@Excel(name = "收入", orderNum = "1", needMerge = true)
	private String input;
	/**  */
	@Excel(name = "支出", orderNum = "1", needMerge = true)
	private String output;
	/**  */
	@Excel(name = "余额", orderNum = "1", needMerge = true)
	private String balance;
	/**  */
	@Excel(name = "经办人", orderNum = "1", needMerge = true)
	private String operator;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	@Override
	public String toString(){
		String date = null;
		try{
			Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.YEAR, Integer.parseInt(getYear()==null?"2016":getYear()));
			calendar.set(Calendar.MONTH, Integer.parseInt(getMonth())-1);
			calendar.set(Calendar.DATE, Integer.parseInt(getDay()));
			SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			date = mDateFormat.format(calendar.getTime());
		}catch(Exception exception){
		}
		
		return "insert into account(id,create_date,summary,purpose,input,output,balance,operator) values("
				+"'"+AppUtil.getUUID()+"',"
				+(date==null?"null":("'"+date+"'"))+","
				+(getSummary()==null?"null":("'"+getSummary()+"'"))+","
				+(getPurpose()==null?"null":("'"+getPurpose()+"'"))+","
				+(getInput()==null?"null":("'"+getInput()+"'"))+","
				+(getOutput()==null?"null":("'"+getOutput()+"'"))+","
				+(getBalance()==null?"null":("'"+getBalance()+"'"))+","
				+(getOperator()==null?"null":("'"+getOperator()+"'"))
				+")";
	}
	
}