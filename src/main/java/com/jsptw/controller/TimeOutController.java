package com.jsptw.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class TimeOutController {

//    @GetMapping(value = "/menu")
//    public ModelAndView menu(){
//        ModelAndView model = new ModelAndView();
//        model.addObject("title", "权限管理");
//        model.setViewName("permission/menu");
//        return model;
//    }
	@GetMapping(value = "/timeout")
    public String sessionTimeout(HttpServletRequest request,HttpServletResponse response) throws IOException {  
		 String ajaxHeader = request.getHeader("X-Requested-With");  
         boolean isAjax = "XMLHttpRequest".equals(ajaxHeader);  
         if (isAjax) {  
             return "invalidSession";  
         } else {  
             try {  
                 response.sendRedirect("login");  
             } catch (IOException e) {  
                 // TODO Auto-generated catch block  
                 e.printStackTrace();  
             }  
         }  
     return "";  
 }  
}
