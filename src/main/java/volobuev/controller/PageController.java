package volobuev.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import volobuev.config.DataConfig;
import volobuev.dto.GlossaryDto;
import volobuev.dto.MindMapDto;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PageController {
    private final DataConfig dataConfig;
    private final ObjectMapper mapper;

    @SneakyThrows
    @GetMapping("/")
    public String index(Model model) {
        GlossaryDto terms = dataConfig.getTerms();
        MindMapDto termLinks = dataConfig.getTermLinks();

        model.addAttribute("terms", mapper.writeValueAsString(terms));
        model.addAttribute("termLinks", mapper.writeValueAsString(termLinks));

        return "index";
    }
}
