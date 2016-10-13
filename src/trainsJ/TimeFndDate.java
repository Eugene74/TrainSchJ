package trainsJ;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 class TimeAndDate {

    public TimeAndDate() {
    }
    public List<Train> search(String sTime,  String eTime, Trains trains ){
        Date startT= null;
        Date endT = null;
        Date trDa = null;
        DateFormat df = new SimpleDateFormat("dd.MM.yyyyhh:mm");

        List <Train> trainListSearch = new ArrayList<>(0);

        try {
            startT = df.parse(sTime);
            endT = df.parse(eTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List <Train> trainList = trains.getList();
        for (Train train: trainList) {

            try {
                trDa=  df.parse(train.getDate()+train.getDeparture());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if( ( trDa.before(endT) ||trDa.equals(endT) )&& ( trDa.equals(startT)||trDa.after(startT) ) ){
                trainListSearch.add(train);
            }
        }
        return trainListSearch;
    }
}