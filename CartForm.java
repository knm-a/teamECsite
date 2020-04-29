package jp.co.internous.hope.model.form;


public class CartForm {
	//商品ID
	private int productId;
	//個数
	private int productCount;
	//ユーザーID
	private int userId;

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

	//getter,setter(userId)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}