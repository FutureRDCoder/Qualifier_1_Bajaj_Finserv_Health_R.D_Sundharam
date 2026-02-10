package controller;

import dto.ApiResponse;
import dto.BfhlRequest;
import service.AiService;
import exception.BadRequestException;
import util.MathUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.stream.Stream;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    private static final String EMAIL = "r.d2423.be23@chitkara.edu.in";

    private final AiService aiService;

    public BfhlController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> process(@RequestBody BfhlRequest request) {

        long keysProvided = Stream.of(
                request.getFibonacci(),
                request.getPrime(),
                request.getLcm(),
                request.getHcf(),
                request.getAI()
        ).filter(Objects::nonNull).count();

        if (keysProvided != 1) {
            throw new BadRequestException("Exactly one input key must be provided");
        }

        Object data;

        if (request.getFibonacci() != null) {
            data = MathUtils.fibonacci(request.getFibonacci());
        } else if (request.getPrime() != null) {
            data = MathUtils.filterPrimes(request.getPrime());
        } else if (request.getLcm() != null) {
            data = MathUtils.lcm(request.getLcm());
        } else if (request.getHcf() != null) {
            data = MathUtils.hcf(request.getHcf());
        } else {
            data = aiService.askSingleWord(request.getAI());
        }

        return ResponseEntity.ok(
                new ApiResponse<>(true, EMAIL, data)
        );
    }
}