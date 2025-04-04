package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityResponse {

    @Getter
    private Integer id;
    private String title;
    private boolean verified;

    @JsonProperty("important_numbers")
    private List<Integer> importantNumbers;

    private Addition addition;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Addition {
        @JsonProperty("additional_info")
        private String additionalInfo;

        @JsonProperty("additional_number")
        private Integer additionalNumber;
    }
}
