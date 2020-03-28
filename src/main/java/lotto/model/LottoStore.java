package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoPurchaseTickets sell(final Payment payment) {
        List<LottoPurchaseTicket> lottoPurchaseTickets = IntStream.range(0, payment.countLotto())
                .mapToObj(i -> LottoPurchaseTicket.newInstance())
                .collect(Collectors.toList());
        return LottoPurchaseTickets.create(lottoPurchaseTickets);
    }
}