/**
 * 
 */
package org.ojqa.domain.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ybak
 * 
 */
public class Category {
    private Long id; // orm
    private String name;
    private String image;
    private String description;
    private String classCode;

    private Category parentCategory;
    private Set<Product> products = new HashSet<Product>();
    private Set<Category> childCategory = new HashSet<Category>();

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        this.id = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        this.name = pName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String pImage) {
        this.image = pImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        this.description = pDescription;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String pClassCode) {
        this.classCode = pClassCode;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category pParentCategory) {
        this.parentCategory = pParentCategory;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> pProducts) {
        this.products = pProducts;
    }

    public Set<Category> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Set<Category> pChildCategory) {
        this.childCategory = pChildCategory;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", classCode=" + classCode + ", description=" + description
                + "]";
    }
}
