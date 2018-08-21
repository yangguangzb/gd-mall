package com.gd.solrj;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJTest {
	
	@Test
	public void addDocument() throws Exception{
		String url = "http://101.132.158.84:8081/solr";
		//创建一个连接
		SolrServer solrServer = new HttpSolrServer(url);
		//创建一个文档对象
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id","test001");
		document.addField("item_title","测试商品2");
		document.addField("item_price",123);
		//把文档对象写入索引库
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	
	@Test
	public void deleteDocument() throws Exception{
		String url = "http://101.132.158.84:8081/solr";
		//创建一个连接
		SolrServer solrServer = new HttpSolrServer(url);
		//根据id删除
		//solrServer.deleteById("test001");
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
