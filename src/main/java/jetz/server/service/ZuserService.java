package jetz.server.service;

import java.time.LocalDateTime;
import java.util.Optional;
import jetz.server.entity.Zuser;
import jetz.server.repository.ZuserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ZuserService {
    private final ZuserRepository zuserRepository;
    private final PasswordEncoder passwordEncoder;

    public Zuser create(String email, String password, String zname) {

        Zuser zuser = new Zuser(email, passwordEncoder.encode(password), zname, LocalDateTime.now());

        zuserRepository.save(zuser);

        return zuser;
    }

    public Zuser getZuser(String email) {
        Optional<Zuser> _zuser = zuserRepository.findByEmail(email);

        if (_zuser.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        Zuser zuser = _zuser.get();

        return zuser;
    }
}
