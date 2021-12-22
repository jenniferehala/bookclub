package com.codingdojo.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @Autowired
    private BookService bookServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
//  ==================Register & Login==================  //
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result,
    		Model model, HttpSession session) {
        userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/dashboard";
    }
    
//  ==================DASHBOARD==================  //
    
    @RequestMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
    	if(session.getAttribute("user_id") != null) {
    		Long user_id = (Long) session.getAttribute("user_id");
    		model.addAttribute("user", userServ.oneUser(user_id));
    		
    		List<Book> book = bookServ.allBooks();
    		model.addAttribute("books", book);
    		
    		return "dashboard.jsp";
    		} else {
    			return "redirect:/"; }
    
}
    
    
    
//  ==================NEW BOOK==================  //
    
    @RequestMapping("/books/new")
    public String  newBook(HttpSession session, Model model) {
    	if (session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	Long user_id = (Long) session.getAttribute("user_id");
    	
		model.addAttribute("user", userServ.oneUser(user_id));
		model.addAttribute("book", new Book());
    	return "newBook.jsp";
    }
    
    @PostMapping("/newbook")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
    	if(result.hasErrors()) {
            model.addAttribute("newBook", new Book());
            return "newBook.jsp";
        }
    	
    	else {
    		
    		bookServ.createBook(book);
    		return "redirect:/dashboard";
    	}
    }
    
//  ==================SHOW BOOK==================  //
    
    @RequestMapping("/books/show/{id}")
    public String show(@PathVariable("id") Long id, Model model,
    		HttpSession session, 
    		RedirectAttributes redirectAttributes) {
    	if (session.getAttribute("user_id") == null) {
    		redirectAttributes.addFlashAttribute("error", "Only those logged in can view book.");
    		return "redirect:/";
    		
    	}
    	Long user_id = (Long) session.getAttribute("user_id");
    	
		model.addAttribute("user", userServ.oneUser(user_id));
    	model.addAttribute("book", bookServ.getBook(id));

        return "showpage.jsp";
    }
    
    
    
    
//    ==================UPDATE BOOK==================  //
    @RequestMapping("/book/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
    	Long user_id = (Long) session.getAttribute("user_id");
    	model.addAttribute("user", userServ.oneUser(user_id));
    	Book book = bookServ.getBook(id);
    	model.addAttribute("book", book);
		
    	return "editpage.jsp";
    }
    

    @PutMapping("/book/{id}/update")
    public String update(@PathVariable("id")Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		return "editpage.jsp";
    	} else {
    		
    		
    		bookServ.createBook(book);
    		return "redirect:/dashboard";
    	}
    }
    
    
//    ====================DELETE BOOK================= ///
    @RequestMapping("/delete/{id}") 
    	public String delete(@PathVariable("id") Long id, HttpSession session, Model model) {
    		if(session.getAttribute("user_id") != null) {
        		Long user_id = (Long) session.getAttribute("user_id");
        		model.addAttribute("user", userServ.oneUser(user_id));
    	}
    	return "redirect:/dashboard";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    	
    }
    
}
















