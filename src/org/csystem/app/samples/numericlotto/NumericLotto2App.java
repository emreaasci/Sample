/*--------------------------------------------------------------------------------------------------------------------
    NumericLottoApp sınıfı
---------------------------------------------------------------------------------------------------------------------*/

package org.csystem.app.samples.numericlotto;

import org.csystem.util.ArrayUtil;

import java.util.Scanner;

public class NumericLotto2App {
    private NumericLotto2App()
    {
    }
    public static void run()
    {
        Scanner kb = new Scanner(System.in);
        NumericLotto2 lotto = new NumericLotto2();

        for (;;) {
            System.out.print("Kaç kupon oynamak istersin?");
            int n = Integer.parseInt(kb.nextLine());

            if (n <= 0)
                break;

            ArrayUtil.display(2, lotto.getNumbers(n));
        }
    }
}