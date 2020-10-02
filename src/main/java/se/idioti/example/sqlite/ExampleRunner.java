package se.idioti.example.sqlite;

import java.sql.Timestamp;
import java.util.List;

/**
 * This example showcases how the storage can be used.
 * 
 * @author "Johan Holmberg, Malmö university"
 * @since 1.0
 */
public class ExampleRunner {

	public static void main(String[] args) throws ClassNotFoundException {
		Storage storage = new Storage();
		List<Unicorn> unicorns = null;
		Unicorn unicorn = null;
		
		storage.setup();
		
		unicorns = storage.fetchUnicorns();
		for (Unicorn u: unicorns) {
			System.out.println(u.id + ": " + u.name);
		}
		System.out.println();

		unicorn = storage.fetchUnicorn(3);
		System.out.println(unicorn.id + ": " + unicorn.name);
		System.out.println("reportedBy: " + unicorn.reportedBy);
		System.out.println();

		unicorn.reportedBy = "Batman";
		storage.updateUnicorn(unicorn);
		unicorn = storage.fetchUnicorn(3);
		System.out.println(unicorn.id + ": " + unicorn.name);
		System.out.println("reportedBy: " + unicorn.reportedBy);
		System.out.println();
		
		unicorn = new Unicorn();
		unicorn.name = "Konstig enhörning";
		unicorn.description = "Det här är ingen vacker enhörning";
		unicorn.reportedBy = "Johan";
		unicorn.spottedWhere.name = "Niagara";
		unicorn.spottedWhere.lat = 55.609183;
		unicorn.spottedWhere.lon = 12.994875;
		unicorn.spottedWhen = Timestamp.valueOf("2015-09-22 20:14:00");
		unicorn.image = "https://pbs.twimg.com/profile_images/512349801929650177/_hfDmaho.jpeg";
		storage.addUnicorn(unicorn);
		unicorn = storage.fetchUnicorn(5);
		System.out.println(unicorn.id + ": " + unicorn.name);
		System.out.println();

		unicorns = storage.fetchUnicorns();
		System.out.println("Antal enhörningar: " + unicorns.size());
		storage.deleteUnicorn(5);
		unicorns = storage.fetchUnicorns();
		System.out.println("Antal enhörningar: " + unicorns.size());
	}

}
