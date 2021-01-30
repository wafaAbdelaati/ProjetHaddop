/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitparitemtype;
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
   
    public String getItemType() {
          if (this.champs[2].isEmpty())
         {
            return null;
         }
        return champs[2];
    }

    public void setItemType(String itemType) {
        this.champs[2] = itemType;
    }
    
    public double getTotalProfit() {
        return Double.parseDouble(champs[13]);
    }

  
}
