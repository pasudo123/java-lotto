package lotto.model;

import java.util.Collections;
import java.util.List;

public class ManualLottoPapers {

    final List<String> manualLottoPapers;

    private ManualLottoPapers(final List<String> manualLottoPapers){
        this.manualLottoPapers = manualLottoPapers;
    }

    public static ManualLottoPapers from(final List<String> manualLottoPapers){
        validate(manualLottoPapers);
        return new ManualLottoPapers(manualLottoPapers);
    }

    public static ManualLottoPapers empty(){
        return new ManualLottoPapers(Collections.emptyList());
    }

    private static void validate(final List<String> manualLottoPapers) {
        if(manualLottoPapers == null){
            throw new IllegalArgumentException("수동 로또가 널로 입력되었습니다.");
        }
    }

    public List<String> getManualLottoPapers(){
        return manualLottoPapers;
    }
}
