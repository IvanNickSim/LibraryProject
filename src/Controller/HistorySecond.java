package Controller;

import View.HistoryScreenFirst;
import View.HistoryScreenSecond;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class HistorySecond {

    private HistoryScreenSecond theHistorySecond;
    private HistoryScreenFirst theHistoryFirst;

    public HistorySecond(HistoryScreenSecond theHistorySecond, HistoryScreenFirst theHistoryFirst){

        this.theHistorySecond = theHistorySecond;
        this.theHistoryFirst = theHistoryFirst;

        this.theHistorySecond.backBtnListener(new backButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHistorySecond.dispose();
                theHistoryFirst.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

}
