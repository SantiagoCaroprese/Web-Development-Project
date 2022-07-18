package com.javeriana.web.project.Employees.Employee.Infrastructure.Security;

import com.javeriana.web.project.Employees.Employee.Domain.Employee;
import com.javeriana.web.project.Employees.Employee.Domain.Ports.TokenGenerator;
import com.javeriana.web.project.Shared.Domain.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class JWTTokenGenerator implements TokenGenerator {

    private final String ID = "realEstateAppToken";
    private final String SECRET = "web_dev_real_estate";
    private final String CLAIM = "authorities";
    private final int validity = 1800000;
    private final String PREFIX = "Bearer ";

    @Override
    public Token getToken(Employee employee) {
        List<GrantedAuthority> grantedAuthorities;
        HashMap<String, String> employeeData = employee.data();
        if (employeeData.get("is_admin").equals("true")) {
            grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_EMPLOYEE,ROLE_ADMIN");
        }
        else {
            grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_EMPLOYEE");
        }
        String token = Jwts.builder()
                .setId(ID)
                .setSubject(employeeData.get("id"))
                .claim(CLAIM, grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
        return new Token(PREFIX + token);
    }
}
