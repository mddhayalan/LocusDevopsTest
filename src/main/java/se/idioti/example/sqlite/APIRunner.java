package se.idioti.example.sqlite;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.List;

/**
 * This demonstrates how to expose the storage through a REST API using Spark.
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class APIRunner {

	public static void main(String[] args) throws Exception {
		port(5000);
		
		Storage storage = new Storage();
		storage.setup();
		
		// A demonstration of how to use code within an endpoint
		get("/", (req, res) -> {
			return "Hello world";
		});
	}

}
