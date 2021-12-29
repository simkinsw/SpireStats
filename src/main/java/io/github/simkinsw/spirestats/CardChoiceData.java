package io.github.simkinsw.spirestats;

import javax.persistence.*;

@Entity
@Table(name = "cardChoices")
public class CardChoiceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String cardName;
    public boolean upgraded;
    public boolean picked;
    public int floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "run_id")
    public RunData runData;

    public CardChoiceData() {}

    public CardChoiceData(String name, boolean pick, int flo, RunData run) {
        picked = pick;
        floor = flo;
        runData = run;

        if (name.contains("+")) {
            cardName = name.substring(0, name.length() - 1);
            upgraded = true;
        }
        else {
            cardName = name;
            upgraded = false;
        }
    }
}
