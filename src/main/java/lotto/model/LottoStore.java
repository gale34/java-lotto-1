package lotto.model;

import lotto.model.wrapper.Payment;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private LottoStore() {
    }

    public static LottoTickets sell(final Payment payment, final LottoTickets manualLottoTickets) {
        int automaticLottoCount = countAutomaticLottoTickets(payment, manualLottoTickets.size());

        List<LottoTicket> lottoTickets = IntStream.range(0, automaticLottoCount)
                .mapToObj(i -> LottoTicket.newInstance())
                .collect(Collectors.toList());

        return manualLottoTickets.merge(lottoTickets);
    }

    private static int countAutomaticLottoTickets(final Payment payment, final int manualLottoTickets) {
        if(payment.countLottoTicket() - manualLottoTickets < 0) {
            throw new IllegalArgumentException("payment is insufficient to buy lotto tickets.");
        }
        return payment.countLottoTicket() - manualLottoTickets;
    }
}
