package misc.stackoverflow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Anand_Rajneesh on 11/2/2016.
 */
public class ClientSearch{
    private String clientNumber;
   // private String queueNumber;
    private String clientName;
    private String customerName;


    public ClientSearch(String clientNumber, String clientName, String customerName) {
        this.clientNumber = clientNumber;
        //this.queueNumber = queueNumber;
        this.clientName = clientName;
        this.customerName = customerName;
    }

    public String toString(){
        return clientNumber+" "+clientName+" "+customerName;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\anand_rajneesh\\IdeaProjects\\Kata\\src\\main\\java\\misc\\stackoverflow\\input.txt"));
            String tmp = null;
            List<ClientSearch> list = new ArrayList<>();
            while((tmp=br.readLine())!=null){
                String split [] = tmp.split(" ");
                list.add(new ClientSearch(split[0],split[1],split[2]));
            }
            System.out.println("Sorting.....");
            list.sort(new Comparator<ClientSearch>() {
                @Override
                public int compare(ClientSearch o1, ClientSearch o2) {
                    int diff = o1.clientNumber.compareTo(o2.clientNumber);
                    return diff ==0 ? o1.customerName.compareTo(o2.customerName) : diff;
                }
            });

            for (ClientSearch c : list){
                System.out.println(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
