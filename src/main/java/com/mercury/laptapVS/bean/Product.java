package com.mercury.laptapVS.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="MSI_PRODUCT")
public class Product {
	@Id
	@SequenceGenerator(name="msi_product_seq_gen",sequenceName="msi_product_seq",allocationSize=1)
	@GeneratedValue(generator="msi_product_seq_gen",strategy=GenerationType.AUTO)
	private int id;	
	@Column
	private String type;
	@Column
	private String brand;
	@Column
	private int views;
	@Column
	private String name;

	@Column
	private String image;
	@Column
	private String source;
	@Column
	private int price;
	@Transient
	private Rate rate;
	
	@Column
	private String processor;
	@Column
	private String operating_system;
	@Column
	private String graphics;
	@Column
	private String memory;
	@Column
	private String storage;
	@Column
	private String display;
	@Column
	private String camera;
	
	public Product() {
		super();	
		}

	

	public Product(int id, String type, String brand, int views, String name, String image, String source, int price,
			Rate rate, String processor, String operating_system, String graphics, String memory, String storage,
			String display, String camera) {
		super();
		this.id = id;
		this.type = type;
		this.brand = brand;
		this.views = views;
		this.name = name;
		this.image = image;
		this.source = source;
		this.price = price;
		this.rate = rate;
		this.processor = processor;
		this.operating_system = operating_system;
		this.graphics = graphics;
		this.memory = memory;
		this.storage = storage;
		this.display = display;
		this.camera = camera;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getOperating_system() {
		return operating_system;
	}
	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}
	public String getGraphics() {
		return graphics;
	}
	public void setGraphics(String graphics) {
		this.graphics = graphics;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", type=" + type + ", brand=" + brand + ", views=" + views + ", name=" + name
				+ ", image=" + image + ", source=" + source + ", price=" + price + ", rate=" + rate + ", processor="
				+ processor + ", operating_system=" + operating_system + ", graphics=" + graphics + ", memory=" + memory
				+ ", storage=" + storage + ", display=" + display + ", camera=" + camera + "]";
	}

	

}
