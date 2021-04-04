package fr.esiea.ex4A.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InfoUtilisateurTest {

    @ParameterizedTest
    @CsvSource({
        "Louis, Louis",
        "Sofiane, Sofiane",
        "Franck, Franck"
    })
    void creating_a_new_user_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur("",wantedName,"","","","");
        Assertions.assertThat(infoUtilisateur.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "a@a.com, a@a.com",
        "c@c.pr, c@c.pr",
        "z@gmail.tn, z@gmail.tn"
    })
    void creating_a_new_user_with_an_email_should_give_the_same_email(String wantedValue, String expectedValue){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur(wantedValue, "test", "","","","");
        Assertions.assertThat(infoUtilisateur.getEmail()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "joseph, joseph",
        "Rosita, Rosita"
    })
    void creating_a_new_user_with_a_count_should_give_the_same_count(String wantedValue, String expectedValue){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur("", "test", wantedValue,"","","");
        Assertions.assertThat(infoUtilisateur.getTwitter()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "TN, TN",
        "FR, FR",
        "IT, IT"
    })
    void creating_a_new_user_with_a_country_should_give_the_same_country(String wantedValue, String expectedValue){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur(wantedValue, "test", "",wantedValue,"","");
        Assertions.assertThat(infoUtilisateur.getCountry()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "F, F",
        "M, M"
    })
    void creating_a_new_user_with_a_sex_should_give_the_same(String wantedValue, String expectedValue){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur(wantedValue, "test", "","",wantedValue,"");
        Assertions.assertThat(infoUtilisateur.getSex()).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource({
        "M, M",
        "F, F"
    })
    void creating_a_new_user_with_a_sexpref_should_give_the_same(String wantedValue, String expectedValue){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur("wantedValue", "test", "","","",wantedValue);
        Assertions.assertThat(infoUtilisateur.getSexPref()).isEqualTo(expectedValue);
    }
}
