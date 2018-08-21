package Controller;

import View.HistoryScreenFirst;
import View.HistoryScreenSecond;
import View.HomeScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by megat0n on 19/08/2018.
 */
public class HistoryFirst {

    private HistoryScreenFirst theHistoryFirst;
    private HomeScreen theHomeScreen;
    private HistoryScreenSecond theHistorySecond;

    public HistoryFirst(HistoryScreenFirst theHistoryFirst, HomeScreen theHomeScreen, HistoryScreenSecond theHistorySecond){

        this.theHistoryFirst = theHistoryFirst;
        this.theHomeScreen = theHomeScreen;
        this.theHistorySecond = theHistorySecond;

        this.theHistoryFirst.backBtnListener(new backButtonListener());
        this.theHistoryFirst.nextBtnListener(new nextButtonListener());

    }

    class backButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHistoryFirst.dispose();
                theHomeScreen.setVisible(true);
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    class  nextButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                theHistoryFirst.dispose();
                theHistorySecond.setVisible(true);
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }

}
