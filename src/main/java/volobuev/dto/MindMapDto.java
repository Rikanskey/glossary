package volobuev.dto;

import volobuev.type.TermLink;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MindMapDto {
    private List<TermLink<String>> termLinks;
}
