package org.sid.secservice.sec.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sid.secservice.sec.JWTUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request.getServletPath().equals("/refreshToken")) {
			filterChain.doFilter(request, response);
		}
		else {
		
			String authorizationToken=request.getHeader("CreAuthorization");
			System.out.println(authorizationToken);
	
			if(authorizationToken!=null && authorizationToken.startsWith(JWTUtil.PREFIX)) {
				//try {
					String jwt=authorizationToken.substring(JWTUtil.PREFIX.length());
					System.out.println(jwt);
					Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
					JWTVerifier jwtVerifier=JWT.require(algorithm).build();
					DecodedJWT decodedJWT= jwtVerifier.verify(jwt);
					String username=decodedJWT.getSubject();

					String[] roles=decodedJWT.getClaim("roles").asArray(String.class);
					Collection<GrantedAuthority> authorities=new ArrayList<>();
					for (String r:roles) {
						authorities.add(new SimpleGrantedAuthority(r));
					}
					
					UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,null,authorities);
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					filterChain.doFilter(request, response);
				//}
				/* catch (Exception e) {
					
					response.setHeader("error-message",e.getMessage());
					response.sendError(HttpServletResponse.SC_FORBIDDEN);
					
				} */
			}
			else {
				filterChain.doFilter(request, response);
			}
		}
		
	}
	
	

}
