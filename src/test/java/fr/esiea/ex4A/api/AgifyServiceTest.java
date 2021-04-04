package fr.esiea.ex4A.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

class AgifyServiceTest {



    AgifyClient agifyClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(AgifyClient.class);
    }

    AgifyClient mockAgifyClient = agifyClient();

    AgifyService agifyService = new AgifyService(mockAgifyClient);

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws IOException {
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur("mathew@mail.com", "Mathew", "mathew90210", "US", "M", "F");
        agifyService.addUser(infoUtilisateur);
        Assertions.assertThat(agifyService.APIRepository.userList.get("MathewUS")).isEqualTo(infoUtilisateur);
        Assertions.assertThat(agifyService.APIRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users() throws IOException {
        InfoUtilisateur infoUtilisateur1 = new InfoUtilisateur("kaaris@outlook.fr", "Clement", "Ornoir", "FR", "M", "M");
        InfoUtilisateur infoUtilisateur2 = new InfoUtilisateur("miguel@espana.es", "Miguel", "jalapeno", "ES", "M", "F");
        InfoUtilisateur infoUtilisateur3 = new InfoUtilisateur("marija@mail.ru", "Marija", "maridka", "RU", "F", "F");
        InfoUtilisateur infoUtilisateur4 = new InfoUtilisateur("mathew@mail.com", "Mathew", "mathew90210", "US", "M", "F");
        agifyService.addUser(infoUtilisateur1);
        agifyService.addUser(infoUtilisateur2);
        agifyService.addUser(infoUtilisateur3);
        agifyService.addUser(infoUtilisateur4);
        Assertions.assertThat(agifyService.APIRepository.userList.get("ClementFR")).isEqualTo(infoUtilisateur1);
        Assertions.assertThat(agifyService.APIRepository.userList.get("MiguelES")).isEqualTo(infoUtilisateur2);
        Assertions.assertThat(agifyService.APIRepository.userList.get("MarijaRU")).isEqualTo(infoUtilisateur3);
        Assertions.assertThat(agifyService.APIRepository.userList.get("MathewUS")).isEqualTo(infoUtilisateur4);
        Assertions.assertThat(agifyService.APIRepository.getNumberOfUsers()).isEqualTo(4);
    }
}
