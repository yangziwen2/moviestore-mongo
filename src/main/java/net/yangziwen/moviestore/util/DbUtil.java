package net.yangziwen.moviestore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class DbUtil {
	
	private static final int DEFAULT_IMPORT_BATCH_SIZE = 500;

	private DbUtil() {}
	
	public static void importData(File dataFile, String collectionName, int batchSize) {
		if(!dataFile.exists()) {
			throw new IllegalArgumentException("dataFile must exist!");
		}
		if(batchSize <= 0) {
			batchSize = DEFAULT_IMPORT_BATCH_SIZE;
		}
		MongoTemplate mongoTemplate = SpringUtil.getBean(MongoTemplate.class);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile), "UTF-8"));
			String line = "";
			List<DBObject> objList = new ArrayList<DBObject>(batchSize);
			while((line = reader.readLine()) != null) {
				DBObject object = (DBObject) JSON.parse(line);
				objList.add(object);
				if(objList.size() >= batchSize) {
					mongoTemplate.getDb().getCollection(collectionName).insert(objList.toArray(new DBObject[]{}));
					objList = new ArrayList<DBObject>(batchSize);
				}
			}
			if(CollectionUtils.isNotEmpty(objList)) {
				mongoTemplate.getDb().getCollection(collectionName).insert(objList.toArray(new DBObject[]{}));
			}
		} catch (Exception e) {
			throw new IllegalStateException("Error happens in the process of importing data", e);
		} finally {
			IOUtils.closeQuietly(reader);
		}

	}
}
