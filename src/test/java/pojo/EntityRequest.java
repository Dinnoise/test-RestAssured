package pojo;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class EntityRequest {
    @Builder.Default
    private Addition addition = Addition.builder().build();
    private List<Integer> important_numbers;
    @Builder.Default
    private String title = "Заголовок сущности";
    @Builder.Default
    private boolean verified = true;

    @Data
    @Builder
    public static class Addition {
        @Builder.Default
        private String additional_info = "Дополнительные сведения";
        private Integer additional_number;
    }
}
