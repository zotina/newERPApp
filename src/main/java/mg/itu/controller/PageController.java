package mg.itu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/api")
public class PageController {

    
    @GetMapping("/dashboard")
    public String getDashboard(Model model, HttpSession session) {
        String accessToken = (String) session.getAttribute("access_token") ;
  
        if (accessToken == null) {
            model.addAttribute("error", "Please log in to access the dashboard");
            return "views/auth/login";
        } 

        try {
            return "views/pages/dashboard";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Error connecting to API");
            return "views/auth/login";
        }
    }
}