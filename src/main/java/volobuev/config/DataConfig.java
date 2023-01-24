package volobuev.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import volobuev.dto.GlossaryDto;
import volobuev.dto.MindMapDto;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;

@Configuration
@Data
public class DataConfig {
    private final ObjectMapper mapper = new ObjectMapper();
    private GlossaryDto terms;
    private MindMapDto termLinks;

    @SneakyThrows
    @PostConstruct
    public void initializeData() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        InputStream glossaryStream = classloader.getResourceAsStream("json/glossary.json");
        InputStream mindMapStream = classloader.getResourceAsStream("json/mind-map.json");

        terms = mapper.readValue(glossaryStream, GlossaryDto.class);
        termLinks = mapper.readValue(mindMapStream, MindMapDto.class);
    }
}
