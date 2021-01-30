
package profitparcountry;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class ModeleMapReduceDriver extends Configured implements Tool
{

    @Override
    public int run(String[] args) throws Exception
    {
        // vérifier les paramètres
        if (args.length != 2) {
            System.err.println("Usage: ModeleMapReduceDriver <input path> <outputpath>");
            System.exit(-1);
        }

        // instant de démarrage
        Long initTime = System.currentTimeMillis();

         //créer le job map-reduce
        Configuration conf = this.getConf();
        Job job = Job.getInstance(conf, "ModeleMapReduce Job");
        job.setJarByClass(ModeleMapReduceDriver.class);

        // définir les classes Mapper, Reducer et Combiner si nécessaire
        job.setMapperClass(ModeleMapReduceMapper.class);
        job.setReducerClass(ModeleMapReduceReducer.class);
       // job.setCombinerClass(ModeleMapReduceCombiner.class);

       //  définir les données d'entrée
        job.setInputFormatClass(TextInputFormat.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));   /// VOIR ENTREES= DANS LE MAKEFILE
        FileInputFormat.setInputDirRecursive(job, false);       // mettre true si les fichiers sont dans des sous-dossiers

        // sorties du mapper = entrées du reducer et entrées et sorties du combiner
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(DoubleWritable.class);

    //     sorties du reducer
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

    //     définir les données de sortie : dossier et types des clés et valeurs
        job.setOutputFormatClass(TextOutputFormat.class);
        FileOutputFormat.setOutputPath(job, new Path(args[1])); /// VOIR SORTIE= DANS LE MAKEFILE

  //       lancer le job et attendre sa fin en comptant les secondes
        Long startTime = System.currentTimeMillis();
        boolean success = job.waitForCompletion(true);
        Long endTime = System.currentTimeMillis();
        System.out.println("Job Duration seconds: " + ((endTime-startTime)/1000L));
        System.out.println("Total Duration seconds: " + ((endTime-initTime)/1000L));
        return success ? 0 : 1;
    }
    


    public static void main(String[] args) throws Exception
    {
        // préparer et lancer un job en lui passant les paramètres
        ModeleMapReduceDriver driver = new ModeleMapReduceDriver();
        int exitCode = ToolRunner.run(driver, args);
        System.exit(exitCode);
    }
}
