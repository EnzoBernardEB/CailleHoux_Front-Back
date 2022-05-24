package fr.ecommerce.caillehoux.entity.product;


import javax.persistence.*;

@Entity
@Table(name = "table_order_product")
public class OrderProduct {

	@EmbeddedId
	private OrderProductId id;

	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private Order order;

	private int quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(OrderProductId id, Order order, Product product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

}
