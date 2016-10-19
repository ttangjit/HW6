package io.spring.cloud.samples.commerceitem.ui.services.commerceservices;

public class Commerce {
    private Long id;
    private String name;
	private String description;
	private String category;
	//private float price;

    public Commerce() {
    }

    public Commerce(Long id, String name,String description,String category) {
        this.id = id;
        this.name = name;
	this.description = description;
	this.category = category;
	//this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

	/*public float getPrice(){
	
	return price;
}

	public void setPrice(float price){
	this.price = price;
}*/
}
