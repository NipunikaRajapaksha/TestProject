package com.hrapp.datatable;

import com.hrapp.datareader.ConfigPropertyReader;

public class ConfigData {
	static ConfigPropertyReader _config = new ConfigPropertyReader();
	
		public static final String baseURL = _config.getBaseUrl();

}
