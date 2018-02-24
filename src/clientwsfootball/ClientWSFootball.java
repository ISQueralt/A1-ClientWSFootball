package clientwsfootball;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;

import java.util.Scanner;

public class ClientWSFootball {

 
    public static void main(String[] args) {
        System.out.print("1 - Get yellow cards\n\n2 - Get all defenders"
                + "\n\n3 - Get all defenders of all countries.\n\nEnter a "
                + "option: ");
        
        int selection = new Scanner(System.in).nextInt();
        
        switch (selection) {
            case 1: 
                System.out.print(getYellowCards());
                break;
                
            case 2:
                System.out.print(getAllDefenders());
                break;
                
            case 3: 
                System.out.print(getDefendersAllCountries());
                break;
               
            default: 
                System.out.println("\nThe number of selection is incorrect.");
                
        }
       
        
    }

    /*
    * @return : All yellow cards in total
    */
    private static String getYellowCards() {
        return ("Yellow cards total = " + yellowCardsTotal());
    }
    
    /*
    * @return : All all defenders of one city that user entered 
    */
    private static String getAllDefenders() {
        System.out.print("Enter a city/country: ");
        String city = new Scanner(System.in).nextLine();
        return("All defenders of " + city + " are: \n" + 
                allDefenders(city).getString());
    }
    
    /*
    * @return : All all defenders of all the countries
    */
    private static String getDefendersAllCountries() {
        String result = "";
                for(TCountryInfo info : countryNames(true).getTCountryInfo()) {
                    result += info.getSName() + "\n" + 
                            allDefenders(info.getSName()).getString() + "\n";     
                }
        return result;
    }
    
    
    private static int yellowCardsTotal() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOfString cities() {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.cities();
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        eu.dataaccess.footballpool.Info service = new eu.dataaccess.footballpool.Info();
        eu.dataaccess.footballpool.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }   
}