/**
 * 
 */
package org.ojqa.domain.pojo;

import java.util.Date;

/**
 * @author ybak
 * 
 */
public class Product {
    private Long id; // orm
    private String name;
    private String serialNumber;
    private String unit;
    private Integer quantity;
    private String description;
    private Category category;
    private String image;
    private Date createTime;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String pSerialNumber) {
        this.serialNumber = pSerialNumber;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category pCategory) {
        this.category = pCategory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer pQuantity) {
        this.quantity = pQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String pUnit) {
        this.unit = pUnit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date pCreateTime) {
        this.createTime = pCreateTime;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", unit=" + unit + ", serialNumber=" + serialNumber
                + ", quantity=" + quantity + ", category=" + category + ", description=" + description
                + ", createTime=" + createTime + ", image=" + image + "]";
    }
}
