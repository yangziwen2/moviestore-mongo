package net.yangziwen.moviestore.repository.base;

import java.io.Serializable;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory;
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class MyMongoRepositoryFactoryBean <R extends MongoRepository<T, I>, T, I extends Serializable>
	extends MongoRepositoryFactoryBean<R, T, I> {
	
	@Override
	protected RepositoryFactorySupport getFactoryInstance(MongoOperations operations) {
		return new MyMongoRepositoryFactory<T, I>(operations);
	}
	
	private static class MyMongoRepositoryFactory<T, I extends Serializable> extends MongoRepositoryFactory {
		
		private MongoOperations mongoOperations;
		
		public MyMongoRepositoryFactory(MongoOperations mongoOperations) {
			super(mongoOperations);
			this.mongoOperations = mongoOperations;
		}
		
		@SuppressWarnings("unchecked")
		protected Object getTargetRepository(RepositoryMetadata metadata) {
			MongoEntityInformation<T, I> entityInformation = (MongoEntityInformation<T, I>) getEntityInformation(metadata.getDomainType());
			return new MyMongoRepositoryImpl<T, I>(entityInformation, mongoOperations);
		}
		
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return MyMongoRepository.class;
		}
		
	}

}
