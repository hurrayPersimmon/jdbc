package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

public class InsertManyTest {

    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");

        List<Document> insertList = new ArrayList<>();
        Document document1 = new Document();
        Document document2 = new Document();

        document1.append("title", "test1");
        document2.append("title", "test2");

        document1.append("description", "test3");
        document2.append("description", "test4");

        document1.append("done", false);
        document2.append("done", false);

        InsertManyResult result = collection.insertMany(insertList);
        System.out.println(result.getInsertedIds());

        Database.close();
    }

}
