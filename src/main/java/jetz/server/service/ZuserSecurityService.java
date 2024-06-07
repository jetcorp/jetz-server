package jetz.server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jetz.server.entity.Zuser;
import jetz.server.repository.ZuserRepository;
import jetz.server.utils.ZuserRole;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZuserSecurityService implements UserDetailsService {
    private final Logger logger = LoggerFactory.getLogger(ZuserSecurityService.class);

    private final ZuserRepository zuserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Zuser> _zuser = this.zuserRepository.findByEmail(email);

        if (_zuser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Zuser zuser = _zuser.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("jetz".equals(email)) {
            authorities.add(new SimpleGrantedAuthority(ZuserRole.ADMIN.getRole()));
        } else {
            authorities.add(new SimpleGrantedAuthority(ZuserRole.USER.getRole()));
        }

        return new User(zuser.getEmail(), zuser.getPassword(), authorities);
    }
}
