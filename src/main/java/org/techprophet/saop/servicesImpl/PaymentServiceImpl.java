package org.techprophet.saop.servicesImpl;

import org.springframework.stereotype.Service;
import org.techprophet.saop.services.PaymentService;

import static java.lang.System.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String processPayment(String userId, double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Montant invalide");
        }

        out.println("Traitement du paiement pour l'utilisateur : " + userId);

        return "Paiement de " + amount + " résussie.";
    }

}
