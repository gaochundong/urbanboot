package ai.sangmado.urbanboot.urban.traffic.management.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class InternalServerErrorException extends ResponseStatusException {
    private String errorMessage;

    public InternalServerErrorException(String errorMessage) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, String.format("Internal server error, %s.", errorMessage));
        setErrorMessage(errorMessage);
    }
}