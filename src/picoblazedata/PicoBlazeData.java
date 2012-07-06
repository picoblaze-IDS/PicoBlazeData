/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package picoblazedata;

import java.io.IOException;

/**
 *
 * @author dc386
 */
public class PicoBlazeData {
    
    private static final int WORDS = 0;
    private static final int OUTPUT = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        DataPacket dataPacket = new DataPacket(args[0]);
        
        dataPacket.print(OUTPUT);
    }
}
