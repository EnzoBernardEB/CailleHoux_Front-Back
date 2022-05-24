package fr.ecommerce.caillehoux.entity.product;


import javax.persistence.*;

@Entity
@Table(name = "table_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String picture;
	private Long quantity;

	public Product() {

	}

	public Product(Long id, String name, String description, Double price, String picture, Long quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.picture = picture;
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getPicture() {
		return picture;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", picture=" + picture + "]";
	}

}
