package ai.sangmado.urbanboot.urban.iptable.management.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class InvalidRequestParameterException extends ResponseStatusException {
    private String parameterName;
    private String validationResult;

    public InvalidRequestParameterException(String parameterName, String validationResult) {
        super(HttpStatus.BAD_REQUEST, String.format("Invalid parameter, [%s], %s.", parameterName, validationResult));
        setParameterName(parameterName);
        setValidationResult(validationResult);
    }
}
