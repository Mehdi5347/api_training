package fr.esiea.ex4A.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class APIController {
    private final AgifyService agifyService;

    public APIController(AgifyService agifyService) { this.agifyService = agifyService; }

    @PostMapping("/api/inscription")
    public void inscription(@RequestBody InfoUtilisateur infoUtilisateur) throws IOException {
        System.out.println(infoUtilisateur);
        this.agifyService.addUser(infoUtilisateur);
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<InfoUtilisateur> getMatchingUsers(@RequestParam(name = "userName", required = true) String name, @RequestParam(name = "userCountry", required = true) String country) {
        List<InfoUtilisateur> userList = this.agifyService.matchUser(name, country);
        return userList;
    }
}
