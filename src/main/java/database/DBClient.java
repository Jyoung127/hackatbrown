package database;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.hackteam.processSongs.PlayList_Maker;
import com.hackteam.processSongs.Song;
import com.hackteam.processSongs.User;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class DBClient {
	MongoClientURI uri = new MongoClientURI(
			"mongodb://Jyoung127:playlistapp@ds059195.mongolab.com:59195/playlistapp");
	MongoClient mongoClient = new MongoClient(uri);
	MongoDatabase db = mongoClient.getDatabase(uri.getDatabase());
	
	private Document encodeSong(Song s) {
		return new Document("songname", s.getSongName())
				.append("songid", s.getSongID());
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
	
	public ArrayList<Song> makePlaylist() {
		
		MongoCollection<Document> coll = db.getCollection("users");
		MongoCursor<Document> cursor = coll.find().iterator();
		ArrayList<User> userList = new ArrayList<User>();
		
		while (cursor.hasNext()) {
			Document doc = cursor.next();
			String userID = doc.get("user").toString();
			ArrayList<Song> userSongs = new ArrayList<Song>();
			List<Document> songList = (List<Document>)doc.get("songs");
			for (Document d : songList) {
				String name = d.get("songname").toString();
				String songID = d.get("songid").toString();
				Song currSong = new Song(songID, name);
				userSongs.add(currSong);
			}
			userList.add(new User(userID, userSongs));
		}
		
		PlayList_Maker plm = new PlayList_Maker(userList, 0.7);
		ArrayList<Song> playlist = plm.generatePlaylist();
		
		for (Song str : playlist) {
			System.out.println(str.getSongName());
		}
		System.out.println(playlist.size());
		return playlist;
	}
	
	public static void main(String[] args) {
		DBClient c = new DBClient();
		c.makePlaylist();
	}
	
}
