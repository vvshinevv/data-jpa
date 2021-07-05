package study.datajpa.proxy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultUserService implements UserService {
    @Override
    @Transactional
    public void getUser() {

    }
}
