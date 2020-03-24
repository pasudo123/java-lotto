package launcher.web;

import launcher.web.config.WebConfiguration;
import lotto.Money;
import lotto.Won;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;


public class WebMain {

    private static WebConfiguration webConfiguration;

    static {
        webConfiguration = new WebConfiguration();
    }

    public static void main(String[]args){

        get("/", (request, response) -> {
            return render(new HashMap<>(), "index.html");
        });


        post("/buyLotto", (request, response) -> {

            final Money money = new Won(request.queryParamOrDefault("inputMoney", "0"));
            final Money manualLotto =

            return render(new HashMap<>(), "show.html");
        });
    }

    static String render(Map<String, Object> model, String templatePath){
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
