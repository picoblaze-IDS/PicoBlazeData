package picoblazedata;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dc386
 */
public class DataPacket {
    
    private static final int WORDS = 0;
    private static final int OUTPUT = 1;
    private static final int MAGIC = 5;
    private static final int MAXRAND = 10;
    private static final int MAXRUBBISH = 255;

    String filename;
    BufferedReader  buffer = null;
    List<String> words;
    String packet = "";
    
    private DataPacket()
    {
    }
    
    public DataPacket(String filename) throws IOException
    {
        try
        {
            String line;
            words = new ArrayList<String>();
            
            buffer = new BufferedReader(new FileReader(filename));
            while ((line = buffer.readLine()) != null)
                words.add(line);
            this.generatePacket();
            this.formatPacket();
        }
        catch(FileNotFoundException exc)
        {
            System.out.println("Error: File not found.");
            System.exit(0);
        }
    }
    
    private String formatPacket()
    {
        String result = "";
        
        for (int i = 0; i < packet.length(); i += 64)
        {
            if (i + 64 <= packet.length())
            {
                result += "INIT_" + String.format("%02x", i / 64).toUpperCase() + " => X\"";
                result += invertRow(packet.substring(i, i + 64));
                result += "\",\n";
            }
        }
        result = result.substring(0, result.length() -2);
        return (result.toUpperCase());
    }
    
    private void generatePacket()
    {
        Random random = new Random();
                
        for (int i = 0; i < 256;)
        {
            if (random.nextInt(MAXRAND) == MAGIC)
            {
                packet += putWord();
            }
            else
                packet += generateRubish();
            i = packet.length();
        }
    }
    
    private String putWord()
    {
        Random random = new Random();
        String hexaWords = "";
        String word = getWords().get(random.nextInt(getWords().size() - 1));
        
        if (random.nextInt(MAXRAND) > MAGIC)
            for (int i = 0; i < word.length(); i++)
                hexaWords += Integer.toString(word.charAt(i), 16);
        else
            for (int i = 0; i < (word.length() - random.nextInt(word.length())); i++)
                hexaWords += Integer.toString(word.charAt(i), 16);
        return hexaWords;
    }
    
    private String generateRubish()
    {
        String rubbish = "";
        Random random = new Random();
        
        for (int i = 0; i < random.nextInt(MAXRAND); i++)
        {
            rubbish += Integer.toString(random.nextInt(MAXRUBBISH), 16);
        }
        return rubbish;
    }
    
    public void print(int flag)
    {
        switch (flag){
            case WORDS: for (String word : words) {System.out.println(word);}
            break;
            case OUTPUT: System.out.println(formatPacket());
            break;
        }
    }
    
    private String invertRow(String row) {
        String result = "";
        int i = 0;
        while ((row.length() - 2 - i) >= 0) {
            result += row.substring(row.length() - 2 - i, row.length() - i);
            i += 2;
        }
        return result;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
    
}
