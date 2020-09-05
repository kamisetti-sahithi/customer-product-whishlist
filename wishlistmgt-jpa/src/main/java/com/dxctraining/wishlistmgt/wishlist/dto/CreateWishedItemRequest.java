package com.dxctraining.wishlistmgt.wishlist.dto;

public class CreateWishedItemRequest {
	
	private int custId;

    private String productId;
    
    public CreateWishedItemRequest() {
    	
    }
    
    public CreateWishedItemRequest(int custId, String productId) {
    	this.custId = custId;
    	this.productId = productId;
    }

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
