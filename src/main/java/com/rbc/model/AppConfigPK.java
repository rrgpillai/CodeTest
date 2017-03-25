package com.rbc.model;

import java.io.Serializable;

public class AppConfigPK implements Serializable{
	
	private int appCode;
	private String version;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppConfigPK() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	public int getAppCode() {
		return appCode;
	}

	public void setAppCode(int appCode) {
		this.appCode = appCode;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	


}
