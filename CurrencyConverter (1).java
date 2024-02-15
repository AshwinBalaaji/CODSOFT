import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
public class CurrencyConverter
{
    public static void main(String[] args) throws IOException
    {
        HashMap<Integer,String>currencycode=new HashMap<Integer,String>();
        currencycode.put(1,"USD");
        currencycode.put(2,"CAD");
        currencycode.put(3,"EUR");
        currencycode.put(4,"HKD");
        currencycode.put(5,"INR");
        
        String fromcode,tocode;
        double amount;
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the currency coverter");
        System.out.println("Currency converting FROM?");
        System.out.println("1:USD(US Dollar)\t 2:CAD(Canadian Dollar)\t 3:EUR(Euro)\t 4:HKD(Hong Kong Dollar)\t 5:INR(Rupee)");
        fromcode=currencycode.get(sc.next());
        
        System.out.println("Currency converting TO?");
        System.out.println("1:USD(US Dollar)\t 2:CAD(Canadian Dollar)\t 3:EUR(Euro)\t 4:HKD(Hong Kong Dollar)\t 5:INR(Rupee)");
        tocode=currencycode.get(sc.next());
        
        System.out.println("Enter the amount you wish to convert:");
        amount=sc.nextFloat();
        sendHttpGETRequest(fromcode,tocode,amount);
        
        System.out.println("Thank you for using the currency converter");
    }
    private static void sendHttpGETRequest(String fromcode,String tocode,double amount)
    {
        String GET_URL ="https://api.exchangerate.host/latest?base="+tocode+"&symbols"+fromcode;
        URL url=new URL(GET_URL);
        HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responsecode=httpURLConnection.getResponseCode();
        
        if(responsecode==HttpURLConnection.HTTP_OK)
        {
            BufferedReader in =new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response=new StringBuffer();
            
            while((inputLine=in.readLine())!=null)
            {
                response.append(inputLine);
            }in.close();
            
            JSONObject obj=new JSONObject(response.toString());
            Double exchangeRate=obj.getJSONObject("rates").getDouble(fromcode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate);
            System.out.println();
            System.out.println(amount+fromcode+" = "+amount/exchangeRate+tocode);
        }
        else
        {
            System.out.println("GET request failed!");
        }
        
        
        
    }
}
