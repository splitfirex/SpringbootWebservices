package io.splitfirex.commons.repository;

import io.splitfirex.commons.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String lastName);

}
