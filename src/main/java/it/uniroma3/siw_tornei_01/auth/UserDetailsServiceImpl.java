package it.uniroma3.siw_tornei_01.auth;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.uniroma3.siw_tornei_01.model.Credenziali;
import it.uniroma3.siw_tornei_01.repository.CredenzialiRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CredenzialiRepository credenzialiRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Peschiamo le credenziali dal database usando lo username
        Credenziali credenziali = credenzialiRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato: " + username));

        // Costruiamo l'utente di Spring Security
        return new User(
            credenziali.getUsername(),
            credenziali.getPassword(), 
            Collections.singletonList(new SimpleGrantedAuthority(credenziali.getRole()))
        );
    }
}