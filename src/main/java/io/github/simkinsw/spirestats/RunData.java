package io.github.simkinsw.spirestats;

public class RunData {
    String play_id;
    boolean victory;
    String[] master_deck;


    public String ToString()
    {
        return "Play ID: " + play_id + "Victory: " + victory + "Deck: " + master_deck;
    }

    @Override
    public boolean equals(Object o)
    {
        RunData other = (RunData)o;
        return other.play_id == this.play_id && other.victory == this.victory;
    }
}
