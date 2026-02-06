package projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.dto.TransacaoDTO;
import projeto_sistema_Bruno_Mano.projeto_sistema_Bruno_Mano.model.Transacao;

@Service
public class CallbackService {

    private final RestTemplate restTemplate;

    public CallbackService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void enviarCallback(String url, Transacao transacao) {
        try {
            HttpEntity<Transacao> request = new HttpEntity<>(transacao);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Callback enviado com sucesso!");
            } else {
                System.out.println("Erro ao enviar callback: " + response.getStatusCode());
            }
        } catch (HttpClientErrorException e) {
            System.out.println("Erro ao enviar callback: " + e.getMessage());
        }
    }
}
