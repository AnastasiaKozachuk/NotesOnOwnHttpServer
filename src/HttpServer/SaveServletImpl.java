package HttpServer;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SaveServletImpl implements HttpServlet {

    @Override
    public HttpResponse doPost(HttpRequest request, HttpResponse response) throws UnsupportedEncodingException {



        if (request.getRequest().contains("delete")) {

            Integer deleteKey = -1;

            for(Integer key : HttpServer.notes.keySet()){
                if(request.getRequest().contains("delete"+key)){
                    deleteKey = key;
                    break;
                }
            }

            HttpServer.notes.remove(deleteKey);

        } else {


            String postContent = request.getRequest().substring(request.getRequest().indexOf("\r\n\r\n")+4);

            String allNotes[] = postContent.split("&");
            HttpServer.notes = new HashMap<>();
            for(String note:allNotes){
                Integer number = Integer.valueOf(note.substring(note.indexOf("note")+4,note.indexOf("=")));
                String text = URLDecoder.decode(note.substring(note.indexOf("=")+1),"UTF-8");
                if(!text.isEmpty()){
                    HttpServer.notes.put(number,text);
                }
            }
        }

        Integer j = 0;

        if (HttpServer.notes.size() > 0) {
            j = Collections.max(HttpServer.notes.keySet());
        }

        String responseText = "";

        responseText += PagePattern.getHeader();

        for (Map.Entry<Integer, String> note : HttpServer.notes.entrySet()) {
            responseText += PagePattern.getNote(note.getValue(), note.getKey());
        }

        responseText += PagePattern.getNote(++j);
        responseText += PagePattern.getFooter();

        response.setResponse(responseText);


        return response;
    }


    @Override
    public HttpResponse doGet(HttpRequest request, HttpResponse response) {

        String responseText = "";

        responseText += PagePattern.getHeader();

        for (Map.Entry<Integer, String> note : HttpServer.notes.entrySet()) {
            responseText += PagePattern.getNote(note.getValue(), note.getKey());
        }

        Integer i = Collections.max(HttpServer.notes.keySet());

        responseText += PagePattern.getNote(++i);
        responseText += PagePattern.getFooter();

        response.setResponse(responseText);

        return response;
    }


}
