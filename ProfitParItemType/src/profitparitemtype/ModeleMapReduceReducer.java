/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profitparitemtype;
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
/**
 *
 * @author hadoop
 */
public class ModeleMapReduceReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{
    // allocation mémoire de la clé et valeur de sortie
    private Text cleS;
    private DoubleWritable valeurS = new DoubleWritable();
@Override
    public void reduce(Text cleI, Iterable<DoubleWritable> valeursI, Context context)
            throws IOException, InterruptedException
    {
        cleS = cleI;
        double resultat = 0;
        for (DoubleWritable valeurI : valeursI) {
            double val = valeurI.get();
            resultat = resultat+val;
        }
        valeurS.set(resultat);
        context.write(cleS, valeurS);
    }
    
    
}
