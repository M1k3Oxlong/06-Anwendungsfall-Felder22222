package control;

import model.CompactDisc;

/**
 * Created by Jean-Pierre on 21.10.2016.
 */
public class CDCollectionHandler {

    private CompactDisc[][] allCDs;

    /**
     * Die Anzahl an Platzgrößen gibt die Anzahl an CD-Ständern vor - hier 4.
     * Die CD-Ständer an sich sind so groß wie die jeweilige Platzgröße.
     *
     * @param amounts - Platzgrößen der einzelnen CD-Ständer.
     */
    public CDCollectionHandler(int[] amounts){
        //TODO: 01 - Konstruktor fertigstellen.
        allCDs = new CompactDisc[4][];
        for(int i=0; i<allCDs.length; i++){
            allCDs[i] = new CompactDisc[amounts[i]];
        }

    }

    /**
     * Diese Methode dient dazu, eine neue CD zu instanziieren und sie an die vorgebene Stelle zu packen, sofern dort ein Platz frei ist.
     *
     * @param box - Index des gewählten CD-Ständers
     * @param place - Index des gewählten Platzes
     * @param artist - Künstername/Bandname
     * @param title - Albumtitel
     * @return - true, falls ein Platz frei war und die CD hinzugefügt werden konnte, sonst false.
     */
    public boolean addNewCD(int box, int place, String artist, String title){
        //TODO: 02 - Hinzufügen einer CD
        if(allCDs[box][place]==null) {
            allCDs[box][place] = new CompactDisc(artist, title);
            return true;
        }
        return false;
    }

    /**
     * Diese Methode dient dazu, die Daten einer bestimmten Position im zweidimensionalem Array auszugeben.
     *
     * @param box - Index des gewählten CD-Ständers
     * @param place - Index des gewählten Platzes
     * @return - Entweder ein String-Array mit "Künstler" - "Titel" oder mit "Empty" - "Empty".
     */
    public String[] getInfo(int box, int place){
        String[] output;
        //TODO: 03 - Informationen zu einer bestimmen CD
        if(allCDs[box][place]!=null) {
            output = new String[]{allCDs[box][place].getArtist(), allCDs[box][place].getTitle()};
        }else{
            output = new String[]{"Empty", "Empty"};
        }
        return output;
    }

    /**
     * Diese Methode dient dem Entfernen einer CD.
     *
     * @param box - Index des gewählten CD-Ständers
     * @param place - Index des gewählten Platzes
     * @return - true, falls eine vorhandene CD entfernt wurde, false, falls keine Cd zum entfernen vorhanden war.
     */
    public boolean releaseCD(int box, int place){
        //TODO: 04 - Entfernen einer bestimmten CD
        if(allCDs[box][place]!=null){
            allCDs[box][place]=null;
            return true;
        }
        return false;
    }

    /**
     * Diese Methode dient dazu, die enthaltenen Daten aufzubereiten und als String-Array auszugeben.
     *
     * @param box - CD-Ständer, um den es sich handelt.
     * @return Ein Array, das abwechselnd den jeweiligen Künstler und den jeweiligen Albumtitel enthält. Leere Plätze werden mit "Empty" gefüllt.
     */
    public String[] getAllCDsFrom(int box){
        //TODO: 05 - Vollständige Informationsausgabe aller CDs - Nach Fertigstellung im MainPanelHandler Zeile 165-167 entkommentieren
        String[] tmpA = new String[allCDs[box].length*2];
        for(int i=0;i<allCDs[box].length; i++){
            if(allCDs[box][i]==null){
                tmpA[i*2] = "Empty";
                tmpA[i*2+1] = "Empty";
            }else{
                tmpA[i*2] = allCDs[box][i].getArtist();
                tmpA[i*2+1] = allCDs[box][i].getTitle();
            }
        }
        return tmpA;
    }

    /**
     * Diese Methode dient dazu, einen CD-Ständer zu komprimieren. Dabei rücken spätere CDs einfach auf. Die vorhandene Sortierung bleibt erhalten.
     *
     * @param box - Index des Gewählten CD-Ständers
     */
    public void pack(int box){
        //TODO: 06 - Komprimieren eines CD-Ständers, von unten nach oben
        int firstEmptySlot = 0;
        for(int j=0;j< allCDs[box].length; j++) {
            if (allCDs[box][j] == null){
                for (int i = 0; i < allCDs[box].length-j; i++) {
                    if(allCDs[box][j+i]!=null){
                        allCDs[box][j]=allCDs[box][j+i];
                        allCDs[box][j+i]=null;
                        i = allCDs.length-j+1;
                    }
                }
            }

        }

    }


    /**
     * Diese Methode dient dazu, einen CD-Ständer zu sortieren nach Artist+Title. Gleichzeitig wird der CD-Ständer komprimiert.
     * Hierzu bitte nach der Methode "compareTo(String s)" für Java suchen.
     *
     * @param box - Gewählter CD-Ständer
     */
    public void sort(int box){
        //TODO: 07 - Sortieren eines CD-Ständers
        for(int i=0; i<allCDs[box].length-1; i++){
            //allCDs[box][i].getArtist().compareTo(allCDs[box][j].getArtist() > 0 )
        }
    }
}
