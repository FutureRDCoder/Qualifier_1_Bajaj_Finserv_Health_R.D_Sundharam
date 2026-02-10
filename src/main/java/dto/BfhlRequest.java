package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class BfhlRequest {

    private Integer fibonacci;

    private List<Integer> prime;

    private List<Integer> lcm;

    private List<Integer> hcf;

    private String AI;
}