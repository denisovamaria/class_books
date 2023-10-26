package org.example;

import java.util.Scanner;

public class Books {
    private String nameOfAuthor;
    private String nameOfBook;
    private int year;
    private int price;

    public Books(String nameOfAuthor, String nameOfBook, int year, int price) {
        this.nameOfAuthor = nameOfAuthor;
        this.nameOfBook = nameOfBook;
        this.year = year;
        this.price = price;
    }

    public Books() {
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void getInfo(Scanner in) {
        String str = in.nextLine();
        String[] lineArray = str.split(" ");
        this.nameOfAuthor = lineArray[0];
        this.nameOfBook = lineArray[1];
        this.year = Integer.parseInt(lineArray[2]);
        this.price = Integer.parseInt(lineArray[3]);
    }

    public void outInfo(){
        System.out.println(this.nameOfAuthor + " " + this.nameOfBook + " " + this.year + " " + this.price);
    }
}
