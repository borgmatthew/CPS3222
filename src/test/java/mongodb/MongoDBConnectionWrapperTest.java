package mongodb;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class MongoDBConnectionWrapperTest {

	MongoDBConnectionWrapper connectionWrapper;
	
	@Before
	public void setUp(){
		connectionWrapper = new MongoDBConnectionWrapperImpl();
	}

	@Test
	public void testConnectHostIsNull() {
		//given
		//when
		//then
		assertNull(connectionWrapper.connect(null, 27017));
	}
	
	@Test
	public void testConnectionPortIsNegative(){
		//given
		//when
		//then
		assertNull(connectionWrapper.connect("", -27017));
	}
}
