package trainsJ;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Scanner;

public class MyClass {

    private static String sdata;
    private static String stimeStart;
    private static String stimeEnd;

    public static void main(String[] args) {
        Trains trains ;
        try {
            File file1 = new File("I:\\AllProgram\\fileFromProgram\\trainSchedule.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trains.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            trains = (Trains) unmarshaller.unmarshal(file1);

            trains.add(new Train(3,"Kiev", "Kharkov", "7.12.2016", "17:05"));
            trains.add(new Train(4,"Lviv", "Kiev", "7.12.2016", "18:25"));
            trains.add(new Train(5,"Lutck", "Kharkov", "7.12.2016", "19:05"));
            trains.add(new Train(6,"Dnepr", "Kiev", "7.12.2016", "18:44"));

            List <Train> trainListFromSearch= searchTrainTime(trains);
            if(trainListFromSearch.size()==0){
                System.out.println("В данный период времени поездов в расписании нет.");
            }else {
                System.out.println(sdata+" "+"c "+ stimeStart+"  по "+stimeEnd+" идут такие "+trainListFromSearch.size()+ " поезда: ");
                for (Train train: trainListFromSearch) {
                    System.out.println( train);
                }
            }

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // пишем в файл
            marshaller.marshal(trains, file1);
            // marshaller.marshal(trains,System.out );


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static List<Train> searchTrainTime(Trains trains){

        TimeAndDate timeAndDate = new TimeAndDate();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Date departure (like this 12.12.2012 (DD.MM.YYYY)) :");
        sdata = sc.nextLine();
        System.out.println("Enter the Time \"up\" (like this 12:12 (hh:MM)) :");
        stimeStart = sc.nextLine();
        System.out.println("Enter the Time \"to\" (like this 12:12 (hh:MM)) :");
        stimeEnd = sc.nextLine();

        return  timeAndDate.search(sdata+stimeStart, sdata+stimeEnd,  trains );
    }

}