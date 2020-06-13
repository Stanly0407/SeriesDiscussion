package service;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.UserDao;

import java.util.Arrays;


@Service
public class UserDetailsServiceImp implements UserDetailsService {


    @Autowired
   private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getUserByUsername(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (user != null) {

            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] authorities = user.getAuthorities()
                    .stream().map(a -> a.getAuthority()).toArray(String[]::new);

            builder.authorities(authorities);
            System.out.println(Arrays.toString(authorities));
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



    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}

//    private List<GrantedAuthority> buildUserAuthority(Set<RolesEntity> roles) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//

//    }
//        private List<GrantedAuthority> buildUserAuthority(Set<RoleEntity> roles) {
//            Set<GrantedAuthority> setAuths = new HashSet<>();
//                    //Build user's authorities
//        for (RoleEntity role : roles) {
//            setAuths.add(new SimpleGrantedAuthority(role);
//        }
//
//        List<GrantedAuthority> Result = new List<GrantedAuthority>(setAuths);
//
//        return Result;
//
//        }
//
//        private User buildUserForAuthentication(UserEntity user,
//                List<GrantedAuthority> authorities) {
//            return new User(user.getEmail(), user.getPassword(),
//                    user.isEnabled(), true, true, true, authorities);
//        }
//
//        @Override
//        @Transactional(readOnly = true)
//        public UserDetails loadUserByUsername(String email)
//            throws UsernameNotFoundException {
//            UserEntity user = userDao.getUserByEmail(email);
//            List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
//            return buildUserForAuthentication(user, authorities);
//        }
