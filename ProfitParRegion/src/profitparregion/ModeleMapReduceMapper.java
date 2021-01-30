/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitparregion;


import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
/**
 *
 * @author hadoop
 */
public class ModeleMapReduceMapper extends Mapper<LongWritable, Text, Text, DoubleWritable>  {
    // allocation mémoire de la clé et valeur de sortie
    private Text cleI = new Text();
    private DoubleWritable valeurI = new DoubleWritable();
    
    public void map(LongWritable cleE, Text valeurE, Context context)
            throws IOException, InterruptedException
    {
      
        String ligne = valeurE.toString();
   
        try {

           Sales sale = new Sales(ligne);
            cleI.set(new Text(""+sale.getRegion()+""));
            valeurI.set(sale.getTotalProfit());
            // émettre la paire (clé, valeur) vers le reducer
            context.write(cleI, valeurI);

        } catch (Exception e) {
            // ignorer l'exception ou l'afficher => consulter les logs de stderr
            //System.err.println(e.getStackTrace()[0]+": "+e.getMessage()+" => "+e+" sur la ligne "+ligne);
        }
    }
   
}
   
