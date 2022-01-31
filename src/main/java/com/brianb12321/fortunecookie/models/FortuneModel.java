package com.brianb12321.fortunecookie.models;

import javax.persistence.*;

@Entity(name = "Fortune")
@Table()
public class FortuneModel {
    @Id
    @SequenceGenerator(
            name="fortuneId_sequence",
            sequenceName = "fortuneId_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fortuneId_sequence"
    )
    private long fortuneId;
    private boolean isMisfortune;
    private String fortuneText;

    public FortuneModel() {
    }

    public FortuneModel(boolean isMisfortune, String fortuneText) {
        this.isMisfortune = isMisfortune;
        this.fortuneText = fortuneText;
    }

    public FortuneModel(long fortuneId, boolean isMisfortune, String fortuneText) {
        this.fortuneId = fortuneId;
        this.isMisfortune = isMisfortune;
        this.fortuneText = fortuneText;
    }

    public long getFortuneId() {
        return fortuneId;
    }

    public boolean isMisfortune() {
        return isMisfortune;
    }

    public String getFortuneText() {
        return fortuneText;
    }

    public void setFortuneId(long fortuneId) {
        this.fortuneId = fortuneId;
    }

    public void setMisfortune(boolean misfortune) {
        isMisfortune = misfortune;
    }

    public void setFortuneText(String fortuneText) {
        this.fortuneText = fortuneText;
    }
}