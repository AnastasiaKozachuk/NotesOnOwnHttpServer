package HttpServer;

public interface Servlet {

    void init();
    void service(HttpRequest request, HttpResponse response);
    void destroy();

}
