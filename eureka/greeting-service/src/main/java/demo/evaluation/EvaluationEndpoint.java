package demo.evaluation;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EvaluationEndpoint {

    @PostMapping("/greeting")
    public ResponseEntity<DummeRequest> greetingSubmit(@Valid @RequestBody DummeRequest request) {
//        return "result";
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
