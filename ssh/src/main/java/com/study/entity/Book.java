package com.study.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Authorz; sloth
 * @Description:
 * @Data:Create in 10:22 2019/7/2
 * @Modificd By;
 */
@Entity
public class Book  implements Serializable {

    private static final long serialVersionUID = 2344373290139757047L;
    private String id;
    private String picture;
    private String name;
    private String author;
    private String number;
    private String place;
    private String price;

    @Id
    @Column(name = "id", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 30)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 30)
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "number", nullable = true, length = 30)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Basic
    @Column(name = "place", nullable = true, length = 30)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Basic
    @Column(name = "price", nullable = true, length = 30)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) &&
                Objects.equals(picture, book.picture) &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(number, book.number) &&
                Objects.equals(place, book.place) &&
                Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, picture, name, author, number, place, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", picture='" + picture + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", number='" + number + '\'' +
                ", place='" + place + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
