package fun.goodgoodstudy.bestpractice.urbanboot.urbanmanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Getter
@Setter
public class BadRequestException extends ResponseStatusException {
    private String reason;

    public BadRequestException(String reason) {
        super(HttpStatus.BAD_REQUEST, String.format("Bad request, %s.", reason));
        setReason(reason);
    }
}
