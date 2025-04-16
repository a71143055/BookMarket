package kr.ac.kopo.jeong.bookmarket.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping(value="home", method = RequestMethod.GET)
    public String welcomeMethod() {

        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Welcome</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\"\n" +
                "          rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\"\n" +
                "          crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container py-4\">\n" +
                "    <header class=\"pb-3 mb-4 border-bottom\">\n" +
                "        <a href=\"/PrivateBookMarket.html\" class=\"d-flex align-items-center text-body-emphasis text-decoration-none\">\n" +
                "            <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\" fill=\"currentColor\" class=\"bi bi-book\" viewBox=\"0 0 16 16\">\n" +
                "                <path d=\"M1 2.828c.885-.37 2.154-.769 3.388-.893 1.33-.134 2.458.063 3.112.752v9.746c-.935-.53-2.12-.603-3.213-.493-1.18.12-2.37.461-3.287.811zm7.5-.141c.654-.689 1.782-.886 3.112-.752 1.234.124 2.503.523 3.388.893v9.923c-.918-.35-2.107-.692-3.287-.81-1.094-.111-2.278-.039-3.213.492zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783\"/>\n" +
                "            </svg>\n" +
                "        </a>\n" +
                "    </header>\n" +
                "    <div class=\"p-5 mb-4 bg-body-tertiary rounded-3\">\n" +
                "        <div class=\"container-fluid py-5\">\n" +
                "            <h1 class=\"display-5 fw-bold\">도서 쇼핑몰에 오신 것을 환영합니다</h1>\n" +
                "            <p class=\"col-md-8 fs-4\">BookMarket</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"row alin-items-md-stretch text-center\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"h-100 p-5\">\n" +
                "                <h2>Welcome to Web Market!</h2>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <footer class=\"pt-3 mt-4 text-body-secondary border-top\">\n" +
                "        <span class=\"text-body-secondary\">&copy; BookMarket</span>\n" +
                "    </footer>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }
}