package trainsJ;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name="trans")

 class Trains {

    @XmlElement(name="train")
    private List<Train> trains = new ArrayList<Train>();

     void add(Train train) {
        int i = 0;
        for (Train train1: trains) {
            if (train.getId() == train1.getId()) {// проаерка чтобы не добавлять одинаковые "поезда"
                i++;
            }
        }
        if(i==0){
            trains.add(train);
        }else System.out.println("Такой поезд уже существует в расписании");
    }

     List<Train> getList(){
        return trains;    }
     void deleteTrain(int id){
    }

    @Override
    public  String toString(){
        return Arrays.deepToString(trains.toArray());
    }


}
