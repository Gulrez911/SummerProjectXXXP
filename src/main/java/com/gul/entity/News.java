package com.gul.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
//@Where(clause = "isDeleted='false'")

public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sheadline;
	private String sdate;
	private String simage;
	private String url;
	private String mainheadline;
	private String maindate;
	private String mainImage;
	private String summary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSheadline() {
		return sheadline;
	}

	public void setSheadline(String sheadline) {
		this.sheadline = sheadline;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getSimage() {
		return simage;
	}

	public void setSimage(String simage) {
		this.simage = simage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMainheadline() {
		return mainheadline;
	}

	public void setMainheadline(String mainheadline) {
		this.mainheadline = mainheadline;
	}

	public String getMaindate() {
		return maindate;
	}

	public void setMaindate(String maindate) {
		this.maindate = maindate;
	}

	public String getMainImage() {
		return mainImage;
	}

	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", sheadline=" + sheadline + ", sdate=" + sdate + ", simage=" + simage + ", url="
				+ url + ", mainheadline=" + mainheadline + ", maindate=" + maindate + ", mainImage=" + mainImage
				+ ", summary=" + summary + "]";
	}

}
