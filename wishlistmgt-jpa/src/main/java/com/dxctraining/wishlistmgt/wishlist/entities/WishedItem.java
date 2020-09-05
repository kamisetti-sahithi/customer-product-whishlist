package com.dxctraining.wishlistmgt.wishlist.entities;


import java.util.Objects;

import javax.persistence.*;

@Entity
public class WishedItem {

    @Id
    private String id;

    private int customerId;
    
    private String productId;
    
    public WishedItem() {

    }

    public WishedItem(int custId, String productId) {
         this.custId = custId;
         this.productId = productId;
    }

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WishedItem wishedItem = (WishedItem) obj;
        return Objects.equals(id, wishedItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
