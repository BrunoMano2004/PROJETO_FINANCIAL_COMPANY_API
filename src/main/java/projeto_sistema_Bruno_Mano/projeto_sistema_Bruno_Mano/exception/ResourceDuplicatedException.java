package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceDuplicatedException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ResourceDuplicatedException(String message) {
        super(message);
    }
}
