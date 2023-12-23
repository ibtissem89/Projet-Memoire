package com.BackendE.backendProject.requests;

public class ProductReq {

    private Integer idProduct;
    private String name;
    private  String prix;
    private String image;
    private String type;

    public ProductReq(Integer idProduct, String name, String prix, String image, String type) {
        this.idProduct = idProduct;
        this.name = name;
        this.prix = prix;
        this.image = image;
        this.type = type;
    }

    public ProductReq(String name, String prix, String image, String type) {
        this.name = name;
        this.prix = prix;
        this.image = image;
        this.type = type;
    }

    public ProductReq() {
    }

    @Override
    public String toString() {
        return "ProductReq{" +
                "id=" + idProduct +
                ", name='" + name + '\'' +
                ", prix='" + prix + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public void setType(String type) {
        this.type = type;
    }
}
