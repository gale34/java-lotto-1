import lotto.model.LottoStore;
import lotto.model.LottoTickets;
import lotto.model.WinningLottoTicket;
import lotto.model.wrapper.LottoNumber;
import lotto.model.wrapper.Payment;

import java.util.Set;

import static lotto.utils.LottoUtil.convertTo;
import static lotto.view.InputView.*;
import static lotto.view.OutputView.printLottoResults;
import static lotto.view.OutputView.printLottoTickets;

public class Main {

    public static void main(String[] args) {
        Payment payment = Payment.of(inputPayment());
        LottoTickets manualLottoTickets = LottoTickets.newInstance(convertTo(inputManualLotto()));
        LottoTickets lottoTickets = LottoStore.sell(payment, manualLottoTickets);

        printLottoTickets(lottoTickets, manualLottoTickets.size());

        WinningLottoTicket winningLottoTicket = inputWinningLottoTicket();

        printLottoResults(lottoTickets.checkAll(winningLottoTicket));
    }

    private static WinningLottoTicket inputWinningLottoTicket() {
        String winningNumberString = inputWinningNumber();
        Set<LottoNumber> winningNumbers = convertTo(winningNumberString);

        int bonusNumber = inputBonusNumber();

        return WinningLottoTicket.newInstance(winningNumbers, LottoNumber.of(bonusNumber));
    }

}
