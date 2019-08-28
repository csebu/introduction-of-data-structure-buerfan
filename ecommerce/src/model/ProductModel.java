package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")

public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_description")
	private String productDescription;
	
	@Column(name = "product_image")
	private String productImage;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CategoryModel produCategory;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private SubcategoryModel productSubcategory;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescriptionString) {
		this.productDescription = productDescriptionString;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public CategoryModel getProduCategory() {
		return produCategory;
	}
	public void setProduCategory(CategoryModel produCategory) {
		this.produCategory = produCategory;
	}
	public SubcategoryModel getProductSubcategory() {
		return productSubcategory;
	}
	public void setProductSubcategory(SubcategoryModel productSubcategory) {
		this.productSubcategory = productSubcategory;
	}

}
