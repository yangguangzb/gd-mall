package com.gd.search.service;

import com.gd.search.pojo.SearchResult;

public interface SearchService {
	
	public SearchResult search(String queryString, int page, int rows)throws Exception;
	
}
