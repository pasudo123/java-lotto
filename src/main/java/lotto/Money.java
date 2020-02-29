package lotto;

import java.util.List;

public interface Money {

    int get();

    List<String> getPassiveLottoPapers();

    LottoBuyingType getBuyingType();
}
