package controller;

import dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private static final String EMAIL = "r.d2423.be23@chitkara.edu.in";

    @GetMapping("/health")
    public ApiResponse<Void> health() {
        return new ApiResponse<>(true, EMAIL, null);
    }
}