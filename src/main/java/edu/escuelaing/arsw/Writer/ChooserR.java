package edu.escuelaing.arsw.Writer;
import java.util.HashMap;
import java.util.Map;

public class ChooserR {
    /**
     * Devuelve el write apartir de un string
     */
    public static Map<String, WriterR> selector=new HashMap<String, WriterR>(){{
        put("html",new TextWriter("html"));
        put("png",new WriterI("png"));
        put("jpg",new WriterI("jpg"));
        put("js",new TextWriter("javascript"));
        put("css",new TextWriter("css"));
        put("err",new WriteE("Ese tipo no se admite"));
    }
    };

    public static WriterR choose(String path) throws Exception {
        String resource = "";
        try {
            String[] s = path.split("\\.");
            resource = s[s.length - 1].toLowerCase();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception(" Peticion mal formada ");
        }
        if (!selector.containsKey(resource)) {
            return selector.get("err");
        } else {
            return selector.get(resource);

        }
    }
}
