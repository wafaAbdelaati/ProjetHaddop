/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitparregion;

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
     public String getRegion() {
         if (this.champs[0].isEmpty())
         {
            return null;
         }
         return champs[0];
    }

    public void setRegion(String region) {
        this.champs[0] = region;
    }
    public String getCountry() {
        return champs[1];
    }

    public void setCountry(String country) {
        this.champs[1] = country;
    }
    public String getItemType() {
        return champs[2];
    }

    public void setItemType(String itemType) {
        this.champs[2] = itemType;
    }
    
    public double getTotalProfit() {
          if (this.champs[13].isEmpty())
         {
            return 0;
         }
        return Double.parseDouble(champs[13]);
    }

  
}
