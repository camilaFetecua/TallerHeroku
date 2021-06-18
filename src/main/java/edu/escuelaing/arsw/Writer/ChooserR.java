package edu.escuelaing.arsw.Writer;
import java.util.HashMap;
import java.util.Map;

public class ChooserR {
    /**
     * Devuelve el write apartir de un string
     */
    public static Map<String, WriterR> selector=new HashMap<String, WriterR>(){{
        put("html",new TextWriter("html"));
        put("png", (WriterR) new WriterI("png"));
        put("jpg", (WriterR) new WriterI("jpg"));
        put("js",new TextWriter("javascript"));
        put("css",new TextWriter("css"));
        put("err", (WriterR) new WriteE("Tipo no admitido"));
    }
    };

    public static WriterR choose(String path) throws Exception{
        String resource="";
        try{
            String[] s=path.split("\\.");
            resource=s[s.length-1].toLowerCase();
        }catch(ArrayIndexOutOfBoundsException e){
            throw new Exception(" La peticion esta mal formada");
        }
        if (!selector.containsKey(resource)){
            return selector.get("error");
        }else{
            return selector.get(resource);
        }

    }
}
