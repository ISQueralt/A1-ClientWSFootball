package clientwsfootball;

import eu.dataaccess.footballpool.ArrayOfString;
import eu.dataaccess.footballpool.ArrayOftCountryInfo;
import eu.dataaccess.footballpool.TCountryInfo;

public class ClientWSFootball {

 
    public static void main(String[] args) {
        //System.out.print("Yellow cards total = " + yellowCardsTotal());
        //System.out.print("Todos los defensas = " + allDefenders("Lyon").getString());
        
        // Todos los defensas de todos los países 
        String result = "";
        for(TCountryInfo info : countryNames(true).getTCountryInfo()) {
                result += info.getSName() + "\n" + allDefenders(info.getSName()).getString() + "\n";     
        }
        
        System.out.print(result);
        
        // Todos los defensas de todas las ciudades
        result = "";
        
        for(Object city : cities().getString()) {
            result += city.toString() + ":\n" + allDefenders(city.toString()).getString() + "\n";
        }
        
        //System.out.print(result);
        
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