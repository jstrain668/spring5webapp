package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRespository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorRespository authorRespository;

    @RequestMapping("/authors")
    public String getBooks(Model model){

        model.addAttribute("authors",authorRespository.findAll());

        return "authors/list";
    }
}
