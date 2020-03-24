package launcher.web;

import launcher.web.config.WebConfiguration;
import launcher.web.service.LottoBuyService;
import launcher.web.service.LottoMatchService;
import lotto.Money;
import lotto.Won;
import lotto.dto.LottoDto;
import lotto.dto.WinningLottoDto;
import lotto.model.BuyingInfo;
import lotto.model.BuyingPocket;
import lotto.model.Lottos;
import lotto.model.ManualLottoPapers;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;


public class WebMain {

    private static WebConfiguration webConfiguration;
    private static LottoBuyService lottoBuyService;
    private static LottoMatchService lottoMatchService;

    private static final String MONEY = "money";
    private static final String LOTTOS = "lottos";

    static {
        webConfiguration = new WebConfiguration();
        lottoBuyService = new LottoBuyService();
        lottoMatchService = new LottoMatchService();
    }

    public static void main(String[]args){

        get("/", (request, response) -> {
            request.session(true);
            return render(new HashMap<>(), "index.html");
        });


        post("/buyLotto", (request, response) -> {

            final Money money = Won.from(Integer.parseInt(request.queryParamOrDefault("inputMoney", "0")));
            final String[] manualNumbers = request.queryParams("manualNumber").split("\r\n");
            final ManualLottoPapers manualLottoPapers = ManualLottoPapers.from(Arrays.asList(manualNumbers));
            final BuyingInfo buyingInfo = BuyingInfo.of(money, manualLottoPapers.getManualLottoPapers().size());
            final BuyingPocket pocket = BuyingPocket.of(buyingInfo, manualLottoPapers);

            final Lottos lottos = Lottos.create(pocket);
            final LottoDto lottoDto  = new LottoDto(lottos, pocket);

            request.session().attribute(MONEY, money);
            request.session().attribute(LOTTOS, lottos);

            Map<String, Object> model = new HashMap<>();
            model.put("lottos", lottoDto);
            model.put("lottoList", lottoDto.getMyLottos());

            return render(model, "show.html");
        });

        post("/matchLotto", (request, response) -> {

            final Money money = request.attribute(MONEY);
            final Lottos lottos = request.attribute(LOTTOS);
            final String winningNumber = request.queryParams("winningNumber");
            final Integer bonusNumber = Integer.parseInt(request.queryParams("bonusNumber"));

            WinningLottoDto winningLottoDto = lottoMatchService.getMyWinningLottos(money, lottos, winningNumber, bonusNumber);

            Map<String, Object> model = new HashMap<>();
            model.put("winningLotto", winningLottoDto);

            return render(model, "result.html");
        });
    }

    static String render(Map<String, Object> model, String templatePath){
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
