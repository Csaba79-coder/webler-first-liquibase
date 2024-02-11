package hu.webler.weblerfirstliquibase.web;

import hu.webler.weblerfirstliquibase.entity.Writer;
import hu.webler.weblerfirstliquibase.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final WriterService writerService;

    @GetMapping("/")
    public String indexRenderWithWriters(Model model) {
        model.addAttribute("writers", writerService.findAllWriters());
        return "index";
    }
}
