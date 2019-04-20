package com.schinta.repository;

import com.schinta.domain.UserDemand;
import com.schinta.domain.WxUser;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


/**
 * Spring Data  repository for the UserDemand entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserDemandRepository extends JpaRepository<UserDemand, Long> {

    @Query("select demand from UserDemand demand left join fetch demand.wxUser user where user.userStatus = 'ACTIVE'")
    List<UserDemand> findAllActiveWithUser();

    List<UserDemand> findAllByWxUser(WxUser user);

    List<UserDemand> findAllByWxUserIn(Set<WxUser> userSet);

    @Modifying
    @Query("delete from UserDemand demand where demand.wxUser = :wxUser")
    int deleteAllByWxUser(@Param("wxUser") WxUser wxUser);
}
