package jp.co.internous.hope.model.domain;

import java.sql.Timestamp;

import jp.co.internous.hope.model.form.CartForm;

public class TblCart {
	//ID
	private int id;
	//ユーザーID
	private int userId;
	//商品ID
	private int productId;
	//個数
	private int productCount;
	//登録日時
	private Timestamp createdAt;
	//更新日時
	private Timestamp updatedAt;
	
	public TblCart() {}
	
	public TblCart(CartForm f) {
		userId = f.getUserId();
		productId = f.getProductId();
		productCount = f.getProductCount();
	}

	//getter,setter(id)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	//getter,setter(userId)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//getter,setter(productId)
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//getter,setter(productCount)
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
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