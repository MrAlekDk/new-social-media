package com.example.demo.controllers;

import com.example.demo.models.Post;
import com.example.demo.services.PostManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class SocialMediaController {

    private PostManager postManager = new PostManager();

    // Showing how to create a form using thymeleaf
    @GetMapping(value = "/dashboard")

    public String renderForm(Model model) {
        model.addAttribute("posts", postManager.getPublicPosts());
        return "form.html";
    }

    @PostMapping(value = "/submit")
    public String createPost(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("date") String date, @RequestParam("public-or-private") String status) {
        postManager.createPost(title, content, date, status);
        return "redirect:/dashboard";
    }


    @GetMapping(value = "/list")
    @ResponseBody
    public ArrayList renderList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(list.toString());
        // This list gets returned as json!
        return list;
    }
}
