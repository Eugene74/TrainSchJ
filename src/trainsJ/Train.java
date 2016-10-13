package trainsJ;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="train")
@XmlType(propOrder = {"from", "to","date","departure"}) // задаёт порядок вывода елементов
public class Train {
    private int id;
    private String from;
    private String to;
    private String sdate;
    private String departure;

    public Train(){ }

     Train(int id, String from, String to, String dt, String time){
        this.id = id;
        this.from = from;
        this.to = to;
        this.sdate = dt;
        this.departure = time;
    }
     String getDeparture() {
        return departure;
    }
    @XmlElement
     void setDeparture(String departure) {
        this.departure = departure;
    }
     String getFrom() {
        return from;
    } @XmlElement
     void setFrom(String from) {
        this.from = from;
    }
     String getTo() {
        return to;
    }
    @XmlElement
     void setTo(String to) {
        this.to = to;
    }
     String getDate() {
        return sdate;
    }
    @XmlElement
     void setDate(String date) {
        this.sdate = date;
    }
     int getId() {
        return id;
    }
    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        return   sb.append("Train:id= "+id+"; from= "+from+"; to= "+to+"; date= "+sdate+"; departure= "+departure).toString();
    }
}
