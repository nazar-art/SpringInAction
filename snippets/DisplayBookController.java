package com.springbooks.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class DisplayBookController {
    private BookService bookService;

    @Inject
    public DisplayBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/displayBook.htm", method = RequestMethod.GET)
    public String showBook(@RequestParam("isbn") String isbn, Model model) {
        model.addAttribute(bookService.lookupBookByIsbn(isbn));
        return "bookDetail";
    }
}
