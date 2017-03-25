package com.rbc.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;



@Entity
@IdClass(value=AppConfigPK.class)
public class AppConfig {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public int getAppCode() {
		return appCode;
	}
	public void setAppCode(int appCode) {
		this.appCode = appCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdatedDate() {
		return sdf.format(updatedDate);
	}
	public void setUpdatedDate(String updatedDate) throws ParseException {
		this.updatedDate = sdf.parse(updatedDate);
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAppOwner() {
		return appOwner;
	}
	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}
	
	@Id
	private int appCode;
	public AppConfig(int appCode, String version, String description, String appOwner, String updatedDate) throws ParseException {
		super();
		this.appCode = appCode;
		this.version = version;
		this.description = description;
		this.appOwner = appOwner;
		this.updatedDate = sdf.parse(updatedDate);
	}
	@Id
	private String version;
	private String description;
	private String appOwner;
	private Date updatedDate;

	public AppConfig() {
		super();
		// TODO Auto-generated constructor stub
	}
}
