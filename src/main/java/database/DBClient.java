package database;

import java.util.ArrayList;

import org.bson.Document;

import com.hackteam.processSongs.Song;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DBClient {
	MongoClientURI uri = new MongoClientURI(
			"mongodb://Jyoung127:playlistapp@ds059195.mongolab.com:59195/playlistapp");
	MongoClient mongoClient = new MongoClient(uri);
	MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());
	
	private Document getData() {
		BasicDBObject user = new BasicDBObject();
		BasicDBObject userData = new BasicDBObject();
		BasicDBObject songList = new BasicDBObject();
		
		
		userData.put("song1", 1);
		
		//user.put(arg0, arg1)
		return null;
	}
	
	public void addToDB(ArrayList<Song> alos) {
		Document data = getData();
		db.getCollection("users").insertOne(data);
	}
	
}
