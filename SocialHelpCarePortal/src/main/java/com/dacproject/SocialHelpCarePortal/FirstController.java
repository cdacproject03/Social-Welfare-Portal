package com.dacproject.SocialHelpCarePortal;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dacproject.SocialHelpCarePortal.dao.UserDao;
import com.dacproject.SocialHelpCarePortal.model.User;





@Controller
public class FirstController{

	  @Autowired
	  private UserDao userDao;
	
    @RequestMapping({"/", "/home"})
    public String hello(Model model,HttpServletRequest request, @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	request.setAttribute("mode","MODE_HOME");
    	model.addAttribute("name", name);
        return "home";
    }
    
    @RequestMapping("/signup")
    public String signup(HttpServletRequest request)
    {
    	request.setAttribute("mode","MODE_REGISTER");
    	return "home";
    }
    
    @RequestMapping("/signin")
    public String signin()
    {
    	return "signin";
    }
    
	/*
	 * @GetMapping("/form") public String formGet() { return "register"; }
	 */
    
    @PostMapping("/form")
    public String formPost(User user, Model model) {
        userDao.save(user);
        return "signin";
    }
    
    @PostMapping("/login")
    public String login(User user, Model model) {
        model.addAttribute("user", user);
        User loginUser=userDao.retrieve(user);
        if(loginUser!=null)
        {
        	String role=loginUser.getType();
        	if(role.equals("Admin"))
        	{
        		return "admindashboard";
        	}
        	else if(role.equals("NEEDY"))
        	{
        		return "sw";
        	}
           	else if(role.equals("NGO"))
        	{
        		return "ngodashboard";
        	}
           	else if(role.equals("Volunteer"))
        	{
        		return "sw";
        	}
        	return "welcome";
        }
        return "signin";
    }
    
    @RequestMapping("/gotohome")
    public String gotoHome(HttpServletRequest request)
    {
    	request.setAttribute("mode","MODE_HOME");
    	return "home";
    }
    
    @RequestMapping("/chart")
    public String gotoChart()
    {
    	return "chart";
    }
    
    @RequestMapping("/admindashboard")
    public String adminDashboard()
    {
    	return "admindashboard";
    }
    
    @RequestMapping("/ngodashboard")
    public String ngoDashboard()
    {
    	return "ngodashboard";
    }
    
    @RequestMapping("/ngochart")
    public String ngoChart()
    {
    	return "ngochart";
    }
    
    @RequestMapping("/eventdetails")
    public String eventDetails()
    {
    	return "eventdetails";
    }
    
    
}
