package HttpServer;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

class ServletHandler {


    private String servletName;
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    ServletHandler(String servletName, HttpRequest request, HttpResponse response) {
        this.servletName = servletName;
        this.httpRequest = request;
        this.httpResponse = response;
        handleServlet();
    }

    private void handleServlet() {
        try {

            URL[] classLoaderUrls = new URL[]{new URL("file:/C:/Users/Admin/IdeaProjects/WebNotesServer/out/production/WebNotesServer/HttpServer")};

            URLClassLoader loader = new URLClassLoader(classLoaderUrls);

            Class servlet = loader.loadClass("HttpServer."+servletName);

           Servlet servletInstance = (Servlet) servlet.newInstance();

           servletInstance.init();
           servletInstance.service(httpRequest, httpResponse);
           servletInstance.destroy();

        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }


}
