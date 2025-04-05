package pojo;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class EntityRequest {
    private Addition addition;
    private List<Integer> important_numbers;
    private String title;
    private boolean verified;

    @Data
    @Builder
    public static class Addition {
        private String additional_info;
        private Integer additional_number;
    }
}
