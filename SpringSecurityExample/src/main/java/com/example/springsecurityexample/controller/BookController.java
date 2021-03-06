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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.sql.Timestamp;
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
       // scheduleTaskWithCronExpression();
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

    @GetMapping("/css/1")
    public String deletheBook() {

        return "145";
    }


    @Override
    public void run() {
        System.out.println("??ang t???o th??ng tin s??ch...");

        sleep(2000);

        System.out.println("???? t???o th??nh c??ng!");

        System.out.println("??ang ki???m tra th??ng tin t??i kho???n");

        System.out.println("??ang g???i mail x??c nh???n");

        sleep(2000);

        sendMailService.sendMailWithText("TH??NG B??O T???O M???I S??CH", "B???n v???a th??m m???i cu???n s??ch " + nameBook, "ngxuangiang2019@gmail.com");

        System.out.println("Ho??n t???t c??c qu?? tr??nh!");
    }

    private void sleep(long millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    @Scheduled(cron = "15 * * * * ?")
//    public void scheduleTaskWithCronExpression() {
//        System.out.println("\n\n\n"+printCurrentTime() + "SCANNING...");
//        int amountErrorBook     = 0;
//        int amountBookScanned   = 0;
//        List<Book> bookList = bookService.getAllBook();
//
//        for(int i = 0; i < bookList.size(); i++)
//        {
//            if(bookList.get(i).getPrice() < 300)
//            {
//                System.out.println("\n>>>>>Ph??t hi???n cu???n " + bookList.get(i).getName() + " c?? gi?? " + bookList.get(i).getPrice() + " b???t th?????ng! <<<<<<<<<\n");
//                amountErrorBook++;
//                sleep(2000);
//            }
//            amountBookScanned++;
//
//            System.out.println(printCurrentTime() + "S??? s??ch ???? qu??t: " + amountBookScanned);
//            sleep(800);
//        }
//
//        System.out.println("\n\n\n================= K???T TH??C KI???M TRA ====================");
//        System.out.println(printCurrentTime() + "----> S??? s??ch ???? qu??t: " + amountBookScanned);
//        System.out.println(printCurrentTime() + "----> S??? s??ch ph??t hi???n b???t th?????ng: " + amountErrorBook);
//        System.out.println("========================================================");
//
//    }

    private String printCurrentTime()
    {
        return "[" + String.valueOf(new Timestamp(System.currentTimeMillis())) + "]: \t";
    }
}
