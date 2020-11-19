// IBookManager.aidl
package com.example.promoteproject;

// Declare any non-default types here with import statements
import com.example.promoteproject.aidltest.Book;
interface IBookManager {

    List<Book> getBookList();
    void addBook(in Book book);

}
