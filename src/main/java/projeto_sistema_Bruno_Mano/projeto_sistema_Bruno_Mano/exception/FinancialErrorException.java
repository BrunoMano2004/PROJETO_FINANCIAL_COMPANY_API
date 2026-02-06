package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class FinancialErrorException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public FinancialErrorException(String message) {
        super(message);
    }
}
