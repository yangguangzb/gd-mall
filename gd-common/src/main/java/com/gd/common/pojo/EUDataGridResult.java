package com.gd.common.pojo;
import java.util.List;
/**
 * EasyUI的json数据格式
 * @description
 * @author zhangbiao
 * @time 2018-6-18 下午4:16:00
 */
public class EUDataGridResult {
	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
