
package ma.emsi.akodad.tp0akodad.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.Locale;

@Dependent
public class GenerateurReponse implements Serializable {

    private boolean roleSystemeAffiche = false;

    public String genererReponse(String question, String roleSysteme) {
        String resultat = "||";

        if (!this.roleSystemeAffiche && roleSysteme != null) {
            resultat += roleSysteme.toUpperCase(Locale.FRENCH) + "\n";
            this.roleSystemeAffiche = true;
        }

        String questionNormalisee = Normalizer
                .normalize(question.toLowerCase(Locale.FRENCH), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .trim();

        String reponse;

        if (questionNormalisee.contains("intelligence artificielle")
                || questionNormalisee.contains("c'est quoi l'ia")
                || questionNormalisee.contains("c quoi l'ia")) {
            reponse = "L'intelligence artificielle est un domaine informatique "
                    + "qui permet aux machines d'effectuer des tâches nécessitant "
                    + "habituellement l'intelligence humaine.";
        } else if (questionNormalisee.contains("machine learning")
                || questionNormalisee.contains("apprentissage automatique")) {
            reponse = "Le Machine Learning est une branche de l'intelligence "
                    + "artificielle qui permet aux machines d'apprendre à partir "
                    + "de données.";
        } else if (questionNormalisee.contains("deep learning")
                || questionNormalisee.contains("apprentissage profond")) {
            reponse = "Le Deep Learning est une branche du Machine Learning "
                    + "qui utilise des réseaux de neurones comportant plusieurs couches.";
        } else if (questionNormalisee.contains("java")) {
            reponse = "Java est un langage de programmation orienté objet "
                    + "utilisé pour développer différents types d'applications.";
        } else if (questionNormalisee.contains("definition")
                || questionNormalisee.contains("definir")
                || questionNormalisee.contains("c'est quoi")
                || questionNormalisee.contains("c quoi")
                || questionNormalisee.contains("qu'est-ce que")
                || questionNormalisee.contains("que signifie")) {
            reponse = "Je ne connais pas encore ce concept. Essaie de demander "
                    + "la définition de l'intelligence artificielle, du Machine "
                    + "Learning, du Deep Learning ou de Java.";
        } else {
            reponse = "Je peux expliquer certains concepts informatiques. "
                    + "Essaie : « C'est quoi l'intelligence artificielle ? »";
        }

        resultat += reponse + "||";
        return resultat;
    }
}
