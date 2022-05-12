package com.example.mylibrary;

public class Book {

    private String name;
    private String author;
    private int id;
    private int pgs;
    private String shortDesc;
    private String longDesc;
    private String imageUrl;
    private boolean isExpanded;

    public Book(String name, String author, int id, int pgs, String shortDesc, String longDesc, String imageUrl) {
        this.name = name;
        this.author = author;
        this.id = id;
        this.pgs = pgs;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.imageUrl = imageUrl;
        isExpanded = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPgs() {
        return pgs;
    }

    public void setPgs(int pgs) {
        this.pgs = pgs;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", id=" + id +
                ", pgs=" + pgs +
                ", shortDesc='" + shortDesc + '\'' +
                ", longDesc='" + longDesc + '\'' +
                '}';
    }
}
