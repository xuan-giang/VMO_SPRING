package com.example.springsecurityexample.controller;

import com.cloudinary.utils.ObjectUtils;
import com.example.springsecurityexample.config.CloudinaryConfig;

import com.example.springsecurityexample.service.SendMailService;
import com.example.springsecurityexample.service.UserService;
import com.example.springsecurityexample.model.Book;
import com.example.springsecurityexample.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class BookController  implements Runnable{

    private String nameBook;

    @Autowired
    private BookService bookService;

    @Autowired
    private SendMailService sendMailService;

    @Autowired
    private CloudinaryConfig cloudinaryConfig;

    @Autowired
    private UserService userService;



    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Book> listBooks =bookService.getAllBook();
        model.addAttribute("listBooks", listBooks);
        scheduleTaskWithCronExpression();
        return "index";
    }

    @RequestMapping("/new")
    public String showNewBookPage(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/save")
    public RedirectView saveBook(@ModelAttribute("book") Book book, BindingResult result,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {


        /* Start upload image */
        try {
            Map uploadResult = cloudinaryConfig.upload(multipartFile.getBytes(),
                    ObjectUtils.asMap("resourcetype", "auto"));
            book.setImage(uploadResult.get("url").toString());
        }  catch (IOException e){
            e.printStackTrace();
        }
        /* End upload image */

        nameBook = book.getName();
        Book savedBook = bookService.save(book);


        run();
        return new RedirectView("/", true);
    }



    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_book");
        Book book = bookService.getBookById(id);
        mav.addObject("book", book);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }

    @Override
    public void run() {
        System.out.println("Đang tạo thông tin sách...");

        sleep(2000);

        System.out.println("Đã tạo thành công!");

        System.out.println("Đang kiểm tra thông tin tài khoản");

        System.out.println("Đang gửi mail xác nhận");

        sleep(2000);

        sendMailService.sendMailWithText("THÔNG BÁO TẠO MỚI SÁCH", "Bạn vừa thêm mới cuốn sách " + nameBook, "ngxuangiang2019@gmail.com");

        System.out.println("Hoàn tất các quá trình!");
    }

    private void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "30 1 * * * ?")
    public void scheduleTaskWithCronExpression() {
        System.out.println("\n\n\nSCANNING...");
        int amountErrorBook     = 0;
        int amountBookScanned   = 0;
        List<Book> bookList = bookService.getAllBook();

        for(int i = 0; i < bookList.size(); i++)
        {
            if(bookList.get(i).getPrice() < 300)
            {
                System.out.println("\n>>>>>Phát hiện cuốn " + bookList.get(i).getName() + " có giá " + bookList.get(i).getPrice() + " bất thường! <<<<<<<<<\n");
                amountErrorBook++;
                sleep(2000);
            }
            amountBookScanned++;
            System.out.println("Số sách đã quét: " + amountBookScanned);
            sleep(800);
        }

        System.out.println("\n\n\n================= KẾT THÚC KIỂM TRA ====================");
        System.out.println("----> Số sách đã quét: " + amountBookScanned);
        System.out.println("----> Số sách phát hiện bất thường: " + amountErrorBook);
        System.out.println("========================================================");

    }
}
