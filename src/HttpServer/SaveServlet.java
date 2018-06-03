package HttpServer;

import java.io.UnsupportedEncodingException;

public class SaveServlet implements Servlet  {

    @Override
    public void init() {
        System.out.println("[INFO] Servlet was initiated");
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) {

        if(request.getMethodCall().equalsIgnoreCase("post")){
            SaveServletImpl saveServlet = new SaveServletImpl();
            try {
                saveServlet.doPost(request,response);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        if(request.getMethodCall().equalsIgnoreCase("get")){
            SaveServletImpl saveServlet = new SaveServletImpl();
            saveServlet.doGet(request,response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("[INFO] Servlet was destroyed");
    }
}
