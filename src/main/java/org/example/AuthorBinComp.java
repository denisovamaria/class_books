package org.example;

import java.util.Comparator;

public class AuthorBinComp implements Comparator<Books> {
    @Override
    public int compare(Books a, Books b) {
        return a.getNameOfAuthor().compareTo(b.getNameOfAuthor());
    }
}