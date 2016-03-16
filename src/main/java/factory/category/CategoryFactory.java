package factory.category;

import model.category.Category;
import model.category.JDBC.CategoryJDBC;

public class CategoryFactory extends AbstractCategoryFactory {

	@Override
	public Category createCategory(String pseudo, String shortDescription, String detailedDescription) {
		return new CategoryJDBC(pseudo, shortDescription, detailedDescription);
	}

	@Override
	public Category createCategory(String pseudo) {
		return new CategoryJDBC(pseudo);
	}

}
