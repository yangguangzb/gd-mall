package com.gd.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.gd.search.pojo.SearchResult;

public interface SearchDao {
	
	SearchResult search(SolrQuery query) throws Exception;
	
}
