package fr.esiea.ex4A.api;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class APIRepository {
    final HashMap<String, InfoUtilisateur> userList = new HashMap<>();
    final HashMap<String, AgifyUser> userListWithAge = new HashMap<>();

    int getNumberOfUsers(){
        return this.userList.size();
    }

    void addNewUser(InfoUtilisateur infoUtilisateur, AgifyUser userDataWithAge){
        this.userList.put(infoUtilisateur.getUserId(), infoUtilisateur);
        this.userListWithAge.put(infoUtilisateur.getUserId(), userDataWithAge);
    }

    boolean seeIfUserExists(InfoUtilisateur infoUtilisateur){
        return this.userList.containsKey(infoUtilisateur.getUserId());
    }

    InfoUtilisateur getUser(String userName, String countryId){
        return this.userList.get(userName.concat(countryId));
    }

    ArrayList<InfoUtilisateur> matchUser(InfoUtilisateur infoUtilisateur){
        ArrayList<InfoUtilisateur> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, AgifyUser> userEntry : this.userListWithAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.userListWithAge.get(infoUtilisateur.getUserId()).getAge()) <= 4){
                InfoUtilisateur possiblyMatchingUser = this.userList.get(userEntry.getValue().getUserId());
                if(possiblyMatchingUser.getSex().equals(infoUtilisateur.getSexPref()) && infoUtilisateur.getSex().equals(possiblyMatchingUser.getSexPref())) {
                    matchingUsers.add(this.userList.get(userEntry.getValue().getUserId()));
                }
            }
        }
        return matchingUsers;
    }
}
