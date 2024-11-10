package com.app.gestion.app.Security.jwt;

import com.app.gestion.app.model.Cuenta;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtAuthenticationProvider {

    @Value("${jwt-secret}")
    private String jwtsecret;

    @Value("${jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String generarToken(Authentication authentication, Cuenta cuenta) {
        String usuario = authentication.getName();

        Date fechaActual = new Date();
        Date fechaExpiracion = new Date(fechaActual.getTime() + jwtExpirationInMs);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(cuenta, Map.class);

        return Jwts.builder().setSubject(usuario).setIssuedAt(new Date()).setExpiration(fechaExpiracion)
                .addClaims(map)
                .signWith(SignatureAlgorithm.HS512, jwtsecret).compact();
    }

    public String obtenerUsuarioDelJwt(String token) {
        if (validarToken(token)) {
            Claims claims = Jwts.parser().setSigningKey(jwtsecret).parseClaimsJws(token).getBody();
            return claims.getSubject();
        }

        return null;
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtsecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Firma JWT no valida");
        } catch (MalformedJwtException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jwt no valido");
        } catch (ExpiredJwtException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jwt expirado");
        } catch (UnsupportedJwtException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jwt no compatible");
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Jwt incompleto");
        }
    }
}
