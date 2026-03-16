
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CarpoolService {
    static File file = new File("rides.json");
    static ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) throws IOException {
        Javalin app = Javalin.create(config ->{
            config.staticFiles.add("/public", Location.CLASSPATH);
        } );


        if(!file.exists()){
            mapper.writeValue(file, new ArrayList<>());
        }

        app.get("/rides", ctx -> {
            List<Map> rides = mapper.readValue(file, List.class);
            StringBuilder html = new StringBuilder();
            html.append()

        });

        app.post("/rides", ctx->{
            List<Map> rides = mapper.readValue(file, List.class);
            rides.add(ctx.bodyAsClass(Map.class));
            mapper.writeValue(file, rides);
            ctx.status(201);
        });
        app.start();
    }




}
