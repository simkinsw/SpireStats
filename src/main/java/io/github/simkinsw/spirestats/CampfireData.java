package io.github.simkinsw.spirestats;

import javax.persistence.*;

@Entity
@Table(name = "campfires")
public class CampfireData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String data;
    public int floor;
    public String key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "run_id")
    public RunData runData;
}
