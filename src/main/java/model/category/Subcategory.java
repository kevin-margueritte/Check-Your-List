package model.category;

public class Subcategory {

	protected String name;
	protected String shortDescription;
	protected String detailledDescription;
	protected Category category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailledDescription() {
		return detailledDescription;
	}
	public void setDetailledDescription(String detailledDescription) {
		this.detailledDescription = detailledDescription;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
