package sec03;

import app.Database;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public class FindTest {

    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        FindIterable<Document> iterable = collection.find();

        for (Document doc : iterable) {
            System.out.println(doc.toJson());
        }
        Database.close();
    }

}
