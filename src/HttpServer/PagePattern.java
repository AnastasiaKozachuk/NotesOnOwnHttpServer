package HttpServer;

public class PagePattern {

    static String getHeader() {
        String header = "";
        header += "HTTP/1.1 200 OK\r\n";
        header += "Content-Type: text/html\r\n\r\n";

        header += "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Notes</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\">\n" +
                "    <style media=\"screen\" type=\"text/css\">\n" +
                "\n" +
                "body{\n" +
                "\n" +
                "    background-color: rgba(210, 105, 30, 0.75) ;\n" +
                "\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "\n" +
                "    color: cornsilk;\n" +
                "    text-align: center;\n" +
                "    font-size: 50px ;\n" +
                "    font-weight: bold ;\n" +
                "    padding-top: 30px;\n" +
                "    font-family: Centaur ;\n" +
                "    margin-bottom: 50px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".note{\n" +
                "    height: 350px;\n" +
                "    max-width: 250px;\n" +
                "    background-color: beige;\n" +
                "    color: #8e7869;\n" +
                "    margin: 33px;\n" +
                "    border: #8e7869 solid 2px;\n" +
                "\n" +
                "}\n" +
                "\n" +
                ".header-note{\n" +
                "    padding: 10px;\n" +
                "    font-size: 16px;\n" +
                "    background-color: beige;\n" +
                "    border: none;\n" +
                "    outline: none;\n" +
                "    height: 320px;\n" +
                "    width: 230px;\n" +
                "    resize: none;\n" +
                "}\n" +
                "\n" +
                ".footer{\n" +
                "\n" +
                "    width: 100%;\n" +
                "    height: 70px;\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".footer-button{\n" +
                "    margin: 80px;\n" +
                "    width: 130px;\n" +
                "    height: 40px;\n" +
                "    font-size: 16px;\n" +
                "    background-color: #8e7869;\n" +
                "    color: beige;\n" +
                "    border: 1px solid beige;\n" +
                "    outline: none;\n" +
                "}\n" +
                "\n" +
                ".footer-button:hover{\n" +
                "    background-color: #644f43;\n" +
                "}\n" +
                "\n" +
                ".footer-button:active{\n" +
                "    background-color: #907a6c;\n" +
                "}\n" +
                "\n" +
                ".another-button{\n" +
                "    margin-top: 35px;\n" +
                "    text-align: center;\n" +
                "}\n" +
                "\n" +
                ".button-style{\n" +
                "    font-size: 16px;\n" +
                "    background-color: #8e7869;\n" +
                "    color: beige;\n" +
                "    border: 1px solid beige;\n" +
                "    outline: none;\n" +
                "    width: 40px;\n" +
                "    height: 40px;\n" +
                "    border-radius: 50px;\n" +
                "}\n" +
                "\n" +
                ".button-style:hover{\n" +
                "    background-color: #644f43;\n" +
                "}\n" +
                "\n" +
                ".button-style:active{\n" +
                "    background-color: #907a6c;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "    </style>\n" +
                "\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div>\n" +
                "    <h1> Your amazing notes </h1>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"container-fluid\">\n" +
                "    <div class=\"row \">\n";

        return header;

    }

    static String getFooter() {
        String footer = "";

        footer += "</div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"row \">\n" +
                "\n" +
                "    <div class=\"footer\">\n" +
                "        <form action=\"/servlet/SaveServlet\" method=\"post\" id=\"saveForm\">\n" +
                "            <input type=\"submit\" value=\"Save note\" class=\"footer-button\">\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        return footer;
    }

    static String getNote(int i){
        String note = "";

        note+="<div class=\"note col-xs-6 col-md-4\">\n" +
                "            <textarea class=\"header-note\" name=\"note"+i+"\" placeholder=\"Enter your note here...\" form=\"saveForm\"></textarea>\n" +
                "\n" +
                " <div class=\"row another-button\">\n" +
                "                <div class=\"col-xs-12\">\n" +
                "                    <form action=\"/servlet/SaveServlet\" method=\"post\" id = \"deleteForm"+i+"\">\n" +
                "                        <button type=\"submit\" class=\"glyphicon glyphicon-remove button-style\" name=\"delete"+i+"\" value=\"delete\"></button>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>"+
                "        </div>";

        return note;
    }

    static String getNote(String text, int i){
        String note = "";

        note+="<div class=\"note col-xs-6 col-md-4\">\n" +
                "            <textarea class=\"header-note\" name=\"note"+i+"\" form=\"saveForm\">"+text+"</textarea>\n" +
                "\n" +
                " <div class=\"row another-button\">\n" +
                "                <div class=\"col-xs-12\">\n" +
                "                    <form action=\"/servlet/SaveServlet\" method=\"post\" id = \"deleteForm"+i+"\">\n" +
                "                        <button type=\"submit\" class=\"glyphicon glyphicon-remove button-style\" name=\"delete"+i+"\" value=\"delete\"></button>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </div>"+
                "        </div>";

        return note;
    }


}
