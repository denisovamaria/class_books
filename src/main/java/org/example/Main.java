package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Main {

    public static ArrayList<Books> getArrayOfBook(ArrayList<Books> a, String author) {
        Comparator bookComparator = new AuthorBinComp();
        Collections.sort(a, bookComparator);
        ArrayList<Books> b = new ArrayList<>();
        int index = Collections.binarySearch(a, new Books(author, null, 0, 0), bookComparator);
        if (index < 0) {
            System.out.println("No such authors");
            return b;
        } else {
            b.add(a.get(index));
        }
        for (int i = index + 1; i < a.size(); i++) {
            if (a.get(i).getNameOfAuthor().equals(author))
                b.add(a.get(i));
        }
        return b;
    }

    public static void getBooks(ArrayList<Books> a, String author) {
        System.out.println("Books of " + author + " :");
        ArrayList<Books> b = getArrayOfBook(a, author);
        for (int i = 0; i < b.size(); i++) {
            b.get(i).outInfo();
        }
        System.out.println();
    }


    public static ArrayList<Books> getJavaBook(ArrayList<Books> a) {
        int f = 0;
        ArrayList<Books> b = new ArrayList<>();
        for (Books book : a) {
            int index = book.getNameOfBook().indexOf("Java");
            if (index < 0) {
                f = 1;
                continue;
            } else {
                b.add(book);
            }
        }
        if (f == 0)
            System.out.println("No books about Java");
        return b;
    }

    public static void Java(ArrayList <Books> a){
        System.out.println("Books about Java:");
        ArrayList<Books> b = getJavaBook(a);
        for (int i = 0; i < b.size(); i++) {
            b.get(i).outInfo();
        }
        System.out.println();
    }

    public static void json(ArrayList<Books> a) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File("output.json"), a);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        ArrayList<Books> books = new ArrayList<>();
        Scanner in;
        try {
            in = new Scanner(new File("books.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (in.hasNextLine()) {
            Books book = new Books();
            book.getInfo(in);
            books.add(book);
        }

        Comparator bookComparator = new BooksComp();
        Collections.sort(books, bookComparator);

        for (Books book : books) {
            book.outInfo();
        }

        System.out.println();
        System.out.println("Enter author");
        Scanner in1 = new Scanner(System.in);
        String author = in1.nextLine();
        getBooks(books, author);

        json(books);
        Java(books);
    }
}