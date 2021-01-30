/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitparcountry;

/**
 *
 * @author hadoop
 */
public class Sales {
    private  String[] champs;

 public Sales(String line) {
        this.champs = line.split(",");
    }
 public String[] getChamps() {
        return champs;
    }

    public void setChamps(String[] champs) {
        this.champs = champs;
    }


    public String getCountry() {
        if (this.champs[1].isEmpty())
         {
            return null;
         }
         return champs[1];
  
    }

    public void setCountry(String country) {
        this.champs[1] = country;
    }
    
    
    public double getTotalProfit() {
        return Double.parseDouble(champs[13]);
    }
        

  
}
