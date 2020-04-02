package cn.gotham.spring_security_01;

import cn.gotham.spring_security_01.asset.bean.ParamFlag;
import cn.gotham.spring_security_01.asset.service.AssetService;
import cn.gotham.spring_security_01.user.repository.RoleRepository;
import cn.gotham.spring_security_01.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSecurity01ApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringSecurity01Application.class);

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssetService assetService;

    @Test
    void contextLoads() throws Exception {

        assetService.insert("20200323","172.156.7.7",new ParamFlag("flag"));
//
//        var role = new Role();
//        role.setRoleName("初始权限");
//        var authorities = Arrays.stream(Authority.values()).collect(Collectors.toList());
//        role.setAuthorityList(authorities);
//        roleRepository.insert(role);
//
//        User user = new User();
//        user.setUsername("gotham");
//        user.setPassword(DigestUtils.md5Hex("gotham123456"));
//        user.setRoles(List.of(role));
//        user.setEmail("3562324299@qq.com");
//        userRepository.insert(user);
//        User user = userRepository.findByUsername("gotham").orElse(null);
//        SimpleGrantedAuthority[] simpleGrantedAuthorities = user.getRoles()
//                .stream()
//                .filter(Objects::nonNull)
//                .map(Role::getAuthorityList)
//                .filter(Objects::nonNull)
//                .flatMap(Collection::stream)
//                .filter(Objects::nonNull)
//                .map(Authority::toString)
//                .map(SimpleGrantedAuthority::new)
//                .toArray(SimpleGrantedAuthority[]::new);
//        Arrays.stream(simpleGrantedAuthorities).forEach(simpleGrantedAuthority -> {
//            LOGGER.info(" 写法一 ：： {} ",simpleGrantedAuthority.getAuthority());
//        });
//
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        List<Role> roles = user.getRoles();
//        roles.forEach(role -> {
//            role.getAuthorityList().forEach(authority -> {
//                authorities.add(new SimpleGrantedAuthority(authority.toString()));
//            });
//        });
//        authorities.stream().forEach(grantedAuthority -> {
//            LOGGER.info("写法二 ：： {}",grantedAuthority.getAuthority());
//        });


    }

}
