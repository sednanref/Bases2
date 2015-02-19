package classes;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private int ID;
	private String name;
	private Category superCategory;
	private Set<Category> subCategories = new HashSet<Category>();
	
	public Category(String name){
		this.name = name;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Category getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(Category superCategory) {
		this.superCategory = superCategory;
	}
	
	public Set<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(Set<Category> subCategories) {
		this.subCategories = subCategories;
	}
	
}
