package jp.co.internous.hope.model.domain.dto;

import java.sql.Timestamp;

public class CartDto {
	//tbl_cart.id(カートID、チェックボックスの値に設定)
	private int id;
	//mst_product.image_full_path(商品画像)
	private String imageFullPath;
	//mst_product.product_name(商品名)
	private String productName;
	//mst_product.price(価格)
	private int price;
	//tbl_cart.product_count(個数)
	private int productCount;
	//tbl_cart.product_count,mst_product.price(小計(2つの積))
	private int subtotal;
	//tbl_cart.created_at(登録日時)
	private Timestamp createdAt;
	//tbl_cart.updated_at(更新日時)
	private Timestamp updatedAt;

	//getter,setter(id)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//getter,setter(imageFullPath)
	public String getImageFullPath() {
		return imageFullPath;
	}

	public void setImageFullPath(String imageFullPath) {
		this.imageFullPath = imageFullPath;
	}

	//getter,setter(productName)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	//getter,setter(price)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	//getter,setter(productCount)
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	//getter,setter(total)
	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}

	//getter,setter(createdAt)
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	//getter,setter(updatedAt)
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}