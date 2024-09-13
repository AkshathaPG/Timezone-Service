package com.gts.timezone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="GTS_TIMEZONES")
public class GtsTimezone {
	
	@Id
	@Column(name="gts_timezone_id")
	@JsonProperty("gts_timezone_id")
	private Integer gts_timezone_id;
	
	@Column(name="gts_timezone_name")
	@JsonProperty("gts_timezone_name")
	private String gts_timezone_name;
	
	@Column(name="gts_timezone_description")
	@JsonProperty("gts_timezone_description")
	private String gts_timezone_description;
	
	@Column(name="gts_timezone_status" )
	@JsonProperty("gts_timezone_status")
	private boolean gts_timezone_status;
	
	public GtsTimezone() {
		super();
	}
	
	public GtsTimezone(Integer gts_timezone_id, String gts_timezone_name, String gts_timezone_description,
			boolean gts_timezone_status) {
		super();
		this.gts_timezone_id = gts_timezone_id;
		this.gts_timezone_name = gts_timezone_name;
		this.gts_timezone_description = gts_timezone_description;
		this.gts_timezone_status = gts_timezone_status;
	}

	public Integer getgts_timezone_id() {
		System.out.println("getting timezone id");
		return gts_timezone_id;
	}

	public void setgts_timezone_id(Integer gts_timezone_id) {
		System.out.println("setting timezone id");
		this.gts_timezone_id = gts_timezone_id;
	}

	public String getgts_timezone_name() {
		System.out.println("getting timezone");
		return gts_timezone_name;
	}

	public void setgts_timezone_name(String gts_timezone_name) {
		System.out.println("timezone is getting set");
		this.gts_timezone_name = gts_timezone_name;
	}

	public String getgts_timezone_description() {
		return gts_timezone_description;
	}

	public void setgts_timezone_description(String gts_timezone_description) {
		this.gts_timezone_description = gts_timezone_description;
	}

	public boolean isGts_timezone_status() {
		return gts_timezone_status;
	}

	public void setgts_timezone_status(boolean gts_timezone_status) {
		this.gts_timezone_status = gts_timezone_status;
	}

	
	
	
	
		
}
