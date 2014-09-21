package net.yangziwen.moviestore.repository.base;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyMongoRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {

	List<T> findAll(Query query);

	long count(Query query);

	Page<T> findAll(Query query, Pageable pageable);

}
