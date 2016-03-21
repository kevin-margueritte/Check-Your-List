package model.category;

import java.util.ArrayList;
import java.util.List;

public class Category {
	protected String name;
	protected String shortDescription;
	protected String detailedDescription;
	
	//protected List subcategories = new ArrayList();
	
	public Category(String name) {
		this.name= name;
	}
	
	public Category(String name, String shortDescription, String detailedDescription) {
		this.name= name;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	public String getDetailedDescription() {
		return this.detailedDescription;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public void setShortDescription(String shortDescription) {
	    this.shortDescription = shortDescription;
	}
	
	public void setDetailedDescription(String detailedDescription) {
	    this.detailedDescription = detailedDescription;
	}
	
}
