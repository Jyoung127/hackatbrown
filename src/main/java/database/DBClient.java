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
	
	private Document encodeSong(Song s) {
		return new Document("songname", s.getSongName())
				.append("songid", s.getSongName());
	}
	
	private Document getData(ArrayList<Song> alos, String userID) {
		ArrayList<Document> songDocList = new ArrayList<Document>();
		for (Song song : alos) {
			songDocList.add(encodeSong(song));
		}
		Document toReturn = new Document("user", userID)
				.append("songs", songDocList);
		
		return toReturn;
	}
	
	public void addToDB(ArrayList<Song> alos, String userID) {
		Document data = getData(alos, userID);
		db.getCollection("users").insertOne(data);
	}
	
}
