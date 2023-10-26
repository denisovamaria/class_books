package org.example;

import java.util.Comparator;

public class BooksComp implements Comparator<Books> {
    @Override
    public int compare(Books a, Books b) {
        if (!a.getNameOfAuthor().equals(b.getNameOfAuthor())) {
            return a.getNameOfAuthor().compareTo(b.getNameOfAuthor());
        } else
            return a.getNameOfBook().compareTo((b.getNameOfBook()));
    }
}


