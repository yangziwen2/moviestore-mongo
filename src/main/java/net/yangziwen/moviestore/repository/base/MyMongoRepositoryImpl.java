package net.yangziwen.moviestore.repository.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;

public class MyMongoRepositoryImpl<T, ID extends Serializable> extends SimpleMongoRepository<T, ID> implements MyMongoRepository<T, ID> {

	private MongoOperations mongoOperations;
	private MongoEntityInformation<T, ID> metadata;
	
	public MyMongoRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
		this.mongoOperations = mongoOperations;
		this.metadata = metadata;
	}
	
	@Override
	public long count(Query query) {
		if(query == null) {
			return 0;
		}
		return mongoOperations.count(query, metadata.getJavaType());
	}

	@Override
	public List<T> findAll(Query query) {
		if (query == null) {
			return Collections.emptyList();
		}
		return mongoOperations.find(query, metadata.getJavaType());
	}
	
	@Override
	public Page<T> findAll(Query query, Pageable pageable) {
		Long count = count(query);
		List<T> list = findAll(query.with(pageable));
		return new PageImpl<T>(list, pageable, count);
	}
	
}
