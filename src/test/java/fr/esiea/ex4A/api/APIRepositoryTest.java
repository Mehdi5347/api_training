package fr.esiea.ex4A.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



class APIRepositoryTest {
    private final APIRepository APIRepository = new APIRepository();

    @Test
    void having_no_users_should_return_no_users(){
        Assertions.assertThat(APIRepository.getNumberOfUsers()).isEqualTo(0);
    }

    @Test
    void adding_a_user_to_repository_increments_number_of_users(){
        InfoUtilisateur infoUtilisateur = new InfoUtilisateur("test", "test", "test", "test", "test", "test");
        AgifyUser agifyUser = new AgifyUser("test", 50, 500, "US");
        APIRepository.addNewUser(infoUtilisateur, agifyUser);
        Assertions.assertThat(APIRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users(){
        InfoUtilisateur userData1 = new InfoUtilisateur("t1", "te1", "tes1", "test1", "test1", "test1");
        InfoUtilisateur userData2 = new InfoUtilisateur("t2", "te2", "tes2", "test2", "test2", "test2");
        InfoUtilisateur userData3 = new InfoUtilisateur("t3", "te3", "tes3", "test3", "test3", "test3");
        InfoUtilisateur userData4 = new InfoUtilisateur("t4", "te4", "tes4", "test4", "test4", "test4");
        AgifyUser agifyUser1 = new AgifyUser("t", 50, 500, "FR");
        AgifyUser agifyUser2 = new AgifyUser("te", 52, 500, "DE");
        AgifyUser agifyUser3 = new AgifyUser("tes", 53, 500, "GB");
        AgifyUser agifyUser4 = new AgifyUser("test", 54, 500, "ES");
        APIRepository.addNewUser(userData1, agifyUser1);
        APIRepository.addNewUser(userData2, agifyUser2);
        APIRepository.addNewUser(userData3, agifyUser3);
        APIRepository.addNewUser(userData4, agifyUser4);
        Assertions.assertThat(APIRepository.getNumberOfUsers()).isEqualTo(4);
        Assertions.assertThat(4).isEqualTo(4);
    }
}
