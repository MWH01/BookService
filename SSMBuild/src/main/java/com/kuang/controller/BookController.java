package com.kuang.controller;

import com.kuang.pojo.Book;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller调service层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;
    //查询全部的书籍并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Book> list = bookService.queryAllBooks();
        model.addAttribute("list", list);
        return "allBook";
    }
    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }
    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Book book){
        System.out.println("addBook->" + book);
        bookService.addBook(book);
        return "redirect:/book/allBook";
    }
    //跳转到修改书籍页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePaper(int id, Model model){
        Book Qbook = bookService.queryBookById(id);
        model.addAttribute("Qbook", Qbook);
        return "updateBook";
    }
    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Book book){
        System.out.println("updateBook->" + book);
        bookService.updateBook(book);
        return "redirect:/book/allBook";
    }
    //删除书籍的请求
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    //查询书籍的请求
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model){
        List<Book> list = bookService.queryBookByName(queryBookName);
        if(list == bookService.queryAllBooks()){
            model.addAttribute("error", "未查到");
            return "allBook";
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
