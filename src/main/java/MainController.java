import Services.HelloService;
import Services.HelloServiceImp;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class MainController {
  public static void main(String[] args) {

    port(9000);

    get("/*", (req, res) -> {
      HelloService helloService = new HelloServiceImp();
      Map map = new HashMap();
      map.put("name", req.splat()[0]);
      map.put("greeting", helloService.hello());
      return new ModelAndView(map, "hello.hbs");
    }, new HandlebarsTemplateEngine());

    notFound((req, res) -> "Custom 404 page");

    internalServerError((req, res) -> "Custom Error");

    after((request, response) -> response.header("Content-Encoding", "gzip"));

    exception(Exception.class, (exception, request, response) -> {
      //return exception.getMessage();
    });

  }
}