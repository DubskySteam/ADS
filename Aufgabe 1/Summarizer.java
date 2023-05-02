import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.time.Clock;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * @author Clemens Maas
 * @Matrikelnummer 1260892
 * @date 19.04.2023
 */
public class Summarizer {

    private ArrayList<Integer> values = new ArrayList<>();
    private int max_sum = Integer.MIN_VALUE;
    private int  n, sum, _from, _to;
    private long start, end;
    private String path;
    private long additions;

    public Summarizer(String path) {
        this.path = path;
    }

    public void start() {
        readFile(path);
        n = values.size();
        start = Clock.systemUTC().millis();
        for(int i = 1; i < n; i++) {
            for(int j = i; j < n; j++) {
                sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += values.get(k);
                    additions++;
                }
                if(sum > max_sum) {
                    max_sum = sum;
                    _from = i;
                    _to = j;
                }
            }
        }
        end = Clock.systemUTC().millis();
        System.out.println("max. Teilsumme " + max_sum);
        System.out.println("erster Index " + _from);
        System.out.println("letzter Index " + _to);
        System.out.println("Additions " + additions);
        System.out.println("Runtime " + (end - start) + "ms");
    }

    private void readFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                values.add(Integer.parseInt(line));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO Exception");
            e.printStackTrace();
        }
    }

}
