package org.techprophet.saop.aops;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

@Aspect
@Component
public class PaymentAspect {

    //Pointcut pour cibler la methode processPayment
    @Pointcut("execution(* org.techprophet.saop.services.PaymentService.processPayment(..))")
    public void processPaymentPointcut() {
    }

    @Before("processPaymentPointcut()")
    public void loadBefore() {
        out.println("Avant le traitement du paiement.");
    }

    @After("processPaymentPointcut()")
    public void logAfter() {
        out.println("Après le traitement du paiement.");
    }

    @AfterReturning(value = "processPaymentPointcut()", returning = "result")
    public void loadAfterReturning(Object result) {
        out.println("Retour réussi : " + result);
    }

    @Around("processPaymentPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        out.println("Avant Around : Préparation pour exécuter " + joinPoint.getSignature().getName());

        Object result;
        try {
            result = joinPoint.proceed(); // Execution de la methode cible
            out.println("Après Around : Méthode exécutée avec succès.");
        } catch (Exception exception) {
            err.println("Après Around : Exception interceptée et interrompue.");
            throw exception;
        }

        return result;
    }

    @AfterThrowing(value = "processPaymentPointcut()", throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        err.println("Exception capturée : " + exception.getMessage());
    }

}
