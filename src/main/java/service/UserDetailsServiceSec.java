package service;

import model.RolesEntity;
import model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDao;



@Service
public class UserDetailsServiceSec implements UserDetailsService {


    @Autowired
   private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userDao.getUserByEmail(email);

        User.UserBuilder builder = null;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] roles = user.getRoles()
                    .stream().map(a -> a.getRole()).toArray(String[]::new);

            builder.authorities(roles);
        } else {
            throw new UsernameNotFoundException("User not found.");
        }
        return builder.build();
    }


//        List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
//
//        return (UserDetails) buildUserForAuthentication(user, authorities);
//        return null;
//    }
//
//    //Converts UserEntity user to org.springframework.security.core.userdetails.User...
//    private UserEntity buildUserForAuthentication(model.UserEntity user,
//                                            List<GrantedAuthority> authorities) {
//        return new UserEntity(user.getForename(), user.getSurname(), user.getEmail(), user.getPassword(), user.getRateUser(),
//                user.getBirthdate(), user.isEnabled()
//                user.getEmail(),
//                user.getPassword(), user.isEnabled(),
//                true, true, true, authorities);
//    }
//
//    private List<GrantedAuthority> buildUserAuthority(Set<RolesEntity> roles) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        //Build user's authorities
//        for (RolesEntity setAuths : roles) {
//            setAuths.add(new SimpleGrantedAuthority(user.getRole()));
//        }
//
//        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return Result;
//    }


    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
