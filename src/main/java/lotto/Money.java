package lotto;

import java.util.List;

public interface Money {

    public int get();

    public List<String> getPassiveLottoPapers();

    public LottoBuyingType getBuyingType();
}
