package volobuev.type;

import lombok.Data;

@Data
public class TermLink<T> {
    private T term_1;
    private T term_2;
}
