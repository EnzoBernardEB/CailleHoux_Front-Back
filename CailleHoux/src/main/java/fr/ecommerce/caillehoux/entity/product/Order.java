package fr.ecommerce.caillehoux.entity.product;

import fr.ecommerce.caillehoux.entity.appUser.AppUser;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "table_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dateCreated;
	private String status;

	@ManyToOne
	private AppUser client;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id", insertable = false, updatable = false)
	private List<OrderProduct> orderProducts;

	public Order() {
		super();
	}

	public Order(Long id, LocalDate dateCreated, String status, AppUser client, List<OrderProduct> orderProducts) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.status = status;
		this.client = client;
		this.orderProducts = orderProducts;
	}

	public AppUser getClient() {
		return client;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", dateCreated=" + dateCreated + ", status=" + status + ", orderProducts="
		// + orderProducts + "]";
				+ "]";
	}

	public Double getTotalOrderPrice() {
		double sum = 0D;
		for (OrderProduct op : orderProducts) {
			sum += op.getTotalPrice();
		}
		return sum;
	}

	public int getNumberOfProducts() {
		return this.orderProducts.size();
	}

	public int getTotalNumberOfProducts() {
		int sum = 0;
		for (OrderProduct op : orderProducts) {
			sum += op.getQuantity();
		}
		return sum;
	}

	public OrderProduct addProduct(Product product, int quantity) {
		OrderProduct orderProduct = null;

		// On regarde si le produit est déjà dans la commande, dans ce cas on ajoute
		// seulement la quantité
		for (OrderProduct op : orderProducts) {
			if (op.getProduct().equals(product)) {
				orderProduct = op;
				orderProduct.setQuantity(op.getQuantity() + quantity);
				break;
			}
		}

		// Sinon on ajoute une nouvelle ligne de commande
		if (orderProduct == null) {
			OrderProductId orderProductId = new OrderProductId(product.getId(), id);
			
			orderProduct = new OrderProduct(orderProductId, this, product, quantity);
			orderProducts.add(orderProduct);
		}

		return orderProduct;
	}

}
