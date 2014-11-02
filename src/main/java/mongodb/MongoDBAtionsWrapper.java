package mongodb;

import com.mongodb.DBObject;

public interface MongoDBAtionsWrapper {
	public boolean insert(String dbName, String tblName, DBObject ... objects);
}
