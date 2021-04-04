package fr.esiea.ex4A.api;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final APIRepository APIRepository = new APIRepository();

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void addUser(InfoUtilisateur user) throws IOException {
        AgifyUser agifyUser;
        if(!APIRepository.seeIfUserExists(user)){
            agifyUser = this.agifyClient.getUserAge(user.name, user.country).execute().body();
            APIRepository.addNewUser(user, agifyUser);
        }
    }

    public ArrayList<InfoUtilisateur> matchUser(String userName, String userCountry){
        InfoUtilisateur userRequestingMatch = APIRepository.getUser(userName, userCountry);
        if(userRequestingMatch != null){
            return APIRepository.matchUser(userRequestingMatch);
        } else {
            return new ArrayList<>();
        }
    }
}
